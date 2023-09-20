package com.company.company.dto;

import lombok.Data;
import java.time.LocalDate;
import java.util.Date;

@Data
public class EmployeeDTO {

// Fields from Workers table

    private String firstName;
    private String middleName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String address;
    private String city;
    private String state;
    private String country;
    private String postalCode;
    private String phoneNumber;
    private String alternatePhoneNumber;
    private String email;
    private Integer genderId;
    private String nationality;

// Fields from Professional_Info table

    private String qualification;
    private String specialization;
    private Integer yearsOfExperience;
    private String previousCompany;
    private String previousJobTitle;
    private LocalDate previousJobStartDate;
    private LocalDate previousJobEndDate;

// Fields from Worker_Jobs table: antes date, date, double (en WJ entity localdatex2 + float)

    private Integer jobId;
    private LocalDate jobStartDate;
    private LocalDate jobEndDate;
    private Float salary;
    private Integer contractTypeId;
    private String department;

}