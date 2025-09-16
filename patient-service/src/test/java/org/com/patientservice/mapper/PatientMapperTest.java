package org.com.patientservice.mapper;

import org.com.patientservice.dto.PatientRequestDTO;
import org.com.patientservice.dto.PatientResponseDTO;
import org.com.patientservice.exception.EmptyComponentException;
import org.com.patientservice.exception.EmptyEntityException;
import org.com.patientservice.model.Patient;
import org.com.patientservice.model.genders.Gender;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class PatientMapperTest {

    PatientMapper patientMapper;

    @Test
    void toDTOShouldMapPatientToDTO() {
        Patient patient = Patient.builder()
                .id(UUID.fromString("bcfe825a-700b-488e-8955-50bd5887b9c3"))
                .firstName("John")
                .lastName("Doe")
                .gender(Gender.MALE)
                .weight(80.3)
                .height(180.5)
                .email("johndoe@exapmle.com")
                .phoneNumber("1234567890")
                .dateOfBirth(LocalDate.parse("2001-03-09"))
                .address("Test Address")
                .registeredDate(LocalDate.now())
                .build();

        PatientResponseDTO toDTO = PatientMapper.toDTO(patient);

        assertThat(toDTO.getId()).isEqualTo("bcfe825a-700b-488e-8955-50bd5887b9c3");
        assertThat(toDTO.getFirstName()).isEqualTo("John");
        assertThat(toDTO.getLastName()).isEqualTo("Doe");
        assertThat(toDTO.getWeight()).isEqualTo("80.3");
        assertThat(toDTO.getHeight()).isEqualTo("180.5");
        assertThat(toDTO.getEmail()).isEqualTo("johndoe@exapmle.com");
        assertThat(toDTO.getPhoneNumber()).isEqualTo("1234567890");
        assertThat(toDTO.getDateOfBirth()).isEqualTo("2001-03-09");
        assertThat(toDTO.getAddress()).isEqualTo("Test Address");
    }

    @Test
    void toDTOShouldThrowExceptionWhenNullPatient(){
        Patient patient =  null;

        Assertions.assertThrows(EmptyEntityException.class, ()  -> PatientMapper.toDTO(patient));
    }

    @Test
    void validateShouldThrowExceptionWhenPatientIsEmpty(){
        Patient patient = Patient.builder()
                .id(UUID.randomUUID())
                .firstName("")
                .lastName("Doe")
                .gender(Gender.MALE)
                .weight(80.3)
                .height(180.5)
                .email("johndoe@exapmle.com")
                .phoneNumber("1234567890")
                .dateOfBirth(LocalDate.parse("2001-03-09"))
                .address("Test Address")
                .registeredDate(LocalDate.now())
                .build();

        Assertions.assertThrows(EmptyComponentException.class, ()  -> PatientMapper.toDTO(patient));

    }

    @Test
    void toModelShouldMapPatientRequestToModel() {
        PatientRequestDTO patientRequestDTO = PatientRequestDTO.builder()
                .firstName("Rocky")
                .lastName("Balboa")
                .gender(Gender.MALE)
                .weight(80.3)
                .height(180.5)
                .email("testmail@test.com")
                .phoneNumber("1111111111")
                .dateOfBirth(LocalDate.parse("1978-03-01"))
                .address("Test Street 34")
                .registeredDate(LocalDate.parse("2023-01-01"))
                .build();

        Patient patient = patientMapper.toModel(patientRequestDTO);

        assertThat(patient.getFirstName()).isEqualTo("Rocky");
        assertThat(patient.getLastName()).isEqualTo("Balboa");
        assertThat(patient.getWeight()).isEqualTo(80.3);
        assertThat(patient.getHeight()).isEqualTo(180.5);
        assertThat(patient.getEmail()).isEqualTo("testmail@test.com");
        assertThat(patient.getPhoneNumber()).isEqualTo("1111111111");
        assertThat(patient.getDateOfBirth()).isEqualTo("1978-03-01");
        assertThat(patient.getAddress()).isEqualTo("Test Street 34");
        assertThat(patient.getRegisteredDate()).isEqualTo("2023-01-01");
    }

    @Test
    void toModelShouldThrowExceptionWhenPatientRequestIsNull(){
        PatientRequestDTO patientRequestDTO = null;

        Assertions.assertThrows(EmptyComponentException.class, ()  -> PatientMapper.toModel(patientRequestDTO));
    }

    @Test
    void toModelShouldThrowExceptionWhenPatientIsEmpty() {
        PatientRequestDTO patientRequestDTO = PatientRequestDTO.builder()
                .firstName("")
                .lastName("Balboa")
                .gender(Gender.MALE)
                .weight(80.3)
                .height(180.5)
                .email("testmail@test.com")
                .phoneNumber("1111111111")
                .dateOfBirth(LocalDate.parse("1973-03-01"))
                .address("Test Street 34")
                .registeredDate(LocalDate.parse("2023-01-01"))
                .build();

        Assertions.assertThrows(EmptyEntityException.class, ()  -> PatientMapper.toModel(patientRequestDTO));
    }
}