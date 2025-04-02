package org.example.schedulerprojectv2.repository;


import org.example.schedulerprojectv2.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {


}
