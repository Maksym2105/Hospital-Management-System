package org.com.meetingservice.service;

import lombok.RequiredArgsConstructor;
import org.com.meetingservice.additional.Genders;
import org.com.meetingservice.additional.Specialization;
import org.com.meetingservice.client.DoctorClient;
import org.com.meetingservice.client.PatientClient;
import org.com.meetingservice.dto.DoctorResponseDTO;
import org.com.meetingservice.repository.MeetingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MeetingService {

    private final DoctorClient doctorClient;
    private final PatientClient patientClient;
    private final MeetingRepository meetingRepository;


    public List<DoctorResponseDTO> getAvailableDoctorsBySpecialization(Specialization specialization) {

        List<DoctorResponseDTO> doctors = doctorClient.getDoctorsBySpecialization(specialization)
                .getBody();

        return doctors;
    }

    public List<DoctorResponseDTO> getAvailableDoctorsByGender(Genders gender) {

        List<DoctorResponseDTO> doctors = doctorClient.getDoctorsByGender(gender)
                .getBody();

        return doctors;
    }


}