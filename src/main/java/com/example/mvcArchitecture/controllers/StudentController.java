package com.example.mvcArchitecture.controllers;

import com.example.mvcArchitecture.dto.EmployeeDTO;
import com.example.mvcArchitecture.dto.StudentDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/students")
public class StudentController {

    @GetMapping(path = "/welcome")
    public String welcome() {
        return "Hello All!";
    }

    @GetMapping(path = "/{id}")
    public StudentDTO getStudentById(@PathVariable Long id) {
        return new StudentDTO(id,"Pavan","pavan@gmail.com",24);
    }

    @GetMapping
    public String getStudents(@RequestParam(required = false) String name) {
        return " " + name;
    }

    @PostMapping
    public StudentDTO createStudent(@RequestBody StudentDTO inputStudent) {
        return inputStudent;
    }
}
