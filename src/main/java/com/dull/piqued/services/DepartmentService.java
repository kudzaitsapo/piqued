package com.dull.piqued.services;

import com.dull.piqued.dto.DepartmentRequestDTO;
import com.dull.piqued.dto.DepartmentResponseDTO;
import com.dull.piqued.models.Department;
import com.dull.piqued.repositories.DepartmentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private ModelMapper modelMapper;

    public DepartmentResponseDTO createDepartment(DepartmentRequestDTO departmentRequest) {

        Department department = modelMapper.map(departmentRequest, Department.class);
        Department savedDepartment = departmentRepository.save(department);
        return modelMapper.map(savedDepartment, DepartmentResponseDTO.class);
    }

    public List<DepartmentResponseDTO> getDepartments() {
        List<Department> departments = departmentRepository.findAll();
        return departments
                .stream()
                .map(department -> modelMapper.map(department, DepartmentResponseDTO.class))
                .collect(Collectors.toList());
    }
}
