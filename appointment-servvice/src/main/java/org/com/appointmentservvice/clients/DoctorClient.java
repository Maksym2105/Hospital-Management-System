package org.com.appointmentservvice.clients;

import org.com.appointmentservvice.additional.CustomDayOfTheWeek;
import org.com.appointmentservvice.dto.DoctorResponseDTO;
import org.com.appointmentservvice.dto.ScheduleResponseDTO;
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
    ResponseEntity<List<DoctorResponseDTO>> getAllDoctors();

    @GetMapping("/doc/filterBySpecialization")
    ResponseEntity<List<DoctorResponseDTO>> getDoctorsBySpecialization(@RequestParam String specialization);

    @GetMapping("/doc/filterByGender")
    ResponseEntity<List<DoctorResponseDTO>> getDoctorsByGender(@RequestParam String gender);

    @GetMapping("/schedule/{doctorId}")
    ResponseEntity<List<ScheduleResponseDTO>> getSchedulesByDoctorId(@PathVariable String doctorId);

    @GetMapping("/schedule/filterByIdAndDayOfTheWeek")
    ResponseEntity<List<ScheduleResponseDTO>> getSchedulesByDoctorIdAndDayOfTheWeek(
            @RequestParam String doctorId, @RequestParam CustomDayOfTheWeek customDayOfTheWeek
            );

    @GetMapping("/schedule/filterByIdAndDate")
    ResponseEntity<List<ScheduleResponseDTO>> getSchedulesByDoctorIdAndDate(
            @RequestParam String doctorId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate
    );

    @GetMapping("/schedule/filterByDoctorIdAndTimeBetween")
    ResponseEntity<List<ScheduleResponseDTO>> getSchedulesByDoctorIdAndTimeBetween(
            @RequestParam String id,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime startTime,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime endTime
            );

    @GetMapping("/schedule/singleScheduleFilterByDate")
    ResponseEntity<ScheduleResponseDTO> getScheduleByDoctorIdAndDate(
            @RequestParam String id,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date
    );

}
