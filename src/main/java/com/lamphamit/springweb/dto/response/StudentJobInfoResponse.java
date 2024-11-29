package com.lamphamit.springweb.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentJobInfoResponse {
    private String identityCode;
    private String fullName;
    private String email;
    private String majorGraduationCode;
    private String universityCode;
    private String majorWorkedCode;
    private String companyName;
    private String durationTime;
}
