package com.company.company.dao;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "professional_info")

public class ProfessionalInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer profInfoId;
    private Integer workerId;
    private String qualification;
    private String specialization;
    private Integer yearsOfExperience;
    private String previousCompany;
    private String previousJobTitle;
    private LocalDate startingDate;
    private LocalDate endDate;
    private String skills;
}
