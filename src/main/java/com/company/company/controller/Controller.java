package com.company.company.controller;

import com.company.company.dto.EmployeeDTO;
import com.company.company.dto.RoleDTO;
import com.company.company.service.Service;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/controller")
public class Controller {

    private final Service service;

    @PostMapping("/new/employee")
    public void newEmployee(@RequestBody EmployeeDTO employeeDTO){
        service.newEmployee(employeeDTO);
    }


    @GetMapping("/salary/{genderId}")
    public Float checkSalaryByGender(@PathVariable String genderId, @RequestBody List<EmployeeDTO> employees){
        return service.checkSalaryByGender(Integer.parseInt(genderId), employees);
    }

}
