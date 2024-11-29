package com.lamphamit.springweb.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponse {
    private String identityCode;
    private String fullName;
    private String email;
    private String phone;
    private String address;
}
