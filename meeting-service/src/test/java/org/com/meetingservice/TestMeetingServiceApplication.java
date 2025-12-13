package org.com.meetingservice;

import org.springframework.boot.SpringApplication;

public class TestMeetingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.from(MeetingServiceApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
