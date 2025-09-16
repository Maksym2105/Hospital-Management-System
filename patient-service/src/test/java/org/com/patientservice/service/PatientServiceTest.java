package org.com.patientservice.service;

import org.com.patientservice.dto.PatientRequestDTO;
import org.com.patientservice.dto.PatientResponseDTO;
import org.com.patientservice.exception.EmailAlreadyExistsException;
import org.com.patientservice.exception.PatientNotFoundException;
import org.com.patientservice.model.Patient;
import org.com.patientservice.model.genders.Gender;
import org.com.patientservice.repository.PatientRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
public class PatientServiceTest {

    @Mock
    PatientRepository patientRepository;

    @InjectMocks
    PatientService patientService;

    @Test
    public void getPatientShouldReturnListOfPatient() {
        UUID patientId = UUID.randomUUID();

        Patient patient = Patient.builder()
                .id(patientId)
                .firstName("Emily")
                .lastName("Chomenko")
                .gender(Gender.MALE)
                .weight(80.3)
                .height(180.5)
                .email("testmail@test.com")
                .phoneNumber("+1 380 223 98 83")
                .dateOfBirth(LocalDate.parse("2004-09-01"))
                .address("Test Street 23/3")
                .registeredDate(LocalDate.now())
                .build();

        Patient patient2 = Patient.builder()
                .id(patientId)
                .firstName("David")
                .lastName("Chomenko")
                .gender(Gender.MALE)
                .weight(80.3)
                .height(180.5)
                .email("testmail@test.com")
                .phoneNumber("+1 380 223 98 83")
                .dateOfBirth(LocalDate.parse("2009-09-03"))
                .address("Test Block 23/3")
                .registeredDate(LocalDate.now())
                .build();

        when(patientRepository.findAll()).thenReturn(List.of(patient, patient2));

        List<PatientResponseDTO> patientResponseDTO = patientService.getPatients();

        assertThat(patientResponseDTO.size()).isEqualTo(2);
        assertThat(patientResponseDTO.get(0).getId()).isEqualTo(patient.getId().toString());
        assertThat(patientResponseDTO.get(1).getId()).isEqualTo(patient2.getId().toString());

    }

    @Test
    void getPatientShouldReturnEmptyListWhenNoPatientFound() {
        when(patientRepository.findAll()).thenReturn(List.of());

        List<PatientResponseDTO> patientResponseDTO = patientService.getPatients();

        assertThat(patientResponseDTO.size()).isEqualTo(0);
    }

    @Test
    void getPatientByIdShouldReturnPatient() {
        UUID patientId = UUID.randomUUID();

        Patient patient = Patient.builder()
                .id(patientId)
                .firstName("David")
                .lastName("Chomenko")
                .gender(Gender.MALE)
                .weight(80.3)
                .height(180.5)
                .email("testmail@test.com")
                .phoneNumber("+1 380 223 98 83")
                .dateOfBirth(LocalDate.parse("2009-09-03"))
                .address("Test Block 23/3")
                .registeredDate(LocalDate.parse("2020-01-01"))
                .build();

        when(patientRepository.findById(patientId)).thenReturn(Optional.of(patient));

        PatientResponseDTO patientResponseDTO = patientService.getPatientById(patientId);

        assertThat(patientResponseDTO.getFirstName()).isEqualTo(patient.getFirstName());
        assertThat(patientResponseDTO.getLastName()).isEqualTo(patient.getLastName());
        assertThat(patientResponseDTO.getEmail()).isEqualTo(patient.getEmail());
    }

    @Test
    void getPatientByIdShouldReturnEmptyPatientWhenNoPatientFound() {
        UUID patientId = UUID.randomUUID();

        when(patientRepository.findById(patientId)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> patientService.getPatientById(patientId)).isInstanceOf(NoSuchElementException.class);
    }

    @Test
    void createPatientShouldReturnPatient() {

        PatientRequestDTO patientRequestDTO = PatientRequestDTO.builder()
                .firstName("David")
                .lastName("Chomenko")
                .gender(Gender.MALE)
                .weight(80.3)
                .height(180.5)
                .email("testmail@test.com")
                .phoneNumber("+1 380 223 98 83")
                .dateOfBirth(LocalDate.parse("2009-09-03"))
                .address("Test Block 23/3")
                .registeredDate(LocalDate.parse("2009-09-03"))
                .build();

        UUID patientId = UUID.randomUUID();

        Patient patient = Patient.builder()
                .id(patientId)
                .firstName(patientRequestDTO.getFirstName())
                .lastName(patientRequestDTO.getLastName())
                .gender(Gender.MALE)
                .weight(patientRequestDTO.getWeight())
                .height(patientRequestDTO.getHeight())
                .email(patientRequestDTO.getEmail())
                .phoneNumber(patientRequestDTO.getPhoneNumber())
                .dateOfBirth(patientRequestDTO.getDateOfBirth())
                .address(patientRequestDTO.getAddress())
                .registeredDate(patientRequestDTO.getRegisteredDate())
                .build();

        when(patientRepository.existsByEmail(patientRequestDTO.getEmail())).thenReturn(false);
        when(patientRepository.save(Mockito.any(Patient.class))).thenReturn(patient);

        PatientResponseDTO response = patientService.createPatient(patientRequestDTO);

        assertThat(response.getFirstName()).isEqualTo(patient.getFirstName());
        assertThat(response.getLastName()).isEqualTo(patient.getLastName());
    }

