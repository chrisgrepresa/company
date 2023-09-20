package com.company.company.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
public class NationalityDTO {
    private String firstName;
    private String middleName;
    private String lastName;
    private String genderDescription;
}
