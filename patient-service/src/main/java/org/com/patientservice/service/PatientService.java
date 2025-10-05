package org.com.patientservice.service;

import lombok.RequiredArgsConstructor;
import org.com.patientservice.dto.PatientRequestDTO;
import org.com.patientservice.dto.PatientResponseDTO;
import org.com.patientservice.exception.EmailAlreadyExistsException;
import org.com.patientservice.exception.PatientNotFoundException;
import org.com.patientservice.mapper.PatientMapper;
import org.com.patientservice.messages.PatientMessages;
import org.com.patientservice.model.Patient;
import org.com.patientservice.repository.PatientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PatientService {

    private static final Logger log = LoggerFactory.getLogger(PatientService.class);
    private final PatientRepository patientRepository;

    public List<PatientResponseDTO> getPatients () {
        List<Patient> patientList = patientRepository.findAll();

        List<PatientResponseDTO> patientResponseDTOS = patientList.stream()
                .map(PatientMapper::toDTO)
                .toList();

        return patientResponseDTOS;
    }

    public PatientResponseDTO getPatientById (UUID id){
        Optional<Patient> patient = patientRepository.findById(id);

        return PatientMapper.toDTO(patient.get());
    }

    public PatientResponseDTO createPatient(PatientRequestDTO patientRequestDTO) {
        if(patientRepository.existsByEmail(patientRequestDTO.getEmail())) {
            throw new EmailAlreadyExistsException(PatientMessages.EMAIL_ALREADY_EXISTS.getMessage());
        }

        Patient patient = PatientMapper.toModel(patientRequestDTO);

        return PatientMapper.toDTO(patientRepository.save(patient));

    }

    public PatientResponseDTO updatePatient(UUID id, PatientRequestDTO request){
        Patient patient = patientRepository.findById(id).orElseThrow(() -> new PatientNotFoundException(PatientMessages.PATIENT_NOT_FOUND.getMessage()));

        if(patientRepository.existsByEmailAndPatientIdNot(patient.getEmail(), patient.getPatientId())) {
            throw new EmailAlreadyExistsException(PatientMessages.EMAIL_ALREADY_EXISTS.getMessage());
        }

        patient.setFirstName(request.getFirstName());
        patient.setLastName(request.getLastName());
        patient.setWeight(request.getWeight());
        patient.setEmail(request.getEmail());
        patient.setPhoneNumber(request.getPhoneNumber());
        patient.setDateOfBirth(request.getDateOfBirth());
        patient.setAddress(request.getAddress());

        Patient updatedPatient = patientRepository.save(patient);

        return PatientMapper.toDTO(updatedPatient);
    }

    public void deletePatient(UUID id){
        patientRepository.deleteById(id);
    }
}