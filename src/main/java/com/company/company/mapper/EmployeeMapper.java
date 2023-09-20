package com.company.company.mapper;

import com.company.company.dao.ProfessionalInfo;
import com.company.company.dao.Worker;
import com.company.company.dao.WorkerJob;
import com.company.company.dto.EmployeeDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Date;

@Component
public class EmployeeMapper {

    public Worker employeeDTOToWorker(EmployeeDTO employeeDTO) {
        if(employeeDTO == null){
            return null;
        }
        Worker worker = new Worker();
        worker.setFirstName(employeeDTO.getFirstName());
        worker.setMiddleName(employeeDTO.getMiddleName());
        worker.setLastName(employeeDTO.getLastName());
        worker.setDateOfBirth(employeeDTO.getDateOfBirth());
        worker.setAddress(employeeDTO.getAddress());
        worker.setCity(employeeDTO.getCity());
        worker.setState(employeeDTO.getState());
        worker.setCountry(employeeDTO.getCountry());
        worker.setPostalCode(employeeDTO.getPostalCode());
        worker.setPhoneNumber(employeeDTO.getPhoneNumber());
        worker.setAlternatePhoneNumber(employeeDTO.getAlternatePhoneNumber());
        worker.setEmail(employeeDTO.getEmail());
        worker.setGenderId(employeeDTO.getGenderId());
        worker.setNationality(employeeDTO.getNationality());
        return worker;
    }

    public ProfessionalInfo employeeDTOToProfessionalInfo(EmployeeDTO employeeDTO){
        if(employeeDTO == null){
            return null;
        }
        ProfessionalInfo professionalInfo = new ProfessionalInfo();
        professionalInfo.setQualification(employeeDTO.getQualification());
        professionalInfo.setSpecialization(employeeDTO.getSpecialization());
        professionalInfo.setYearsOfExperience(employeeDTO.getYearsOfExperience());
        professionalInfo.setPreviousCompany(employeeDTO.getPreviousCompany());
        professionalInfo.setPreviousJobTitle(employeeDTO.getPreviousJobTitle());
        professionalInfo.setStartingDate(employeeDTO.getPreviousJobStartDate());
        professionalInfo.setEndDate(employeeDTO.getPreviousJobEndDate());
        return professionalInfo;
    }

    public WorkerJob employeeDTOToWorkerJob(EmployeeDTO employeeDTO){
        if(employeeDTO == null){
            return null;
        }
        WorkerJob workerJob = new WorkerJob();
        workerJob.setJobId(employeeDTO.getJobId());
        workerJob.setStartDate(employeeDTO.getJobStartDate());
        workerJob.setEndDate(employeeDTO.getJobEndDate());
        workerJob.setSalary(employeeDTO.getSalary());
        workerJob.setContractTypeId(employeeDTO.getContractTypeId());
        workerJob.setDepartment(employeeDTO.getDepartment());
        return workerJob;
    }

}
