package org.com.doctorservice.mapper;

import org.com.doctorservice.dto.DoctorRequestDTO;
import org.com.doctorservice.dto.DoctorResponseDTO;
import org.com.doctorservice.exception.EmptyComponentException;
import org.com.doctorservice.exception.EmptyModelException;
import org.com.doctorservice.exception.NotValidException;
import org.com.doctorservice.model.Doctor;
import org.com.doctorservice.model.gender.Genders;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DoctorMapperTest {

    private DoctorMapper docMapper;

    @Test
    void toResponseDTOShouldReturnDoctorResponseDTO() {
        Doctor doctor = Doctor.builder()
                .doctorId(UUID.randomUUID())
                .firstName("Jessy")
                .lastName("Mohawk")
                .gender(Genders.MALE)
                .email("test@mail.com")
                .phoneNumber("+111111111")
                .specialization("Obstetrician")
                .rating(BigDecimal.valueOf(7.3))
                .schedule("From Monday to Friday, From 9:00 AM to 18:00 PM")
                .build();

        DoctorResponseDTO doctorResponseDTO = DoctorMapper.toResponseDTO(doctor);

        assertThat(doctorResponseDTO.getId()).isEqualTo(doctor.getDoctorId().toString());
        assertThat(doctorResponseDTO.getFirstName()).isEqualTo(doctor.getFirstName());
        assertThat(doctorResponseDTO.getLastName()).isEqualTo(doctor.getLastName());
        assertThat(doctorResponseDTO.getEmail()).isEqualTo(doctor.getEmail());
        assertThat(doctorResponseDTO.getPhoneNumber()).isEqualTo(doctor.getPhoneNumber());
        assertThat(doctorResponseDTO.getSpecialization()).isEqualTo(doctor.getSpecialization());
        assertThat(doctorResponseDTO.getRating()).isEqualTo(doctor.getRating().toString());
        assertThat(doctorResponseDTO.getSchedule()).isEqualTo(doctor.getSchedule());
    }

    @Test
    void toResponseShouldThrowEmptyModelExceptionWhenDoctorIsNull() {
        Doctor doctor = null;

        Assertions.assertThrows(EmptyModelException.class, () -> DoctorMapper.toResponseDTO(doctor));
    }

    @Test
    void toResponseShouldThrowNotValidExceptionWhenArgumentIsNull() {
        Doctor doctor = Doctor.builder()
                .doctorId(UUID.randomUUID())
                .firstName("Jessy")
                .lastName("Mohawk")
                .gender(Genders.MALE)
                .email("")
                .phoneNumber("+111111111")
                .specialization("Obstetrician")
                .rating(BigDecimal.valueOf(7.3))
                .schedule("From Monday to Friday, From 9:00 AM to 18:00 PM")
                .build();

        Assertions.assertThrows(NotValidException.class, () -> DoctorMapper.toResponseDTO(doctor));
    }

    @Test
    void toModelShouldReturnEntity () {
        DoctorRequestDTO request = DoctorRequestDTO.builder()
                .firstName("Bob")
                .lastName("Incredible")
                .gender(Genders.MALE)
                .email("test@mail.com")
                .phoneNumber("+1 (440) 22 320 9006")
                .specialization("Dentist")
                .rating(BigDecimal.valueOf(0.0))
                .schedule("From Monday to Friday, From 9:00 AM to 17:00 PM")
                .build();

        Doctor doc = DoctorMapper.toModel(request);

        assertThat(doc.getFirstName()).isEqualTo(request.getFirstName());
        assertThat(doc.getLastName()).isEqualTo(request.getLastName());
        assertThat(doc.getGender()).isEqualTo(request.getGender());
        assertThat(doc.getEmail()).isEqualTo(request.getEmail());
        assertThat(doc.getPhoneNumber()).isEqualTo(request.getPhoneNumber());
        assertThat(doc.getSpecialization()).isEqualTo(request.getSpecialization());
        assertThat(doc.getRating()).isEqualTo(request.getRating());
        assertThat(doc.getSchedule()).isEqualTo(request.getSchedule());
    }

    @Test
    void toModelShouldThrowEmptyComponentExceptionWhenRequestIsNull () {
        DoctorRequestDTO request = null;

        Assertions.assertThrows(EmptyComponentException.class, () -> DoctorMapper.toModel(request));
    }

    @Test
    void toModelShouldThrowNotValidExceptionWhenRequestFieldIsEmpty() {
        DoctorRequestDTO request = DoctorRequestDTO.builder()
                .firstName("Bob")
                .lastName("Incredible")
                .gender(Genders.MALE)
                .email("test@mail.com")
                .phoneNumber("+1 (440) 22 320 9006")
                .specialization("")
                .rating(BigDecimal.valueOf(0.0))
                .schedule("From Monday to Friday, From 9:00 AM to 17:00 PM")
                .build();

        Assertions.assertThrows(NotValidException.class, () -> DoctorMapper.toModel(request));
    }
}