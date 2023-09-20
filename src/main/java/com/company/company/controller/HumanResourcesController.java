package com.company.company.controller;

import com.company.company.dao.JobDescription;
import com.company.company.dao.ProfessionalInfo;
import com.company.company.dao.Worker;
import com.company.company.dao.WorkerJob;
import com.company.company.dto.EmployeeDTO;
import com.company.company.dto.NationalityDTO;
import com.company.company.dto.RoleDTO;
import com.company.company.dto.WorkerDataDTO;
import com.company.company.service.HumanResourcesService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@Log4j2
@RequestMapping("/humanresources")
public class HumanResourcesController {

    private final HumanResourcesService humanResourcesService;

    @GetMapping("/worker/findall")
    public ResponseEntity<List<Worker>> findAllWorkers(){
        if(humanResourcesService.findAllWorkers().isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(humanResourcesService.findAllWorkers(), HttpStatus.OK);
    }

    @GetMapping("/worker/findbyid/{id}")
    public ResponseEntity<Optional<Worker>> findWorkerById(@PathVariable String id){
        if(humanResourcesService.findWorkerById(Integer.parseInt(id)).isEmpty()){
            log.info("Worker not found with ID:{}", id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(humanResourcesService.findWorkerById(Integer.parseInt(id)),HttpStatus.OK);
    }

    @GetMapping("/professionalinfo/findbyid/{id}")
    public ResponseEntity<Optional> findProfessionalInfoById(@PathVariable String id){
        if(humanResourcesService.findProfessionalInfoById(Integer.parseInt(id)).isEmpty()){
            log.info("Professional Info not found for Id: {}", id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(humanResourcesService.findProfessionalInfoById(Integer.parseInt(id)),HttpStatus.OK);
    }


    @GetMapping("/workerjob/findbyid/{id}")
    public ResponseEntity<Optional<WorkerJob>> findWorkerJobById(@PathVariable String id){
        if(humanResourcesService.findWorkerById(Integer.parseInt(id)).isEmpty()){
            log.info("Worker Job not found for Id: {}", id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(humanResourcesService.findWorkerJobById(Integer.parseInt(id)),HttpStatus.OK);
    }


    @PostMapping("/worker/new")
    public ResponseEntity<String> newWorker(@RequestBody Worker worker){
        try{
            humanResourcesService.newWorker(worker);
            log.info("New worker saved");
            return ResponseEntity.status(200).body("New worker saved");
        }catch(Exception e){
            log.info("Error when saving worker: {}", e.getMessage());
            return ResponseEntity.status(500).body("Error when saving worker:" + e.getMessage());
        }

    }

    @DeleteMapping("/worker/delete/{workerId}")
    public ResponseEntity<String> deleteWorker(@PathVariable String workerId){
        try{
            humanResourcesService.deleteWorkerById(Integer.parseInt(workerId));
            log.info("Worker deleted with Id: {}", workerId);
            return ResponseEntity.status(200).body("Worker deleted");
        }catch(Exception e){
            return ResponseEntity.status(500).body("Error when deleting worker: " +
                    e.getMessage());
        }
    }

    @GetMapping("/workerjob/byId/{workerId}")
    public ResponseEntity<List<WorkerDataDTO>> findWorkerJobDataById(@PathVariable String workerId){
        if(humanResourcesService.findWorkerJobDataById(Integer.parseInt(workerId)).isEmpty()){
            log.info("Worker Job Data not found for Id: {}", workerId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(humanResourcesService.findWorkerJobDataById(Integer.parseInt(workerId)),HttpStatus.OK);
    }

    @GetMapping("/women/2020")
    public ResponseEntity<List<RoleDTO>> findWomenAfter2020(){
        if(humanResourcesService.findWomenAfter2020().isEmpty()){
            log.info("Not content found for Women After 2020");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(humanResourcesService.findWomenAfter2020(),HttpStatus.OK);
    }

    @GetMapping("/parttime/male")
    public ResponseEntity<List<RoleDTO>> findMalePartTime(){
        if(humanResourcesService.findMenPartTime().isEmpty()){
            log.info("Not content found for Male Part Time");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(humanResourcesService.findMenPartTime(),HttpStatus.OK);
    }

    @GetMapping("/nationality/{nationality}")
    public List<NationalityDTO> findDataByNationality(@PathVariable String nationality){
        return humanResourcesService.findDataByNationality(nationality);
    }
}

