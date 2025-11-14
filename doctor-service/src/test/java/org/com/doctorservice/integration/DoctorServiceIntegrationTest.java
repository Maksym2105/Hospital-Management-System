//package org.com.doctorservice.integration;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.com.doctorservice.dto.DoctorRequestDTO;
//import org.com.doctorservice.dto.DoctorResponseDTO;
//import org.com.doctorservice.kafka.KafkaProducer;
//import org.com.doctorservice.additional.Genders;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.DynamicPropertyRegistry;
//import org.springframework.test.context.DynamicPropertySource;
//import org.springframework.test.context.bean.override.mockito.MockitoBean;
//import org.springframework.test.web.servlet.MockMvc;
//import org.testcontainers.containers.PostgreSQLContainer;
//import org.testcontainers.junit.jupiter.Container;
//import org.testcontainers.junit.jupiter.Testcontainers;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import java.math.BigDecimal;
//import java.util.UUID;
//
//@SpringBootTest
//@Testcontainers
//@AutoConfigureMockMvc
//public class DoctorServiceIntegrationTest {
//
//    @Autowired
//    MockMvc mockMvc;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @MockitoBean
//    private KafkaProducer kafkaProducer;
//
//    @Container
//    static PostgreSQLContainer<?> postgreSQLContainer = new PostgreSQLContainer<>("postgres:12")
//            .withUsername("postgres")
//            .withPassword("10105656")
//            .withDatabaseName("dsdb");
//
//    @DynamicPropertySource
//    static void postgresProperties(DynamicPropertyRegistry registry) {
//        registry.add("spring.datasource.url", postgreSQLContainer::getJdbcUrl);
//        registry.add("spring.datasource.password", postgreSQLContainer::getPassword);
//        registry.add("spring.datasource.username", postgreSQLContainer::getUsername);
//        registry.add("spring.jpa.hibernate.ddl-auto", () -> "update");
//        registry.add("spring.sql.init.mode", () -> "always");
//    }
//
//    @Test
//    public void fullCrudTest() throws Exception {
//        DoctorRequestDTO request = DoctorRequestDTO.builder()
//                .firstName("Carl")
//                .lastName("Edge")
//                .gender(Genders.MALE)
//                .email("test@mail.com")
//                .phoneNumber("+1 (440) 330 33219")
//                .specialization("Gynaecologist")
//                .rating(BigDecimal.valueOf(0.0))
//                .schedule("From Monday to Friday, From 9:00 AM to 18:00 PM")
//                .build();
//
//        String json = objectMapper.writeValueAsString(request);
//
//        String createDoctor = mockMvc.perform(post("/doc")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(json))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.id").exists())
//                .andReturn().getResponse().getContentAsString();
//
//        DoctorResponseDTO responseDTO = objectMapper.readValue(createDoctor, DoctorResponseDTO.class);
//
//        UUID doctorId = UUID.fromString(responseDTO.getId());
//
//        mockMvc.perform(get("/doc/{id}", doctorId))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.firstName").value(request.getFirstName()))
//                .andExpect(jsonPath("$.lastName").value(request.getLastName()))
//                .andExpect(jsonPath("$.gender").value(request.getGender().toString()))
//                .andExpect(jsonPath("$.email").value(request.getEmail()))
//                .andExpect(jsonPath("$.phoneNumber").value(request.getPhoneNumber()))
//                .andExpect(jsonPath("$.specialization").value(request.getSpecialization()))
//                .andExpect(jsonPath("$.rating").value(request.getRating().toString()))
//                .andExpect(jsonPath("$.schedule").value(request.getSchedule()));
//
//        mockMvc.perform(get("/doc/doctors"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$[0].id").exists());
//
//        String specialization = responseDTO.getSpecialization();
//
//        mockMvc.perform(get("/doc/specialization/{specialization}", specialization))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$[0].specialization").value(specialization));
//
//        Genders gender = Enum.valueOf(Genders.class, responseDTO.getGender());
//
//        mockMvc.perform(get("/doc/gender/{gender}", gender))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$[0].gender").value(gender.toString()));
//
//        responseDTO.setFirstName("Douglas");
//        responseDTO.setLastName("Duck");
//        responseDTO.setSpecialization("Ophthalmologist");
//
//        mockMvc.perform(put("/doc/{id}", doctorId)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(responseDTO)))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.firstName").value(responseDTO.getFirstName()))
//                .andExpect(jsonPath("$.lastName").value(responseDTO.getLastName()))
//                .andExpect(jsonPath("$.specialization").value(responseDTO.getSpecialization()));
//
//        mockMvc.perform(delete("/doc/{id}",  doctorId))
//                .andExpect(status().isNoContent());
//    }
//}