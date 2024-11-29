package com.lamphamit.springweb.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "major")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Major {
    @Id
    private String majorCode;
    private String majorName;
    private String majorType;
}
