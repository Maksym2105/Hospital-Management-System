package org.com.meetingservice.service;

import org.com.meetingservice.additional.MeetingStatus;
import org.com.meetingservice.client.DoctorClient;
import org.com.meetingservice.client.PatientClient;
import org.com.meetingservice.dto.DoctorResponseDTO;
import org.com.meetingservice.dto.MeetingResponse;
import org.com.meetingservice.dto.PatientResponseDTO;
import org.com.meetingservice.dto.ScheduleResponseDTO;
import org.com.meetingservice.exception.InvalidMeetingException;
import org.com.meetingservice.exception.InvalidStatusException;
import org.com.meetingservice.exception.ScheduleNotAvailableException;
import org.com.meetingservice.model.Meeting;
import org.com.meetingservice.repository.MeetingRepository;
import org.com.meetingservice.requests.BookingRequest;
import org.com.meetingservice.requests.UpdateRequest;
import org.com.meetingservice.validation.DoctorValidation;
import org.com.meetingservice.validation.PatientValidation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.*;
import java.util.List;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@ExtendWith(SpringExtension.class)
public class MeetingServiceTest {

    @Mock
    private MeetingRepository meetingRepository;

    @Mock
    private DoctorClient doctorClient;

    @Mock
    private PatientClient patientClient;

    @Mock
    private DoctorValidation doctorValidation;

    @Mock
    private PatientValidation patientValidation;

    @InjectMocks
    private MeetingService meetingService;

    private BookingRequest bookingRequest;
    private DoctorResponseDTO doctorResponseDTO;
    private PatientResponseDTO patientResponseDTO;
    private UpdateRequest updateRequest;

    @BeforeEach
    void setUp() {
        String doctorId = UUID.randomUUID().toString();
        String patientId = UUID.randomUUID().toString();

        LocalDate mondayMeetingDate = LocalDate.of(2026, 2, 1);

        Instant meetingStartTime = mondayMeetingDate
                .atTime(10, 0)
                .atZone(ZoneId.systemDefault())
                .toInstant();

        Instant meetingEndTime = mondayMeetingDate
                .atTime(11, 0)
                .atZone(ZoneId.systemDefault())
                .toInstant();

        Instant meetingDate = mondayMeetingDate
                .atStartOfDay(ZoneId.systemDefault())
                .toInstant();

        this.bookingRequest = BookingRequest.builder()
                .doctorId(doctorId)
                .patientId(patientId)
                .meetingDate(meetingDate)
                .meetingStartTime(meetingStartTime)
                .meetingEndTime(meetingEndTime)
                .notes("Test")
                .build();

        ScheduleResponseDTO firstDoctorSchedule = ScheduleResponseDTO.builder()
                .scheduleStartTime("09:00:00")
                .scheduleEndTime("17:00:00")
                .scheduleDate("2026-02-01")
                .breakStartTime("12:00:00")
                .breakEndTime("13:00:00")
                .dayOfWeek("MONDAY")
                .isDayOff("false")
                .build();

        ScheduleResponseDTO secondDoctorSchedule = ScheduleResponseDTO.builder()
                .scheduleStartTime("10:00:00")
                .scheduleEndTime("16:00:00")
                .scheduleDate("2026-02-03")
                .breakStartTime("12:00:00")
                .breakEndTime("13:00:00")
                .dayOfWeek("WEDNESDAY")
                .isDayOff("false")
                .build();

        this.doctorResponseDTO = DoctorResponseDTO.builder()
                .id(doctorId)
                .firstName("Steven")
                .lastName("Rondon")
                .gender("MALE")
                .email("stevethedoc@test.com")
                .phoneNumber("+1270339512")
                .specialization("Surgeon")
                .rating("0.0")
                .doctorStatus("ACTIVE")
                .schedulesList(List.of(firstDoctorSchedule, secondDoctorSchedule))
                .build();

        this.patientResponseDTO = PatientResponseDTO.builder()
                .id(patientId)
                .firstName("Abella")
                .lastName("Cruz")
                .gender("FEMALE")
                .weight("65.3")
                .height("171.2")
                .email("mechanicbella@test.com")
                .phoneNumber("+1230392345")
                .dateOfBirth("2003-11-29")
                .address("Alexey 23 apt.5")
                .status("ACTIVE")
                .build();
    }

