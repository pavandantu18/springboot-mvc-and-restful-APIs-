package com.example.mvcArchitecture.controllers;

import com.example.mvcArchitecture.dto.EmployeeDTO;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {
    @GetMapping(path = "/getSecretMessage")
    public String getMySuperSecretMessage() {
        return "Secret Message: asdfrhufh@rij";
    }

//    @GetMapping(path = "/{employeeId}")
//    public EmployeeDTO getEmployeeById(@PathVariable Long employeeId) {
//        return new EmployeeDTO(employeeId,"Pavan", "pavan@gmail.com",23, LocalDate.of(2024,1,2), true);
//    }
    @GetMapping(path = "/{employeeId}")
    public EmployeeDTO getEmployeeById(@PathVariable(name = "employeeId") Long id) {
        return new EmployeeDTO(id,"Pavan", "pavan@gmail.com",23, LocalDate.of(2024,1,2), true);
    }

//    http://localhost:8080/employees?age=12&sortBy=age
    @GetMapping
    public String getAllEmployees(@RequestParam(required = false) Integer age,
                                  @RequestParam(required = false) String sortBy) {
        return "Hi age" + age + " " + sortBy;
    }

    @PostMapping
    public EmployeeDTO createEmployee(@RequestBody EmployeeDTO inputEmployee) {
        inputEmployee.setId(100L);
        return inputEmployee;
    }

    @PutMapping
    public String putEmployee() {
        return "Message from PUT...";
    }
}
