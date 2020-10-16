package com.dull.piqued.repositories;

import com.dull.piqued.models.LeaveDay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaveDayRepository extends JpaRepository<LeaveDay, Long> {
}
