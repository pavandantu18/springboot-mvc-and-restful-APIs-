package com.example.mvcArchitecture.Services;

import com.example.mvcArchitecture.dto.DepartmentDTO;
import com.example.mvcArchitecture.entity.DepartmentEntity;
import com.example.mvcArchitecture.entity.EmployeeEntity;
import com.example.mvcArchitecture.exceptions.ResourceNotFoundException;
import com.example.mvcArchitecture.repositories.DepartmentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    private final ModelMapper modelMapper;

    public DepartmentService(DepartmentRepository departmentRepository, ModelMapper modelMapper) {
        this.departmentRepository = departmentRepository;
        this.modelMapper = modelMapper;
    }

    public Optional<DepartmentDTO> getDepartmentById(Long id) {
        isExistsByDepartmentId(id);
        Optional<DepartmentEntity> departmentEntity = departmentRepository.findById(id);
        Optional<DepartmentDTO> mapper = departmentEntity.map(departmentEntity1 -> modelMapper.map(departmentEntity1,DepartmentDTO.class));
        return mapper;

    }

    public DepartmentDTO createDepartment(DepartmentDTO inputdepartment) {

        DepartmentEntity departmentEntity = modelMapper.map(inputdepartment,DepartmentEntity.class);
        DepartmentDTO departmentDTO = modelMapper.map(departmentRepository.save(departmentEntity),DepartmentDTO.class);
        return departmentDTO;


    }

    public List<DepartmentDTO> getAllDepartments() {
        List<DepartmentEntity> departmentEntity = departmentRepository.findAll();
        return departmentEntity.
                stream()
                .map(departmentEntity1 -> modelMapper.map(departmentEntity1,DepartmentDTO.class))
                .collect(Collectors.toList());
    }

    public Boolean deleteDepartmentById(Long id) {
        isExistsByDepartmentId(id);

        try {
            departmentRepository.deleteById(id);
            return true;
        }catch (Exception e) {
            System.out.println(e);
        }

        return false;
    }

    public DepartmentDTO patchDepartment(Long id, Map<String,Object> updates) {
        isExistsByDepartmentId(id);
        DepartmentEntity departmentEntity = departmentRepository.findById(id).orElse(null);

        updates.forEach((field,value) -> {
            Field fieldToBeUpdated = ReflectionUtils.getRequiredField(DepartmentEntity.class,field);
            fieldToBeUpdated.setAccessible(true);
            ReflectionUtils.setField(fieldToBeUpdated,departmentEntity,value);
        });

        return modelMapper.map(departmentRepository.save(departmentEntity),DepartmentDTO.class);
    }

    public void isExistsByDepartmentId(Long departmentId) {
        boolean exists = departmentRepository.existsById((departmentId));
        if(!exists) throw new ResourceNotFoundException("Department not found with id " + departmentId);
    }
}
