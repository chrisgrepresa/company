package com.company.company.service;

import com.company.company.dao.*;
import com.company.company.dto.EmployeeDTO;
import com.company.company.dto.NationalityDTO;
import com.company.company.dto.RoleDTO;
import com.company.company.dto.WorkerDataDTO;
import com.company.company.repository.*;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Log4j2
public class HumanResourcesService {
    private final ProfessionalInfoRepository professionalInfoRepository;
    private final WorkerJobRepository workerJobRepository;
    private final WorkerRepository workerRepository;
    private final GenderRepository genderRepository;
    private final ContractTypeRepository contractTypeRepository;


    public List<Worker> findAllWorkers() {

        return workerRepository.findAll();
    }

    public Optional<Worker> findWorkerById(Integer id) {
        return workerRepository.findById(id);
    }

    public Optional<ProfessionalInfo> findProfessionalInfoById(Integer id) {
        return professionalInfoRepository.findById(id);
    }

    public Optional<WorkerJob> findWorkerJobById(Integer id) {
        return workerJobRepository.findById(id);
    }

    public void newWorker(Worker worker) {
        log.info("Saved worker with name: {}", worker.getFirstName());
        workerRepository.save(worker);
    }

    public void deleteWorkerById(Integer workerId) {
        workerRepository.deleteById(workerId);
        log.info("Worker with id {} was deleted", workerId);
    }

    public List<WorkerDataDTO> findWorkerJobDataById(Integer workerId){
        return workerJobRepository.findWorkerJobDataById(workerId);
    }

    public List<RoleDTO> findWomenAfter2020(){
        return genderRepository.findWomenAfter2020();
    }
    public List<RoleDTO> findMenPartTime(){
        return genderRepository.findMenPartTime();
    }


    public List<NationalityDTO> findDataByNationality(String nationality){
        return workerRepository.findDataByNationality(nationality);
    }
}
