package com.lamphamit.springweb.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateGraduationRequest implements Serializable {
    @NotBlank(message = "IdentityCode must be not blank")
    String identityCode;
    @NotBlank(message = "Fullname must be not blank")
    String fullName;
    @Email(message = "Not an email format")
    String email;

    @Pattern(regexp = "^\\d{7,10}$", message = "Not a phone format")
    String phone;
    @NotBlank(message = "address must be not blank")
    String address;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @NotNull(message = "Date must be not null")
    LocalDate graduationDate;
    @NotBlank(message = "graduation type must be not blank")
    String graduationType;
    @NotBlank(message = "graduation system must be not blank")
    String graduationSystem;
    @NotBlank(message = "Major must be not blank")
    String majorCode;
    @NotBlank(message = "University code must be not blank")
    String universityCode;
}
