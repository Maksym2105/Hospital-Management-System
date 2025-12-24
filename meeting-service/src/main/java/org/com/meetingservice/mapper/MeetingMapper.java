package org.com.meetingservice.mapper;

import lombok.experimental.UtilityClass;
import org.com.meetingservice.additional.MeetingStatus;
import org.com.meetingservice.requests.BookingRequest;
import org.com.meetingservice.dto.DoctorResponseDTO;
import org.com.meetingservice.dto.MeetingResponse;
import org.com.meetingservice.dto.PatientResponseDTO;
import org.com.meetingservice.info.DoctorInfo;
import org.com.meetingservice.info.PatientInfo;
import org.com.meetingservice.model.Meeting;

import java.time.Instant;
import java.util.UUID;

@UtilityClass
public class MeetingMapper {

    public static Meeting toEntity(
            BookingRequest bookingRequest,
            DoctorResponseDTO  doctorResponse,
            PatientResponseDTO patientResponse) {

        Meeting meeting = Meeting.builder()
                .doctorId(UUID.fromString(bookingRequest.getDoctorId()))
                .patientId(UUID.fromString(bookingRequest.getPatientId()))
                .doctorFirstName(doctorResponse.getFirstName())
                .doctorLastName(doctorResponse.getLastName())
                .doctorSpecialization(doctorResponse.getSpecialization())
                .patientFirstName(patientResponse.getFirstName())
                .patientLastName(patientResponse.getLastName())
                .date(bookingRequest.getMeetingDate())
                .startTime(bookingRequest.getMeetingStartTime())
                .endTime(bookingRequest.getMeetingEndTime())
                .status(MeetingStatus.CONFIRMED)
                .notes(bookingRequest.getNotes())
                .createdAt(Instant.now())
                .updatedAt(Instant.now())
                .build();

        return meeting;
    }

    public static MeetingResponse toResponse(Meeting meeting) {
        MeetingResponse response = MeetingResponse.builder()
                .id(meeting.getId().toString())
                .meetingDate(meeting.getDate().toString())
                .startTime(meeting.getStartTime().toString())
                .endTime(meeting.getEndTime().toString())
                .meetingStatus(meeting.getStatus().toString())
                .notes(meeting.getNotes())
                .doctor(DoctorInfo.builder()
                        .firstName(meeting.getDoctorFirstName())
                        .lastName(meeting.getDoctorLastName())
                        .specialization(meeting.getDoctorSpecialization())
                        .build())
                .patient(PatientInfo.builder()
                        .firstName(meeting.getPatientFirstName())
                        .lastName(meeting.getPatientLastName())
                        .build())
                .createdAt(Instant.now().toString())
                .updatedAt(Instant.now().toString())
                .build();

        return response;
    }

}