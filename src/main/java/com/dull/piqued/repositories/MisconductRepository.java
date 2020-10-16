package com.dull.piqued.repositories;

import com.dull.piqued.models.Misconduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MisconductRepository extends JpaRepository<Misconduct, Long> {
}
