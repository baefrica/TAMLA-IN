package com.ssafy.db.repository;

import com.ssafy.db.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    Optional<Schedule> findById(Long id);
    Optional<List<Schedule>> findAllByUserIdAndIsDeleteFalse(Long id);
}
