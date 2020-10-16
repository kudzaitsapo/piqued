package com.dull.piqued.services;

import com.dull.piqued.dto.EmployeeRequestDTO;
import com.dull.piqued.dto.EmployeeResponseDTO;
import com.dull.piqued.models.Employee;
import com.dull.piqued.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ModelMapper modelMapper;

    public EmployeeResponseDTO createEmployee(EmployeeRequestDTO employeeData) throws Exception {
        if (!employeeRepository.existsByEmail(employeeData.getEmail())) {
            Employee employee = modelMapper.map(employeeData, Employee.class);
            Employee savedEmployee = employeeRepository.save(employee);

            EmployeeResponseDTO response = modelMapper.map(savedEmployee, EmployeeResponseDTO.class);
            return response;
        } else {
            throw new Exception("Employee email already exists!");
        }
    }

    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }



}
