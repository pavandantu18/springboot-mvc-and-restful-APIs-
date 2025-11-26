package com.example.mvcArchitecture.controllers;

import com.example.mvcArchitecture.Services.EmployeeService;
import com.example.mvcArchitecture.dto.EmployeeDTO;
import com.example.mvcArchitecture.entity.EmployeeEntity;
import com.example.mvcArchitecture.repositories.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/{employeeId}")
    public EmployeeDTO getEmployeeById(@PathVariable(name = "employeeId") Long id) {
        return employeeService.getEmployeeById(id);
    }

//    http://localhost:8080/employees?age=12&sortBy=age
    @GetMapping
    public List<EmployeeDTO> getAllEmployees(@RequestParam(required = false) Integer age,
                                                @RequestParam(required = false) String sortBy) {
        return employeeService.getAllEmployees();
    }

    @PostMapping
    public EmployeeDTO createEmployee(@RequestBody EmployeeDTO inputEmployee) {
        return employeeService.createEmployee(inputEmployee);
    }

    @PutMapping
    public String putEmployee() {
        return "Message from PUT...";
    }
}
