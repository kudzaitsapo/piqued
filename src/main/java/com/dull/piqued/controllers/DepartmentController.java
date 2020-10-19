package com.dull.piqued.controllers;

import com.dull.piqued.common.ResponseTemplate;
import com.dull.piqued.dto.DepartmentRequestDTO;
import com.dull.piqued.dto.DepartmentResponseDTO;
import com.dull.piqued.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping(produces = "application/json")
    public ResponseTemplate getAllDepartments() {
        List<DepartmentResponseDTO> departments = departmentService.getDepartments();
        return new ResponseTemplate("Successfully retrieved departments", departments);
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseTemplate saveDepartment(@RequestBody DepartmentRequestDTO departmentRequestDTO){
        DepartmentResponseDTO responseData = departmentService.createDepartment(departmentRequestDTO);
        return new ResponseTemplate("Successfully created the department", responseData);
    }
}
