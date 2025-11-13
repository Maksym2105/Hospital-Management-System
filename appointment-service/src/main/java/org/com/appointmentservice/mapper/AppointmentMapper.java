package org.com.appointmentservice.mapper;

import org.com.appointmentservice.dto.AppointmentRequestDTO;
import org.com.appointmentservice.dto.AppointmentResponseDTO;
import org.com.appointmentservice.model.Appointment;

import java.time.LocalDate;
import java.util.Map;
import java.util.UUID;

public class AppointmentMapper {

    public static Appointment toModel(AppointmentRequestDTO request){
        Appointment appointment = Appointment.builder()
                .doctorId(UUID.fromString(request.getDoctorId()))
                .patientId(UUID.fromString(request.getPatientId()))
                .reason(request.getReason())
                .date(request.getDate())
                .build();

        validate(appointment);

        return appointment;
    }

    private static void validate(Appointment appointment){
        Map<String, String> map = Map.of(
                "doctorId", appointment.getDoctorId().toString(),
                "patientId", appointment.getPatientId().toString(),
                "reason", appointment.getReason(),
                "date", appointment.getDate()
        );

        validateFields(map, new IllegalArgumentException());
    }

    private static void validateFields(Map<String, ?> fields, IllegalArgumentException notValidException) {
        fields.forEach((key, value) -> {
            if (value == null || value.toString().isBlank()) {
                throw notValidException;
            }
        });
    }
}