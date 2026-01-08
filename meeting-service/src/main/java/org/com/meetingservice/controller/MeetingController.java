package org.com.meetingservice.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.com.meetingservice.additional.MeetingStatus;
import org.com.meetingservice.dto.MeetingResponse;
import org.com.meetingservice.requests.BookingRequest;
import org.com.meetingservice.requests.UpdateRequest;
import org.com.meetingservice.service.MeetingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/meeting")
@RequiredArgsConstructor
public class MeetingController {

    private final MeetingService meetingService;

    @GetMapping("/filterByPatientId")
    public ResponseEntity<List<MeetingResponse>> getMeetingsByPatientId(@RequestParam UUID patientId) {
        List<MeetingResponse> listOfMeetings = meetingService.findByPatientId(patientId);

        return ResponseEntity.ok().body(listOfMeetings);
    }

    @GetMapping("/filterByDoctorId")
    public ResponseEntity<List<MeetingResponse>> getMeetingByDoctorId(@RequestParam UUID doctorId) {
        List<MeetingResponse> listOfMeetings = meetingService.findByDoctorId(doctorId);

        return ResponseEntity.ok().body(listOfMeetings);
    }

    @GetMapping("/filterByStatus")
    public ResponseEntity<List<MeetingResponse>> getMeetingByStatus(@RequestParam MeetingStatus status) {
        List<MeetingResponse> listOfMeetings = meetingService.findByStatus(status);

        return ResponseEntity.ok().body(listOfMeetings);
    }

    @PostMapping
    public ResponseEntity<MeetingResponse> createMeeting(@Valid @RequestBody BookingRequest bookingRequest) {
        MeetingResponse meetingResponse = meetingService.createMeeting(bookingRequest);

        return ResponseEntity.ok().body(meetingResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MeetingResponse> updateMeeting(@PathVariable String id, @Valid @RequestBody UpdateRequest updateRequest) {
        MeetingResponse meetingResponse = meetingService.updateMeeting(id, updateRequest);

        return ResponseEntity.ok().body(meetingResponse);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> cancelMeeting(@PathVariable String id) {
        meetingService.cancelMeeting(id);

        return ResponseEntity.noContent().build();
    }
}