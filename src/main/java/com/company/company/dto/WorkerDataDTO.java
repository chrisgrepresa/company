package com.company.company.dto;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class WorkerDataDTO {

    private String firstName;
    private String middleName;
    private String lastName;
    private String genderDescription;
    private String jobTitle;
    private String contractTypeDescription;
    private LocalDate startDate;

}
