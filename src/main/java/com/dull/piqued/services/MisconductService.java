package com.dull.piqued.services;

import com.dull.piqued.dto.EmployeeResponseDTO;
import com.dull.piqued.dto.MisconductRequestDTO;
import com.dull.piqued.dto.MisconductResponseDTO;
import com.dull.piqued.models.Employee;
import com.dull.piqued.models.Misconduct;
import com.dull.piqued.repositories.EmployeeRepository;
import com.dull.piqued.repositories.MisconductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MisconductService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private MisconductRepository misconductRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<Employee> getEmployeesFromIds(List<Long> employeeIds) {
        List<Employee> employees = new ArrayList<>();
        for (int index = 0; index < employeeIds.size(); index ++) {
            Employee employee = employeeRepository.findById(employeeIds.get(index)).orElse(null);
            if (employee != null) {
                employees.add(employee);
            }
        }
        return employees;
    }

    public MisconductResponseDTO createEmployeeMisconduct(MisconductRequestDTO misconductRequest) {
        List<Employee> employees = getEmployeesFromIds(misconductRequest.getEmployeeIds());
        Misconduct misconduct = modelMapper.map(misconductRequest, Misconduct.class);
        misconduct.setEmployees(employees);
        Misconduct savedMisconduct = misconductRepository.save(misconduct);
        return modelMapper.map(savedMisconduct, MisconductResponseDTO.class);
    }

    public List<MisconductResponseDTO> getEmployeeMisconducts(long employeeId) throws Exception {
        Employee employee = employeeRepository.findById(employeeId).orElse(null);
        if (employee != null) {
            return employee
                    .getMisconducts()
                    .stream()
                    .map(misconduct -> modelMapper.map(misconduct, MisconductResponseDTO.class))
                    .collect(Collectors.toList());
        } else{
            throw new Exception("Employee does not exist!");
        }
    }
}
