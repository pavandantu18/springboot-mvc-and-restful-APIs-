package com.example.mvcArchitecture.controllers;

import com.example.mvcArchitecture.Services.DepartmentService;
import com.example.mvcArchitecture.dto.DepartmentDTO;
import com.example.mvcArchitecture.exceptions.ResourceNotFoundException;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path = "/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping
    public ResponseEntity<List<DepartmentDTO>> getAllDepartments() {
        return ResponseEntity.ok(departmentService.getAllDepartments());
    }

    @GetMapping(path = "/{departmentId}")
    public ResponseEntity<DepartmentDTO> getDepartmentById(@PathVariable(name = "departmentId") Long id) {
        Optional<DepartmentDTO> departmentDTO = departmentService.getDepartmentById(id);
        return departmentDTO.map(departmentDTO1 -> ResponseEntity.ok(departmentDTO1))
                .orElseThrow(() -> new ResourceNotFoundException("Department Not Found with id " + id));
    }

    @PostMapping
    public ResponseEntity<DepartmentDTO> createDepartment(@RequestBody @Valid DepartmentDTO inputdepartment) {
        DepartmentDTO departmentDTO = departmentService.createDepartment(inputdepartment);
        return new ResponseEntity<>(departmentDTO, HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{departmentId}")
    public ResponseEntity<Boolean> deleteDepartmentById(@PathVariable(name = "departmentId") Long id) {
        Boolean gotDeleted = departmentService.deleteDepartmentById(id);
        if(gotDeleted) return ResponseEntity.ok(true);
        return ResponseEntity.notFound().build();
    }

    @PatchMapping(path = "/{departmentId}")
    public ResponseEntity<DepartmentDTO> patchDepartment(@PathVariable(name = "departmentId") Long id, @Valid @RequestBody Map<String,Object> updates) {
        DepartmentDTO departmentDTO =  departmentService.patchDepartment(id,updates);
        if(departmentDTO == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(departmentDTO);
    }
}
