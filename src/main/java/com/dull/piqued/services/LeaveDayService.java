package com.dull.piqued.services;

import com.dull.piqued.dto.LeaveDayRequestDTO;
import com.dull.piqued.dto.LeaveDayResponseDTO;
import com.dull.piqued.models.Employee;
import com.dull.piqued.models.LeaveDay;
import com.dull.piqued.repositories.EmployeeRepository;
import com.dull.piqued.repositories.LeaveDayRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LeaveDayService {

    @Autowired
    private LeaveDayRepository leaveDayRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<LeaveDayResponseDTO> getEmployeeLeaveDays(long employeeId) throws Exception {
        Employee employee = employeeRepository.findById(employeeId).orElse(null);
        if (employee != null) {
            return leaveDayRepository.findAllByEmployee(employee)
                    .stream()
                    .map(leaveDay -> modelMapper.map(leaveDay, LeaveDayResponseDTO.class))
                    .collect(Collectors.toList());
        } else {
            throw new Exception("Employee not found!!");
        }
    }

    public LeaveDayResponseDTO createEmployeeLeaveDay(long employeeId, LeaveDayRequestDTO leaveDayRequest) throws Exception {
        Employee employee = employeeRepository.findById(employeeId).orElse(null);
        if (employee != null) {
            LeaveDay leave = modelMapper.map(leaveDayRequest, LeaveDay.class);
            leave.setEmployee(employee);
            LeaveDay savedLeave = leaveDayRepository.save(leave);
            return modelMapper.map(savedLeave, LeaveDayResponseDTO.class);
        } else {
            throw new Exception("Employee not found!!");
        }
    }
}
