package com.company.company.repository;

import com.company.company.dao.WorkerJob;
import com.company.company.dto.JobPositionDTO;
import com.company.company.dto.WorkerDataDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkerJobRepository extends JpaRepository<WorkerJob,Integer> {

   @Query(value = """
           SELECT NEW com.company.company.dto.WorkerDataDTO(
           w.firstName,
           w.middleName,
           w.lastName,
           g.genderDescription,
           jd.jobTitle,
           ct.contractTypeDescription,
           wj.startDate
           )
           FROM Worker w
           JOIN Gender g ON g.genderId = w.genderId
           JOIN WorkerJob wj ON wj.workerId = w.workerId
           JOIN JobDescription jd ON jd.jobId = wj.jobId
           JOIN ContractType ct ON ct.contractTypeId = wj.contractTypeId
           WHERE w.workerId = :workerId
           """)
   List<WorkerDataDTO> findWorkerJobDataById(@Param("workerId") Integer workerId);

   @Query(value = """
           SELECT NEW com.company.company.dto.JobPositionDTO(
           w.firstName,
           w.lastName,
           g.genderDescription
           )
           FROM JobDescription jd
           JOIN WorkerJob wj ON wj.jobId = jd.jobId
           JOIN Worker w ON w.workerId = wj.workerId
           JOIN Gender g ON g.genderId = w.genderId
           WHERE wj.jobId = :jobId
           """)
   List<JobPositionDTO> findJobPosition (@Param("jobId") Integer jobId);

}
