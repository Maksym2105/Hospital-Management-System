package org.com.meetingservice.client;

import org.com.meetingservice.additional.CustomDayOfTheWeek;
import org.com.meetingservice.additional.Genders;
import org.com.meetingservice.additional.Specialization;
import org.com.meetingservice.dto.DoctorResponseDTO;
import org.com.meetingservice.dto.ScheduleResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.LocalTime;

import java.util.List;

@FeignClient(
        name = "doctor-service", fallback = DoctorClientFallback.class
)
public interface DoctorClient {

    @GetMapping("/doc/{id}")
    ResponseEntity<DoctorResponseDTO> getDoctorById(@PathVariable String id);

    @GetMapping("/doc/doctors")
    ResponseEntity<List<DoctorResponseDTO>> getDoctors();

    @GetMapping("/doc/filterBySpecialization")
    ResponseEntity<List<DoctorResponseDTO>> getDoctorsBySpecialization(@RequestParam Specialization specialization);

    @GetMapping("/doc/filterByGender")
    ResponseEntity<List<DoctorResponseDTO>> getDoctorsByGender(@RequestParam Genders gender);

    @GetMapping("/schedule/{doctorId}")
    ResponseEntity<List<ScheduleResponseDTO>> getSchedulesByDoctorId(@PathVariable String doctorId);

    @GetMapping("/schedule/filterByIdAndDayOfTheWeek")
    ResponseEntity<List<ScheduleResponseDTO>> getSchedulesByDoctorIdAndDayOfTheWeek(@RequestParam String doctorId, @RequestParam CustomDayOfTheWeek dayOfTheWeek);

    @GetMapping("/schedule/filterByDoctorIdAndDateBetween")
    ResponseEntity<List<ScheduleResponseDTO>> getSchedulesByDoctorIdAndScheduleDateBetween(
            @RequestParam String doctorId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate);

    @GetMapping("/schedule/filterByDoctorIdAndTimeBetween")
    ResponseEntity<List<ScheduleResponseDTO>> getSchedulesByDoctorIdAndStartTimeAndEndTime(
            @RequestParam String doctorId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime startTime,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime endTime);

    @GetMapping("/schedule/singleScheduleFilterByDate")
    ResponseEntity<ScheduleResponseDTO> getSchedulesByDoctorIdDate(
            @RequestParam String doctorId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date);


}
