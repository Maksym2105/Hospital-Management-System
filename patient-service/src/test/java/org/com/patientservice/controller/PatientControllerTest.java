package org.com.patientservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.com.patientservice.dto.PatientRequestDTO;
import org.com.patientservice.dto.PatientResponseDTO;
import org.com.patientservice.exception.EmptyComponentException;
import org.com.patientservice.model.genders.Gender;
import org.com.patientservice.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PatientController.class)
public class PatientControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper = new ObjectMapper();

    @MockitoBean
    PatientService patientService;

    @Test
    void getPatientByIdShouldReturn_200_Status() throws Exception {

        String patientId = "5fb21d96-9006-41d3-8c9e-819f151a9a0a";

        PatientResponseDTO patientDTO = PatientResponseDTO.builder()
                .id(patientId)
                .firstName("John")
                .lastName("Doe")
                .gender(Gender.MALE.toString())
                .weight("80 kg")
                .height("1.80 m")
                .email("johnexample@test.com")
                .phoneNumber("+380687645342")
                .dateOfBirth("2001-01-01")
                .address("Test Address")
                .build();


        when(patientService.getPatientById(UUID.fromString(patientId))).thenReturn(patientDTO);

        mockMvc.perform(get("/api/{id}", patientId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(patientId))
                .andExpect(jsonPath("$.firstName").value("John"))
                .andExpect(jsonPath("$.lastName").value("Doe"))
                .andExpect(jsonPath("$.gender").value(Gender.MALE.toString()))
                .andExpect(jsonPath("$.weight").value("80 kg"))
                .andExpect(jsonPath("$.height").value("1.80 m"))
                .andExpect(jsonPath("$.email").value("johnexample@test.com"))
                .andExpect(jsonPath("$.phoneNumber").value("+380687645342"))
                .andExpect(jsonPath("$.dateOfBirth").value("2001-01-01"))
                .andExpect(jsonPath("$.address").value("Test Address"));
    }

    @Test
    void getPatientByIdShouldReturn_404_Status() throws Exception {
        UUID patientId = UUID.randomUUID();

        when(patientService.getPatientById(patientId)).thenThrow(new EmptyComponentException("Patient not found"));

        mockMvc.perform(get("/api/patients/{id}", patientId))
                .andExpect(status().isNotFound());

    }

    @Test
    void getPatientsShouldReturn_200_status() throws Exception {

        String firstPatientId = "313268dc-7fe3-40ed-9d39-08cf53d26fb6";
        String secondPatientId = "e4371eac-80a6-4918-9628-0b6227e4dd28";

        PatientResponseDTO patientDTOFirstTest = PatientResponseDTO.builder()
                .id(firstPatientId)
                .firstName("John")
                .lastName("Doe")
                .gender(Gender.MALE.toString())
                .weight("80 kg")
                .height("1.80 m")
                .email("johnexample@test.com")
                .phoneNumber("+380687645342")
                .dateOfBirth("2001-01-01")
                .address("Test Address")
                .build();

        PatientResponseDTO patientDTOSecondTest = PatientResponseDTO.builder()
                .id(secondPatientId)
                .firstName("Donald")
                .lastName("Smith")
                .gender(Gender.MALE.toString())
                .weight("90 kg")
                .height("1.90 m")
                .email("donaldsmith@test.com")
                .phoneNumber("+380687645333")
                .dateOfBirth("2000-01-01")
                .address("Test Address")
                .build();

        List<PatientResponseDTO> patientDTOList = List.of(patientDTOFirstTest, patientDTOSecondTest);

        when(patientService.getPatients()).thenReturn(patientDTOList);

        mockMvc.perform(get("/api/patients"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].firstName").value("John"))
                .andExpect(jsonPath("$[0].lastName").value("Doe"));
    }

    @Test
    void savePatientShouldReturn_200_status() throws Exception {
        PatientRequestDTO patientRequestDTO = PatientRequestDTO.builder()
                .firstName("John")
                .lastName("Doe")
                .gender(Gender.MALE)
                .weight(80.3)
                .height(180.5)
                .email("testmail@test.com")
                .phoneNumber("+1 803432344")
                .dateOfBirth(LocalDate.parse("2000-10-03"))
                .address("Test Address")
                .registeredDate(LocalDate.parse("2023-03-01"))
                .build();

        UUID patientId = UUID.randomUUID();

        PatientResponseDTO response = PatientResponseDTO.builder()

                .id(patientId.toString())
                .firstName(patientRequestDTO.getFirstName())
                .lastName(patientRequestDTO.getLastName())
                .gender(Gender.MALE.toString())
                .weight(patientRequestDTO.getWeight().toString())
                .height(patientRequestDTO.getHeight().toString())
                .email(patientRequestDTO.getEmail())
                .phoneNumber(patientRequestDTO.getPhoneNumber())
                .dateOfBirth(patientRequestDTO.getDateOfBirth().toString())
                .address(patientRequestDTO.getAddress())
                .build();

        when(patientService.createPatient(patientRequestDTO)).thenReturn(response);

        mockMvc.perform(post("/api")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(patientRequestDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value("John"))
                .andExpect(jsonPath("$.lastName").value("Doe"))
                .andExpect(jsonPath("$.gender").value(Gender.MALE.toString()))
                .andExpect(jsonPath("$.weight").value(80.3))
                .andExpect(jsonPath("$.height").value(180.5))
                .andExpect(jsonPath("$.email").value("testmail@test.com"))
                .andExpect(jsonPath("$.phoneNumber").value("+1 803432344"))
                .andExpect(jsonPath("$.dateOfBirth").value("2000-10-03"))
                .andExpect(jsonPath("$.address").value("Test Address"));
    }

    @Test
    void savePatientShouldReturn_400_Status() throws Exception {
        PatientRequestDTO request = PatientRequestDTO.builder()
                .firstName("John")
                .lastName("Doe")
                .email("")
                .gender(Gender.MALE)
                .weight(null)
                .height(null)
                .phoneNumber("+1 803432344")
                .dateOfBirth(LocalDate.parse("2000-10-03"))
                .address("Test Address")
                .registeredDate(LocalDate.parse("2023-03-01"))
                .build();

        when(patientService.createPatient(request)).thenThrow(new EmptyComponentException("Request Not Valid"));

        mockMvc.perform(post("/api"))
                .andExpect(status().isBadRequest());

    }

    @Test
    void updatePatientShouldReturn_200_status() throws Exception {
        UUID patientId = UUID.randomUUID();

        PatientRequestDTO request = PatientRequestDTO.builder()
                .firstName("John")
                .lastName("Doe")
                .gender(Gender.MALE)
                .weight(80.3)
                .height(180.5)
                .email("test@mail.com")
                .phoneNumber("+1 803432344")
                .dateOfBirth(LocalDate.parse("2000-10-03"))
                .address("Test Address")
                .registeredDate(LocalDate.parse("2023-03-01"))
                .build();

        PatientResponseDTO responseDTO = PatientResponseDTO.builder()
                .id(patientId.toString())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .gender(Gender.MALE.toString())
                .weight(request.getWeight().toString())
                .height(request.getHeight().toString())
                .email(request.getEmail())
                .phoneNumber(request.getPhoneNumber())
                .dateOfBirth(request.getDateOfBirth().toString())
                .address(request.getAddress())
                .build();

        when(patientService.updatePatient(patientId, request)).thenReturn(responseDTO);

        mockMvc.perform(put("/api/{id}", patientId)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value("John"))
                .andExpect(jsonPath("$.lastName").value("Doe"));
    }

    @Test
    void updatePatientShouldReturn_400_Status() throws Exception {
        UUID patientId = UUID.randomUUID();

        PatientRequestDTO request = PatientRequestDTO.builder()
                .firstName("John")
                .lastName("")
                .gender(Gender.MALE)
                .weight(null)
                .height(180.5)
                .email("test@mail.com")
                .phoneNumber("+1 803432344")
                .dateOfBirth(LocalDate.parse("2000-10-03"))
                .address("Test Address")
                .registeredDate(LocalDate.parse("2023-03-01"))
                .build();

        when(patientService.updatePatient(patientId, request)).thenThrow(new EmptyComponentException("Request Not Valid"));

        mockMvc.perform(put("/api/{id}", patientId))
                .andExpect(status().isBadRequest());
    }

    @Test
    void deletePatientShouldReturn_200_status() throws Exception {
        UUID patientId = UUID.randomUUID();

        doNothing().when(patientService).deletePatient(patientId);

        mockMvc.perform(delete("/api/{id}", patientId))
                .andExpect(status().isNoContent());
    }
}