package com.company.company.service;

import com.company.company.dao.ProfessionalInfo;
import com.company.company.dao.Worker;
import com.company.company.dao.WorkerJob;
import com.company.company.dto.EmployeeDTO;
import com.company.company.repository.ProfessionalInfoRepository;
import com.company.company.repository.WorkerJobRepository;
import com.company.company.repository.WorkerRepository;
import com.company.company.mapper.EmployeeMapper;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.hibernate.jdbc.Work;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@org.springframework.stereotype.Service
@AllArgsConstructor
@Log4j2
public class Service {

    private final WorkerRepository workerRepository;
    private final ProfessionalInfoRepository professionalInfoRepository;
    private final WorkerJobRepository workerJobRepository;
    private final EmployeeMapper employeeMapper;

    public void newEmployee (EmployeeDTO employeeDTO){
        Worker worker = employeeMapper.employeeDTOToWorker(employeeDTO);
        ProfessionalInfo professionalInfo = employeeMapper.employeeDTOToProfessionalInfo(employeeDTO);
        WorkerJob workerJob = employeeMapper.employeeDTOToWorkerJob(employeeDTO);

        workerRepository.save(worker);
        log.info("Worker saved: {}", worker);
        professionalInfoRepository.save(professionalInfo);
        log.info("Professional Info saved: {}", professionalInfo);
        workerJobRepository.save(workerJob);
        log.info("WorkerJob saved: {}", workerJob);
    }

    public Float checkSalaryByGender(Integer genderId, List<EmployeeDTO> employees){
        return (float)employees.stream()
                .filter(employee -> employee.getGenderId() == genderId)
                .mapToDouble(EmployeeDTO::getSalary)
                .sum();
    }

}
