package org.com.doctorservice.repository;

import org.com.doctorservice.additional.CustomDayOfTheWeek;
import org.com.doctorservice.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, UUID> {
    List<Schedule> findByDoctorDoctorId(UUID doctorId);
    List<Schedule> findByDoctorDoctorIdAndCustomDayOfTheWeek(UUID doctorId, CustomDayOfTheWeek customDayOfTheWeek);
    List<Schedule> findByDoctorDoctorIdAndScheduleDateBetween(UUID doctorId, LocalDate start,  LocalDate end);
    List<Schedule> findByDoctorDoctorIdAndStartTimeBeforeAndEndTimeAfter(UUID doctorId, LocalTime startTime, LocalTime endTime);
    Optional<Schedule> findByDoctorDoctorIdAndScheduleDate(UUID doctorId, LocalDate scheduleDate);
}
