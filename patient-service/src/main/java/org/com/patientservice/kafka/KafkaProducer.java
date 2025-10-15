package org.com.patientservice.kafka;

import lombok.extern.slf4j.Slf4j;
import org.com.patientservice.dto.PatientDeletedEvent;
import org.com.patientservice.dto.PatientResponseDTO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class KafkaProducer {

    private final static String TOPIC = "patient-topic";
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public KafkaProducer(@Qualifier("patientKafkaTemplate") KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendPatientCreated(PatientResponseDTO patientResponseDTO) {
        log.info("Patient Created: {}", patientResponseDTO);
        kafkaTemplate.send(TOPIC, patientResponseDTO);
    }

    public void sendPatientUpdated(PatientResponseDTO patientResponseDTO) {
        log.info("Patient Updated: {}", patientResponseDTO);
        kafkaTemplate.send(TOPIC, patientResponseDTO);
    }

    public void sendPatientDeleted(UUID id) {
        PatientDeletedEvent patientDeletedEvent = new PatientDeletedEvent(id);
        log.info("Patient Deleted: {}", patientDeletedEvent);
        kafkaTemplate.send(TOPIC, patientDeletedEvent);
    }
}