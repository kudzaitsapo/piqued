package com.dull.piqued.services;

import com.dull.piqued.dto.EmployeeRequestDTO;
import com.dull.piqued.dto.EmployeeResponseDTO;
import com.dull.piqued.models.Department;
import com.dull.piqued.models.Employee;
import com.dull.piqued.models.Job;
import com.dull.piqued.repositories.DepartmentRepository;
import com.dull.piqued.repositories.EmployeeRepository;
import com.dull.piqued.repositories.JobRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private ModelMapper modelMapper;

    public EmployeeResponseDTO createEmployee(EmployeeRequestDTO employeeData) throws Exception {
        if (!employeeRepository.existsByEmail(employeeData.getEmail())) {
            Employee employee = modelMapper.map(employeeData, Employee.class);
            Employee savedEmployee = employeeRepository.save(employee);
            return modelMapper.map(savedEmployee, EmployeeResponseDTO.class);
        } else {
            throw new Exception("Employee email already exists!");
        }
    }

    public List<EmployeeResponseDTO> getEmployees() {

        List<Employee> employeesList = employeeRepository.findAll();
        return employeesList
                .stream()
                .map(employee -> modelMapper.map(employee, EmployeeResponseDTO.class))
                .collect(Collectors.toList());
    }

    public EmployeeResponseDTO assignJob(long jobId, long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElse(null);
        Job job = jobRepository.findById(jobId).orElse(null);

        if (employee != null && job != null) {
            employee.setJob(job);
            employeeRepository.save(employee);
        }
        return modelMapper.map(employee, EmployeeResponseDTO.class);
    }

    public EmployeeResponseDTO assignDepartment(long departmentId, long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElse(null);
        Department department = departmentRepository.findById(departmentId).orElse(null);

        if (employee != null && department != null) {
            employee.setDepartment(department);
            employeeRepository.save(employee);
        }
        return modelMapper.map(employee, EmployeeResponseDTO.class);
    }

    public EmployeeResponseDTO getEmployeeById(long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElse(null);
        return modelMapper.map(employee, EmployeeResponseDTO.class);
    }


}
