package org.com.appointmentservvice;

import org.springframework.boot.SpringApplication;

public class TestAppointmentServviceApplication {

    public static void main(String[] args) {
        SpringApplication.from(AppointmentServviceApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
