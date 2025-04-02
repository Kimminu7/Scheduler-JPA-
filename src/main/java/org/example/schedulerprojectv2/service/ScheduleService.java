package org.example.schedulerprojectv2.service;

import org.example.schedulerprojectv2.dto.schedule.ScheduleResponseDto;

import java.util.List;

public interface ScheduleService {

    ScheduleResponseDto addSchedule(String title, String userName, String contents);

    List<ScheduleResponseDto> findAll();

    ScheduleResponseDto findById(Long id);

    String update(Long id, String title, String contents);

    String delete(Long id);
}
