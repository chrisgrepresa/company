package com.company.company.dao;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "worker_jobs")
public class WorkerJob {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer workerJobId;
    private Integer workerId;
    private Integer jobId;
    private LocalDate startDate;
    private LocalDate endDate;
    private Float salary;
    private Integer contractTypeId;
    private String department;
}

