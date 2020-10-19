package com.dull.piqued.controllers;

import com.dull.piqued.common.ResponseTemplate;
import com.dull.piqued.dto.*;
import com.dull.piqued.services.EmployeeService;
import com.dull.piqued.services.LeaveDayService;
import com.dull.piqued.services.MisconductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/employees")
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private LeaveDayService leaveDayService;

    @Autowired
    private MisconductService misconductService;

    @GetMapping(produces = "application/json")
    public ResponseTemplate getCompanyEmployees() {
        List<EmployeeResponseDTO> employees = employeeService.getEmployees();
        return new ResponseTemplate("Successfully retrieved data.", employees);
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

    @GetMapping("/{employeeId}/assignJob")
    public ResponseTemplate assignJob(@RequestParam(name = "jobId") long jobId, @PathVariable(value = "employeeId") long employeeId) {
        EmployeeResponseDTO responseData = employeeService.assignJob(jobId, employeeId);

        return new ResponseTemplate("Successfully assigned the job", responseData);
    }

    @GetMapping("/{employeeId}/assignDepartment")
    public ResponseTemplate assignDepartment(@PathVariable(value = "employeeId") long employeeId,
                                             @RequestParam(name = "departmentId") long departmentId) {
        EmployeeResponseDTO responseData = employeeService.assignDepartment(departmentId, employeeId);

        return new ResponseTemplate("Successfully assigned department", responseData);
    }

    @GetMapping("/{employeeId}/leaveDays")
    public ResponseTemplate getLeaveDays(@PathVariable(value = "employeeId") long employeeId) {
        ResponseTemplate response = new ResponseTemplate();
        try{
            List<LeaveDayResponseDTO> leaveDays = leaveDayService.getEmployeeLeaveDays(employeeId);
            response.setMessage("Successfully retrieved leave days");
            response.setData(leaveDays);
        } catch (Exception ex) {
            response.setMessage(ex.getMessage());
        }

        return response;
    }

    @PostMapping("/{employeeId}/leaveDays")
    public ResponseTemplate addLeaveDays(@PathVariable(value = "employeeId") long employeeId, @RequestBody LeaveDayRequestDTO leave) {
        ResponseTemplate response = new ResponseTemplate();
        try {
            response.setMessage("Successfully saved employee leave");
            LeaveDayResponseDTO leaveDay = leaveDayService.createEmployeeLeaveDay(employeeId, leave);
            response.setData(leaveDay);

        } catch (Exception ex) {
           response.setMessage(ex.getMessage());
        }

        return response;
    }

    @GetMapping("/{employeeId}/misconducts")
    public ResponseTemplate getMisconducts(@PathVariable(value = "employeeId") long employeeId) {
        ResponseTemplate response = new ResponseTemplate();
        try {
            List<MisconductResponseDTO> misconducts = misconductService.getEmployeeMisconducts(employeeId);
            response.setMessage("Successfully retrieved misconducts");
            response.setData(misconducts);
        } catch (Exception ex) {
            response.setMessage(ex.getMessage());
        }
        return response;
    }

}
