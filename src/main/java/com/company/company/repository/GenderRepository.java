package com.company.company.repository;

import com.company.company.dao.Gender;
import com.company.company.dto.RoleDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface GenderRepository extends JpaRepository<Gender,Integer> {

    @Query(value = """
            SELECT NEW com.company.company.dto.RoleDTO(
            w.firstName,
            w.lastName,
            jd.jobTitle,
            pi.specialization
            )
            FROM Gender g
            JOIN Worker w ON w.genderId = g.genderId
            JOIN WorkerJob wj ON wj.workerId = w.workerId
            JOIN JobDescription jd ON jd.jobId = wj.jobId
            JOIN ProfessionalInfo pi ON pi.workerId = w.workerId
            WHERE g.genderDescription = 'Female' AND wj.startDate BETWEEN '2020-01-01' AND '2023-08-01'
            """)
    List<RoleDTO> findWomenAfter2020();


    @Query(value = """
            SELECT NEW com.company.company.dto.RoleDTO(
            w.firstName,
            w.lastName,
            jd.jobTitle,
            pi.specialization
            )
            FROM Gender g
            JOIN Worker w ON w.genderId = g.genderId
            JOIN WorkerJob wj ON wj.workerId = w.workerId
            JOIN JobDescription jd ON jd.jobId = wj.jobId
            JOIN ProfessionalInfo pi ON pi.workerId = w.workerId
            JOIN ContractType ct ON ct.contractTypeId = wj.contractTypeId
            WHERE g.genderDescription = 'Male' AND ct.contractTypeDescription = 'Part-time'
            """)
    List<RoleDTO> findMenPartTime();
}
