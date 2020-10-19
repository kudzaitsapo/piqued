package com.dull.piqued.repositories;

import com.dull.piqued.models.Employee;
import com.dull.piqued.models.LeaveDay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeaveDayRepository extends JpaRepository<LeaveDay, Long> {
    List<LeaveDay> findAllByEmployee(Employee employee);
}
