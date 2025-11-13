package org.com.appointmentservice.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.com.appointmentservice.dto.DoctorResponseDTO;
import org.com.appointmentservice.dto.PatientResponseDTO;
import org.com.appointmentservice.model.DoctorEntity;
import org.com.appointmentservice.model.PatientEntity;
import org.com.appointmentservice.repository.DoctorRepository;
import org.com.appointmentservice.repository.PatientRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Slf4j
@RequiredArgsConstructor
public class KafkaConsumer {

    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;

    @KafkaListener(topics = "doctor-topic", groupId = "appointment-group",
            containerFactory = "doctorConcurrentKafkaListenerContainerFactory")
    public void consumeDoctor(DoctorResponseDTO response) {
        try {
            log.info("Consuming doctor {}", response);

            DoctorEntity doctor = DoctorEntity.builder()
                    .id(UUID.fromString(response.getId()))
                    .firstName(response.getFirstName())
                    .lastName(response.getLastName())
                    .gender(response.getGender())
                    .email(response.getEmail())
                    .phoneNumber(response.getPhoneNumber())
                    .specialization(response.getSpecialization())
                    .rating(response.getRating())
                    .schedule(response.getSchedule())
                    .build();


            doctorRepository.save(doctor);

            log.info("Doctor consumed successfully: {}", doctor.getFirstName() + " " + doctor.getLastName());
        } catch (Exception e) {
            log.error("Error consuming doctor {}", response, e);
        }
    }

    @KafkaListener(topics = "patient-topic", groupId = "appointment-group",
            containerFactory = "patientConcurrentKafkaListenerContainerFactory")
    public void consumePatient(PatientResponseDTO response) {
        try {
            log.info("Consuming patient {}", response);

            PatientEntity patient = PatientEntity.builder()
                    .id(UUID.fromString(response.getId()))
                    .firstName(response.getFirstName())
                    .lastName(response.getLastName())
                    .gender(response.getGender())
                    .weight(response.getWeight())
                    .height(response.getHeight())
                    .email(response.getEmail())
                    .phoneNumber(response.getPhoneNumber())
                    .dateOfBirth(response.getDateOfBirth())
                    .address(response.getAddress())
                    .build();

            patientRepository.save(patient);

            log.info("Patient consumed successfully: {}", patient.getFirstName() + " " + patient.getLastName());
        } catch (Exception e) {
            log.error("Error consuming patient {}", response, e);
        }
    }
}