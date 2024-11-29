package com.lamphamit.springweb.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "graduation")
@Getter
@Setter
public class Graduation {
    @EmbeddedId
    private GraduationKey id;

    @OneToOne(cascade = CascadeType.PERSIST)
    @MapsId("majorCode")
    @JoinColumn(name="major_code")
    private Major major;


    @ManyToOne
    @MapsId("identityCode")
    @JoinColumn(name="identity_code")
    private Student student;


    @OneToOne
    @MapsId("universityCode")
    @JoinColumn(name = "university_code")
    private University university;

    private String graduationSystem;

    private LocalDate graduationDate;
    private String graduationType;
}
