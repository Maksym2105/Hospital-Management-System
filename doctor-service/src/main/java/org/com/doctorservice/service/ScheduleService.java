package org.com.doctorservice.service;

import lombok.RequiredArgsConstructor;
import org.com.doctorservice.dto.ScheduleResponseDTO;
import org.com.doctorservice.model.Schedule;
import org.com.doctorservice.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

//    public List<ScheduleResponseDTO> findByDoctorId() {
//
//    }
}