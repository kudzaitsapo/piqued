package com.dull.piqued.controllers;

import com.dull.piqued.common.ResponseTemplate;
import com.dull.piqued.dto.EmployeeRequestDTO;
import com.dull.piqued.dto.EmployeeResponseDTO;
import com.dull.piqued.models.Employee;
import com.dull.piqued.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/employees")
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public ResponseTemplate getCompanyEmployees() {
        ResponseTemplate response = new ResponseTemplate();
        List<Employee> employees = employeeService.getEmployees();
        response.setMessage("Successfully retrieved data.");
        response.setData(employees);
        return response;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseTemplate createCompanyEmployee(@RequestBody EmployeeRequestDTO employee) {
        ResponseTemplate response = new ResponseTemplate();
        try{
            EmployeeResponseDTO responseDTO = employeeService.createEmployee(employee);

            response.setData(responseDTO);

        } catch (Exception ex) {
            response.setMessage(ex.getMessage());
        }

        return response;
    }
}
