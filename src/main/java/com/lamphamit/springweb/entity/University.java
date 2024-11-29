package com.lamphamit.springweb.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "University")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class University {
    @Id
    private String universityCode;
    private String name;
    private String address;
    private String phone;
}
