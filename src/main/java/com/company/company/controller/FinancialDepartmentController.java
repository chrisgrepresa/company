package com.company.company.controller;

import com.company.company.dao.JobDescription;
import com.company.company.dto.JobPositionDTO;
import com.company.company.dto.RoleDTO;
import com.company.company.service.FinancialDepartmentService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/financialdepartment")
@Log4j2
public class FinancialDepartmentController {

    private FinancialDepartmentService financialDepartmentService;

    @GetMapping("/jobdescription/findall")
    public ResponseEntity<List<JobDescription>> findAllJobDescription(){
        if(financialDepartmentService.findAllJobDescription().isEmpty()){
            log.info("No Content from All Job Description");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(financialDepartmentService.findAllJobDescription(), HttpStatus.OK);
    }

    @GetMapping("/jobdescription/findbyid/{id}")
    public ResponseEntity<Optional<JobDescription>> findJobDescriptionById(@PathVariable String id){
        if(financialDepartmentService.findJobDescriptionById(Integer.parseInt(id)).isEmpty()){
            log.info("Job Description not found for Id: {}", id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(financialDepartmentService.findJobDescriptionById(Integer.parseInt(id)),HttpStatus.OK);
    }

    @PostMapping("/jobdescription/new")
    public void newJobDescription(@RequestBody JobDescription jobDescription){
        financialDepartmentService.newJobDescription(jobDescription);
    }

    @DeleteMapping("/jobdescription/delete/{jobId}")
    public void deleteJobDescription(@PathVariable String jobId){
        financialDepartmentService.deleteJobDescriptionById(Integer.parseInt(jobId));
    }

    @GetMapping("/jobposition/{jobId}")
    public ResponseEntity<List<JobPositionDTO>> findJobPosition(@PathVariable Integer jobId){
        if(financialDepartmentService.findJobPosition(jobId).isEmpty()){
            log.info("Job Position Not Found for Id: {}", jobId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(financialDepartmentService.findJobPosition(jobId),HttpStatus.OK);
    }

    @GetMapping("/role/{id}")
    public ResponseEntity<Optional<RoleDTO>> findRoleById(@PathVariable String id){
        if(financialDepartmentService.findRoleById(Integer.parseInt(id)).isEmpty()){
            log.info("Role Not Found for Id: {}", id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(financialDepartmentService.findRoleById(Integer.parseInt(id)),HttpStatus.OK);
    }
}

