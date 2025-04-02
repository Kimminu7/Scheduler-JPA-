package org.example.schedulerprojectv2.service;

import lombok.RequiredArgsConstructor;
import org.example.schedulerprojectv2.dto.schedule.ScheduleResponseDto;
import org.example.schedulerprojectv2.entity.Schedule;
import org.example.schedulerprojectv2.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleServiceImpl implements ScheduleService {

    private final ScheduleRepository scheduleRepository;

    // 일정 생성
    @Override
    public ScheduleResponseDto addSchedule(String title, String userName, String contents) {

        Schedule schedule = new Schedule(title, userName, contents);

        Schedule addSchdule = scheduleRepository.save(schedule);

        return new ScheduleResponseDto(addSchdule.getId(), addSchdule.getTitle(), addSchdule.getUserName(), addSchdule.getContents());
    }

    // 일정 전체 조회
    @Override
    public List<ScheduleResponseDto> findAll() {

        return scheduleRepository.findAll()
                .stream()
                .map(ScheduleResponseDto::toDto)
                .toList();
    }
}