    @Test
    void bookMeetingShouldCreateMeeting() {
        String meetingId = "6966b86415de9141342edb20";

        when(doctorClient.getDoctorById(bookingRequest.getDoctorId()))
                .thenReturn(doctorResponseDTO);
        when(patientClient.getPatientById(bookingRequest.getPatientId()))
                .thenReturn(patientResponseDTO);

        Meeting meeting = Meeting.builder()
                .id(meetingId)
                .doctorId(UUID.fromString(doctorResponseDTO.getId()))
                .patientId(UUID.fromString(patientResponseDTO.getId()))
                .doctorFirstName(doctorResponseDTO.getFirstName())
                .doctorLastName(doctorResponseDTO.getLastName())
                .doctorSpecialization(doctorResponseDTO.getSpecialization())
                .patientFirstName(patientResponseDTO.getFirstName())
                .patientLastName(patientResponseDTO.getLastName())
                .date(bookingRequest.getMeetingDate())
                .startTime(bookingRequest.getMeetingStartTime())
                .endTime(bookingRequest.getMeetingEndTime())
                .status(MeetingStatus.CONFIRMED)
                .notes("Test")
                .build();

        when(meetingRepository.save(any(Meeting.class))).thenReturn(meeting);

        MeetingResponse response = meetingService.createMeeting(bookingRequest);

        Assertions.assertNotNull(response);

        verify(doctorClient).getDoctorById(bookingRequest.getDoctorId());
        verify(patientClient).getPatientById(bookingRequest.getPatientId());
    }

    @Test
    void bookMeetingShouldNotCreateIfDoctorStatusIsNotActive() {
        doctorResponseDTO.setDoctorStatus("INACTIVE");

        when(doctorClient.getDoctorById(bookingRequest.getDoctorId()))
                .thenReturn(doctorResponseDTO);
        when(patientClient.getPatientById(bookingRequest.getPatientId()))
                .thenReturn(patientResponseDTO);

        doThrow(InvalidStatusException.class)
                .when(doctorValidation)
                .checkDoctorStatus(doctorResponseDTO);

        Assertions.assertThrows(InvalidStatusException.class, () -> {
            meetingService.createMeeting(bookingRequest);
        });

        verify(meetingRepository, never()).save(any(Meeting.class));
    }

    @Test
    void bookMeetingShouldNotCreateIfPatientStatusIsNotActive() {
        doctorResponseDTO.setDoctorStatus("INACTIVE");

        when(doctorClient.getDoctorById(bookingRequest.getDoctorId()))
                .thenReturn(doctorResponseDTO);

        when(patientClient.getPatientById(bookingRequest.getPatientId()))
                .thenReturn(patientResponseDTO);

        doThrow(InvalidStatusException.class)
                .when(patientValidation)
                .checkPatientStatus(patientResponseDTO);

        Assertions.assertThrows(InvalidStatusException.class, () -> {
            meetingService.createMeeting(bookingRequest);
        });

        verify(meetingRepository, never()).save(any(Meeting.class));
    }

    @Test
    void bookMeetingShouldNotCreateIfDoctorScheduleIsEmpty() {
        doctorResponseDTO.setSchedulesList(List.of());

        when(doctorClient.getDoctorById(bookingRequest.getDoctorId()))
                .thenReturn(doctorResponseDTO);

        when(patientClient.getPatientById(bookingRequest.getPatientId()))
                .thenReturn(patientResponseDTO);

        doThrow(ScheduleNotAvailableException.class)
                .when(doctorValidation)
                .checkDoctorSchedule(doctorResponseDTO, bookingRequest.getMeetingStartTime(), bookingRequest.getMeetingEndTime());

        Assertions.assertThrows(ScheduleNotAvailableException.class, () -> {
            meetingService.createMeeting(bookingRequest);
        });

        verify(meetingRepository, never()).save(any(Meeting.class));
    }

