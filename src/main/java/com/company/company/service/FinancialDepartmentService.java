package com.company.company.service;

import com.company.company.dao.JobDescription;
import com.company.company.dto.JobPositionDTO;
import com.company.company.dto.RoleDTO;
import com.company.company.repository.JobDescriptionRepository;
import com.company.company.repository.WorkerJobRepository;
import com.company.company.repository.WorkerRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Log4j2
public class FinancialDepartmentService {

    private final WorkerRepository workerRepository;
    private final WorkerJobRepository workerJobRepository;
    private final JobDescriptionRepository jobDescriptionRepository;

    public List<JobDescription> findAllJobDescription(){
        return jobDescriptionRepository.findAll();
    }

    public Optional<JobDescription> findJobDescriptionById(Integer id){
        return jobDescriptionRepository.findById(id);
    }


    public void newJobDescription(JobDescription jobDescription){
        log.info("Saved JobDesciption with title: {}",jobDescription.getJobTitle());
        jobDescriptionRepository.save(jobDescription);
    }

    public void deleteJobDescriptionById(Integer jobId){
        jobDescriptionRepository.deleteById(jobId);
        log.info("Job Description with id {} was deleted",jobId);
    }
   public List<JobPositionDTO> findJobPosition(Integer jobId){
        return workerJobRepository.findJobPosition(jobId);
   }

   public Optional<RoleDTO> findRoleById(Integer id){
        return workerRepository.findRoleById(id);
   }

}