    @Test
    void createPatientShouldThrowEmptyEntityExceptionWhenPatientExistsWithEmail() {
        PatientRequestDTO patientRequestDTO = PatientRequestDTO.builder()
                .firstName("David")
                .lastName("Chomenko")
                .gender(Gender.MALE)
                .weight(80.5)
                .height(180.5)
                .email("testmail@test.com")
                .phoneNumber("+1 380 223 98 83")
                .dateOfBirth(LocalDate.parse("2009-09-03"))
                .address("Test Block 23/3")
                .registeredDate(LocalDate.parse("2009-09-03"))
                .build();

        when(patientRepository.existsByEmail(patientRequestDTO.getEmail())).thenReturn(true);

        assertThrows(EmailAlreadyExistsException.class, () -> patientService.createPatient(patientRequestDTO));
    }

    @Test
    void updatePatientShouldReturnUpdatedPatient() {
        when(patientRepository.findById(Mockito.any())).thenReturn(Optional.of(new Patient()));

        UUID patientId = UUID.randomUUID();

        PatientRequestDTO request = PatientRequestDTO.builder()
                .firstName("David")
                .lastName("Chomenko")
                .gender(Gender.MALE)
                .weight(80.5)
                .height(185.5)
                .email("testmail@test.com")
                .phoneNumber("+1 380 223 98 83")
                .dateOfBirth(LocalDate.parse("2009-09-03"))
                .address("Test Block 23/3")
                .registeredDate(LocalDate.parse("2009-09-03"))
                .build();

        when(patientRepository.existsByEmailAndIdNot(request.getEmail(), patientId)).thenReturn(true);

        Patient patient = Patient.builder()
                .id(patientId)
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .gender(Gender.MALE)
                .weight(request.getWeight())
                .height(request.getHeight())
                .email(request.getEmail())
                .phoneNumber(request.getPhoneNumber())
                .dateOfBirth(request.getDateOfBirth())
                .address(request.getAddress())
                .registeredDate(request.getRegisteredDate())
                .build();

        when(patientRepository.save(Mockito.any(Patient.class))).thenReturn(patient);

        PatientResponseDTO patientResponseDTO = patientService.updatePatient(patientId, request);

        assertThat(patientResponseDTO.getFirstName()).isEqualTo(patient.getFirstName());
        assertThat(patientResponseDTO.getLastName()).isEqualTo(patient.getLastName());

    }

    @Test
    void updatePatientShouldThrowPatientNotFoundExceptionWhenPatientNotFound() {
        when(patientRepository.findById(Mockito.any())).thenReturn(Optional.empty());

        assertThrows(PatientNotFoundException.class, () -> patientService.updatePatient(UUID.randomUUID(), PatientRequestDTO.builder().build()));
    }

    @Test
    void updatePatientShouldThrowEmailAlreadyExistExceptionWhenEmailAlreadyExists() {
        UUID patientId = UUID.randomUUID();

        Patient patient = Patient.builder()
                .id(patientId)
                .firstName("David")
                .lastName("Chomenko")
                .gender(Enum.valueOf(Gender.class, Gender.MALE.toString()))
                .weight(80.3)
                .height(185.5)
                .email("testmail@test.com")
                .phoneNumber("+1 380 223 98 83")
                .dateOfBirth(LocalDate.parse("2009-09-03"))
                .address("Test Block 23/3")
                .registeredDate(LocalDate.parse("2020-01-01"))
                .build();

        PatientRequestDTO request = PatientRequestDTO.builder()
                .firstName("David")
                .lastName("Chomenko")
                .gender(Gender.MALE)
                .weight(80.3)
                .height(185.5)
                .email("test2mail@test.com")
                .phoneNumber("+1 380 223 98 83")
                .dateOfBirth(LocalDate.parse("2009-09-03"))
                .address("Test Block 23/3")
                .registeredDate(LocalDate.parse("2020-01-01"))
                .build();

        when(patientRepository.findById(Mockito.any())).thenReturn(Optional.of(patient));
        when(patientRepository.existsByEmailAndIdNot(patient.getEmail(), patientId)).thenReturn(true);

        assertThrows(EmailAlreadyExistsException.class, () -> patientService.updatePatient(patientId, request));
    }

    @Test
    void deletePatientShouldDeletePatient() {
        UUID patientId = UUID.randomUUID();

        patientService.deletePatient(patientId);

        verify(patientRepository, times(1)).deleteById(patientId);
    }
}