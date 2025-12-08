package org.com.doctorservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.com.doctorservice.additional.CustomDayOfTheWeek;
import org.com.doctorservice.dto.ScheduleResponseDTO;
import org.com.doctorservice.service.ScheduleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/schedule")
@RequiredArgsConstructor
@Tag(name = "Schedule", description = "API for schedules")
public class ScheduleController {

    private final ScheduleService scheduleService;

    @Operation(summary = "Get schedules by doctor id")
    @GetMapping("/{doctorId}")
    public ResponseEntity<List<ScheduleResponseDTO>> getSchedulesByDoctorId (@PathVariable UUID doctorId) {
        List<ScheduleResponseDTO> scheduleResponseList = scheduleService.findAllByDoctorId(doctorId);

        return ResponseEntity.ok().body(scheduleResponseList);
    }

    @Operation(summary = "Get schedules by doctor id and day of the week")
    @GetMapping("/filterByIdAndDayOfTheWeek")
    public ResponseEntity<List<ScheduleResponseDTO>> getSchedulesByDoctorIdAndCustomDayOfTheWeek(
            @RequestParam UUID doctorId, @RequestParam CustomDayOfTheWeek customDayOfTheWeek
    ) {
        List<ScheduleResponseDTO> scheduleResponseList = scheduleService.findAllByDoctorIdAndCustomDayOfTheWeek(doctorId, customDayOfTheWeek);

        return ResponseEntity.ok().body(scheduleResponseList);
    }

    @Operation(summary = "Get schedules by doctor id and start/end date")
    @GetMapping("/filterByIdAndDate")
    public ResponseEntity<List<ScheduleResponseDTO>> getSchedulesByDoctorIdAndScheduleDateBetween(
            @RequestParam UUID doctorId, @RequestParam LocalDate startDate, @RequestParam LocalDate endDate
    ) {
        List<ScheduleResponseDTO> scheduleResponseList = scheduleService.findAllByDoctorIdAndScheduleDateBetween(doctorId, startDate, endDate);

        return ResponseEntity.ok().body(scheduleResponseList);
    }

    @Operation(summary = "Get schedules by doctor id and start/end time")
    @GetMapping("/filterByDoctorIdAndTimeBetween")
    public ResponseEntity<List<ScheduleResponseDTO>> getSchedulesByDoctorIdAndStartTimeAndEndTime(
            @RequestParam UUID doctorId, @RequestParam LocalTime startTime, @RequestParam LocalTime endTime
    ) {
        List<ScheduleResponseDTO> scheduleResponseList = scheduleService.findAllByDoctorIdAndStartTimeBetweenAndEndTimeBetween(
                doctorId, startTime, endTime
        );

        return ResponseEntity.ok().body(scheduleResponseList);
    }

    @Operation(summary = "Get schedule by doctor id and date")
    @GetMapping("/singleScheduleFilterByDate")
    public ResponseEntity<ScheduleResponseDTO> getScheduleByDoctorIdAndScheduleDate(
            @RequestParam UUID doctorId, @RequestParam LocalDate scheduleDate
    ) {
        ScheduleResponseDTO response = scheduleService.findByDoctorIdAndScheduleDate(doctorId, scheduleDate);

        return ResponseEntity.ok().body(response);
    }
}