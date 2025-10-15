package org.com.doctorservice.service;

import lombok.RequiredArgsConstructor;
import org.com.doctorservice.dto.DoctorRequestDTO;
import org.com.doctorservice.dto.DoctorResponseDTO;
import org.com.doctorservice.exception.DoctorNotFoundException;
import org.com.doctorservice.exception.EmailAlreadyExistsException;
import org.com.doctorservice.kafka.KafkaProducer;
import org.com.doctorservice.mapper.DoctorMapper;
import org.com.doctorservice.messages.DoctorServiceMessages;
import org.com.doctorservice.model.Doctor;
import org.com.doctorservice.model.gender.Genders;
import org.com.doctorservice.repository.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DoctorService {

    private final DoctorRepository doctorRepository;
    private final KafkaProducer kafkaProducer;

    public List<DoctorResponseDTO> getDoctors(){
        List<Doctor> doctors = doctorRepository.findAll();

        List<DoctorResponseDTO> responseDTOs = doctors.stream()
                .map(DoctorMapper::toResponseDTO)
                .toList();

        return responseDTOs;
    }

    public DoctorResponseDTO getDoctorById(UUID doctorId){
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow(() -> new DoctorNotFoundException(doctorId.toString()));

        return DoctorMapper.toResponseDTO(doctor);
    }

    public List<DoctorResponseDTO> getAllDoctorsBySpecialization(String specialization){
        List<Doctor> doctors = doctorRepository.findAllBySpecialization( specialization);

        List<DoctorResponseDTO> responseDTOs = doctors.stream()
                .map(DoctorMapper::toResponseDTO)
                .toList();

        return responseDTOs;
    }

    public List<DoctorResponseDTO> findAllDoctorsByGender(Genders gender) {
        List<Doctor> doctors = doctorRepository.findAllDoctorsByGender(gender);

        List<DoctorResponseDTO> responseDTOs = doctors.stream()
                .map(DoctorMapper::toResponseDTO)
                .toList();

        return responseDTOs;
    }

    public DoctorResponseDTO createDoctor(DoctorRequestDTO doctorRequestDTO){
        if(doctorRepository.existsByEmail(doctorRequestDTO.getEmail())){
            throw new EmailAlreadyExistsException(DoctorServiceMessages.EMAIL_ALREADY_EXISTS.getMessage());
        }

        Doctor doctor = doctorRepository.save(DoctorMapper.toModel(doctorRequestDTO));

        DoctorResponseDTO response = DoctorMapper.toResponseDTO(doctor);
        kafkaProducer.sendDoctorCreated(response);

        return DoctorMapper.toResponseDTO(doctor);
    }

    public DoctorResponseDTO updateDoctor(UUID id, DoctorRequestDTO request){
        Doctor doctor = doctorRepository.findById(id).orElseThrow(() -> new DoctorNotFoundException(id.toString()));

        if(doctorRepository.existsByEmailAndDoctorIdNot(request.getEmail(), id)){
            throw new EmailAlreadyExistsException(DoctorServiceMessages.EMAIL_ALREADY_EXISTS.getMessage());
        }

        doctor.setFirstName(request.getFirstName());
        doctor.setLastName(request.getLastName());
        doctor.setEmail(request.getEmail());
        doctor.setPhoneNumber(request.getPhoneNumber());
        doctor.setSpecialization(request.getSpecialization());
        doctor.setSchedule(request.getSchedule());

        Doctor updatedDoctor = doctorRepository.save(doctor);

        DoctorResponseDTO response =  DoctorMapper.toResponseDTO(updatedDoctor);
        kafkaProducer.sendDoctorUpdated(response);

        return DoctorMapper.toResponseDTO(updatedDoctor);
    }

    public void deleteDoctor(UUID id){
        doctorRepository.deleteById(id);
        kafkaProducer.sendDoctorDeleted(id);
    }
}