    @Test
    void bookMeetingShouldNotCreateIfScheduleConflictOccurs() {
        LocalDate meetingDate = LocalDate.of(2026, 2, 3);

        Instant meetingStartTime = meetingDate
                .atTime(8, 0)
                .atZone(ZoneId.systemDefault())
                .toInstant();

        Instant meetingEndTime = meetingDate
                .atTime(9, 0)
                .atZone(ZoneId.systemDefault())
                .toInstant();

        Instant meetingActualDate = meetingDate
                .atStartOfDay(ZoneId.systemDefault())
                .toInstant();

        BookingRequest invalidRequest = BookingRequest.builder()
                .doctorId(doctorResponseDTO.getId())
                .patientId(patientResponseDTO.getId())
                .meetingStartTime(meetingStartTime)
                .meetingEndTime(meetingEndTime)
                .meetingDate(meetingActualDate)
                .notes("Test")
                .build();

        when(doctorClient.getDoctorById(bookingRequest.getDoctorId()))
                .thenReturn(doctorResponseDTO);

        when(patientClient.getPatientById(bookingRequest.getPatientId()))
                .thenReturn(patientResponseDTO);

        doThrow(ScheduleNotAvailableException.class)
                .when(doctorValidation)
                .checkDoctorSchedule(
                        doctorResponseDTO, invalidRequest.getMeetingStartTime(), invalidRequest.getMeetingEndTime());

        Assertions.assertThrows(ScheduleNotAvailableException.class, () -> {
            meetingService.createMeeting(invalidRequest);
        });

        verify(meetingRepository, never()).save(any(Meeting.class));
    }

    @Test
    void bookMeetingShouldNotCreateIfMeetingStartTimeIsOnDoctorBreakTime() {
        LocalDate meetingDate = LocalDate.of(2026, 2, 5);

        Instant meetingStartTime = meetingDate
                .atTime(12, 0)
                .atZone(ZoneId.systemDefault())
                .toInstant();

        Instant meetingEndTime = meetingDate
                .atTime(13, 0)
                .atZone(ZoneId.systemDefault())
                .toInstant();

        Instant actualMeetingDate = meetingDate
                .atStartOfDay(ZoneId.systemDefault())
                .toInstant();

        ScheduleResponseDTO doctorSchedule = ScheduleResponseDTO.builder()
                .scheduleStartTime("09:00:00")
                .scheduleEndTime("17:00:00")
                .scheduleDate("2026-02-05")
                .breakStartTime("12:00:00")
                .breakEndTime("13:00:00")
                .dayOfWeek("MONDAY")
                .isDayOff("false")
                .build();

        doctorResponseDTO.setSchedulesList(List.of(doctorSchedule));

        BookingRequest invalidRequest = BookingRequest.builder()
                .doctorId(doctorResponseDTO.getId())
                .patientId(patientResponseDTO.getId())
                .meetingStartTime(meetingStartTime)
                .meetingEndTime(meetingEndTime)
                .meetingDate(actualMeetingDate)
                .notes("Test")
                .build();

        when(doctorClient.getDoctorById(bookingRequest.getDoctorId()))
                .thenReturn(doctorResponseDTO);

        when(patientClient.getPatientById(bookingRequest.getPatientId()))
                .thenReturn(patientResponseDTO);

        doThrow(InvalidMeetingException.class)
                .when(doctorValidation)
                .checkDoctorSchedule(doctorResponseDTO, invalidRequest.getMeetingStartTime(), invalidRequest.getMeetingEndTime());

        Assertions.assertThrows(InvalidMeetingException.class, () -> {
            meetingService.createMeeting(invalidRequest);
        });

        verify(meetingRepository, never()).save(any(Meeting.class));
    }
}