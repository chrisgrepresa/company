package com.company.company.repository;

import com.company.company.dao.Worker;
import com.company.company.dto.EmployeeDTO;
import com.company.company.dto.JobPositionDTO;
import com.company.company.dto.NationalityDTO;
import com.company.company.dto.RoleDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WorkerRepository extends JpaRepository<Worker,Integer> {


    @Query(value = """
            SELECT NEW com.company.company.dto.RoleDTO(
            w.firstName,
            w.lastName,
            jd.jobTitle,
            pi.specialization
            )
            FROM Worker w
            JOIN ProfessionalInfo pi ON pi.workerId = w.workerId
            JOIN WorkerJob wj ON wj.workerId = w.workerId
            JOIN JobDescription jd ON jd.jobId = wj.jobId
            WHERE w.workerId = :workerId
            """)
    Optional<RoleDTO> findRoleById (@Param("workerId") Integer workerId);


    @Query(value = """
            SELECT NEW com.company.company.dto.NationalityDTO(
            w.firstName,
            w.middleName,
            w.lastName,
            g.genderDescription
            )
            FROM Worker w
            JOIN Gender g ON g.genderId = w.genderId
            WHERE w.nationality = :nationality
            """)
    List<NationalityDTO> findDataByNationality (@Param("nationality")String nationality);

}


