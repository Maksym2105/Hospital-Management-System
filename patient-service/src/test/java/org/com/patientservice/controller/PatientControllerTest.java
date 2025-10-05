package org.com.patientservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.com.patientservice.dto.PatientRequestDTO;
import org.com.patientservice.dto.PatientResponseDTO;
import org.com.patientservice.exception.EmptyComponentException;
import org.com.patientservice.model.genders.Gender;
import org.com.patientservice.service.PatientService;
import org.junit.jupiter.api.DisplayName;
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
    ObjectMapper objectMapper;

    @MockitoBean
    PatientService patientService;

    @Test
    @DisplayName("/GET, /api/{id} - should return patient by id ")
    void getPatientByIdShouldReturnPatient () throws Exception {

        UUID patientId = UUID.randomUUID();

        PatientResponseDTO response = PatientResponseDTO.builder()
                .id(patientId.toString())
                .firstName("John")
                .lastName("Doe")
                .gender(Gender.MALE.toString())
                .weight("80 kg")
                .height("1.80 m")
                .email("johnexample@test.com")
                .phoneNumber("+38 (068) 7645342")
                .dateOfBirth("2001-01-01")
                .address("Test Address")
                .build();


        when(patientService.getPatientById(patientId)).thenReturn(response);

        mockMvc.perform(get("/api/{id}", patientId.toString()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(response.getId()))
                .andExpect(jsonPath("$.firstName").value(response.getFirstName()))
                .andExpect(jsonPath("$.lastName").value(response.getLastName()))
                .andExpect(jsonPath("$.gender").value(response.getGender()))
                .andExpect(jsonPath("$.weight").value(response.getWeight()))
                .andExpect(jsonPath("$.height").value(response.getHeight()))
                .andExpect(jsonPath("$.email").value(response.getEmail()))
                .andExpect(jsonPath("$.phoneNumber").value(response.getPhoneNumber()))
                .andExpect(jsonPath("$.dateOfBirth").value(response.getDateOfBirth()))
                .andExpect(jsonPath("$.address").value(response.getAddress()));

        verify(patientService).getPatientById(UUID.fromString(patientId.toString()));
        verifyNoMoreInteractions(patientService);
    }

    @Test
    @DisplayName("/GET, /api/{id} - should throw exception when no patient")
    void getPatientByIdShouldReturnNotFoundIfNoPatient() throws Exception {
        UUID patientId = UUID.randomUUID();

        when(patientService.getPatientById(patientId)).thenThrow(new EmptyComponentException("Patient not found"));

        mockMvc.perform(get("/api/patients/{id}", patientId))
                .andExpect(status().isNotFound());

    }

    @Test
    @DisplayName("/GET, /api/patients - should return list of patients")
    void getPatientsShouldReturnListOfPatients () throws Exception {

        PatientResponseDTO firstResponse = PatientResponseDTO.builder()
                .id(UUID.randomUUID().toString())
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

        PatientResponseDTO secondResponse = PatientResponseDTO.builder()
                .id(UUID.randomUUID().toString())
                .firstName("Donald")
                .lastName("Smith")
                .gender(Gender.MALE.toString())
                .weight("90 kg")
                .height("1.90 m")
                .email("donaldsmith@test.com")
                .phoneNumber("+380 (687) 645333")
                .dateOfBirth("2000-01-01")
                .address("Test Address")
                .build();

        List<PatientResponseDTO> patientDTOList = List.of(firstResponse, secondResponse);

        when(patientService.getPatients()).thenReturn(patientDTOList);

        mockMvc.perform(get("/api/patients"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].firstName").value(firstResponse.getFirstName()))
                .andExpect(jsonPath("$[0].lastName").value(firstResponse.getLastName()))
                .andExpect(jsonPath("$[0].gender").value(firstResponse.getGender()))
                .andExpect(jsonPath("$[0].weight").value(firstResponse.getWeight()))
                .andExpect(jsonPath("$[0].height").value(firstResponse.getHeight()))
                .andExpect(jsonPath("$[0].email").value(firstResponse.getEmail()))
                .andExpect(jsonPath("$[0].phoneNumber").value(firstResponse.getPhoneNumber()))
                .andExpect(jsonPath("$[0].dateOfBirth").value(firstResponse.getDateOfBirth()))
                .andExpect(jsonPath("$[0].address").value(firstResponse.getAddress()))

                .andExpect(jsonPath("$[1].firstName").value(secondResponse.getFirstName()))
                .andExpect(jsonPath("$[1].lastName").value(secondResponse.getLastName()))
                .andExpect(jsonPath("$[1].gender").value(secondResponse.getGender()))
                .andExpect(jsonPath("$[1].weight").value(secondResponse.getWeight()))
                .andExpect(jsonPath("$[1].height").value(secondResponse.getHeight()))
                .andExpect(jsonPath("$[1].email").value(secondResponse.getEmail()))
                .andExpect(jsonPath("$[1].phoneNumber").value(secondResponse.getPhoneNumber()))
                .andExpect(jsonPath("$[1].dateOfBirth").value(secondResponse.getDateOfBirth()))
                .andExpect(jsonPath("$[1].address").value(secondResponse.getAddress()));

        verify(patientService).getPatients();
        verifyNoMoreInteractions(patientService);
    }

    @Test
    @DisplayName("/POST, /api - should save patient and return response")
    void savePatientShouldReturnPatentResponse () throws Exception {
        PatientRequestDTO request = PatientRequestDTO.builder()
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
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .gender(request.getGender().toString())
                .weight(request.getWeight().toString())
                .height(request.getHeight().toString())
                .email(request.getEmail())
                .phoneNumber(request.getPhoneNumber())
                .dateOfBirth(request.getDateOfBirth().toString())
                .address(request.getAddress())
                .build();

        when(patientService.createPatient(request)).thenReturn(response);

        mockMvc.perform(post("/api")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value(request.getFirstName()))
                .andExpect(jsonPath("$.lastName").value(response.getLastName()))
                .andExpect(jsonPath("$.gender").value(request.getGender().toString()))
                .andExpect(jsonPath("$.weight").value(response.getWeight()))
                .andExpect(jsonPath("$.height").value(response.getHeight()))
                .andExpect(jsonPath("$.email").value(response.getEmail()))
                .andExpect(jsonPath("$.phoneNumber").value(response.getPhoneNumber()))
                .andExpect(jsonPath("$.dateOfBirth").value(response.getDateOfBirth()))
                .andExpect(jsonPath("$.address").value(response.getAddress()));

        verify(patientService).createPatient(request);
        verifyNoMoreInteractions(patientService);
    }

    @Test
    @DisplayName("/POST, /api - should throw bad request if value is null")
    void savePatientShouldReturnBadRequestWhenValueIsNull () throws Exception {
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
    @DisplayName("/PUT, /api/{id} - should update patient and return response")
    void updatePatientShouldUpdateAndReturnResponse () throws Exception {
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

        PatientResponseDTO response = PatientResponseDTO.builder()
                .id(patientId.toString())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .gender(request.getGender().toString())
                .weight(request.getWeight().toString())
                .height(request.getHeight().toString())
                .email(request.getEmail())
                .phoneNumber(request.getPhoneNumber())
                .dateOfBirth(request.getDateOfBirth().toString())
                .address(request.getAddress())
                .build();

        when(patientService.updatePatient(patientId, request)).thenReturn(response);

        mockMvc.perform(put("/api/{id}", patientId)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value(response.getFirstName()))
                .andExpect(jsonPath("$.lastName").value(response.getLastName()))
                .andExpect(jsonPath("$.gender").value(response.getGender()))
                .andExpect(jsonPath("$.weight").value(response.getWeight()))
                .andExpect(jsonPath("$.height").value(response.getHeight()))
                .andExpect(jsonPath("$.email").value(response.getEmail()))
                .andExpect(jsonPath("$.phoneNumber").value(response.getPhoneNumber()))
                .andExpect(jsonPath("$.dateOfBirth").value(response.getDateOfBirth()))
                .andExpect(jsonPath("$.address").value(response.getAddress()));

        verify(patientService).updatePatient(patientId, request);
        verifyNoMoreInteractions(patientService);
    }

    @Test
    @DisplayName("/PUT, /api/{id} - should return bad request if value is null")
    void updatePatientShouldReturnBadRequestIfValueIsNull () throws Exception {
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
    @DisplayName("/DELETE, /api/{id} should delete patient by id")
    void deletePatientShouldReturnNoContent () throws Exception {
        UUID patientId = UUID.randomUUID();

        doNothing().when(patientService).deletePatient(patientId);

        mockMvc.perform(delete("/api/{id}", patientId))
                .andExpect(status().isNoContent());

        verify(patientService).deletePatient(patientId);
        verifyNoMoreInteractions(patientService);
    }
}