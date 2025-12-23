package org.com.meetingservice.info;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PatientInfo {

    private String id;
    private String firstName;
    private String lastName;
}