package org.example.schedulerprojectv2.service;

import org.example.schedulerprojectv2.dto.schedule.ScheduleResponseDto;

import java.util.List;

public interface ScheduleService {

    ScheduleResponseDto addSchedule(String title, String userName, String contents);

    List<ScheduleResponseDto> findAll();
}
