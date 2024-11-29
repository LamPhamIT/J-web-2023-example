package com.lamphamit.springweb.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "job")
public class Job {
    @EmbeddedId
    JobKey id;

    @ManyToOne
    @MapsId("identityCode")
    @JoinColumn(name = "identity_code")
    private Student student;

    @OneToOne
    @JoinColumn(name = "major_code")
    private Major major;

    private String name;
    private String companyName;
    private String companyAddress;
    private String durationTime;
}
