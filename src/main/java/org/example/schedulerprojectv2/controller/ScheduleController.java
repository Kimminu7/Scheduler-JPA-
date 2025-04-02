package org.example.schedulerprojectv2.controller;

import lombok.RequiredArgsConstructor;
import org.example.schedulerprojectv2.dto.schedule.CreateScheduleRequetsDto;
import org.example.schedulerprojectv2.dto.schedule.ScheduleResponseDto;
import org.example.schedulerprojectv2.service.ScheduleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schedules")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    // 일정 생성
    @PostMapping
    public ResponseEntity<ScheduleResponseDto> addSchedule(@RequestBody CreateScheduleRequetsDto requetsDto) {

        ScheduleResponseDto responseDto = scheduleService.addSchedule(requetsDto.getTitle(), requetsDto.getUserName(), requetsDto.getContents());

        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    // 일정 전체 조회
    @GetMapping
    public ResponseEntity<List<ScheduleResponseDto>> findAll() {

        List<ScheduleResponseDto> responseDtoList = scheduleService.findAll();

        return new ResponseEntity<>(responseDtoList,HttpStatus.OK);
    }

    // 일정 단건 조회

    // 일정 수정

    // 일정 삭제
}
