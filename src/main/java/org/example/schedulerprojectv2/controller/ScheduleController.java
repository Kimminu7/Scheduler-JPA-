package org.example.schedulerprojectv2.controller;

import lombok.RequiredArgsConstructor;
import org.example.schedulerprojectv2.dto.schedule.CreateScheduleRequetsDto;
import org.example.schedulerprojectv2.dto.schedule.ScheduleResponseDto;
import org.example.schedulerprojectv2.dto.schedule.UpdateScheduleRequestDto;
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
    public ResponseEntity<ScheduleResponseDto> addSchedule(
            @RequestParam Long userId,
            @RequestBody CreateScheduleRequetsDto requetsDto
    ) {

        ScheduleResponseDto responseDto = scheduleService.addSchedule(userId ,requetsDto.getTitle(), requetsDto.getUserName(), requetsDto.getContents());

        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    // 일정 전체 조회
    @GetMapping
    public ResponseEntity<List<ScheduleResponseDto>> findAll() {

        List<ScheduleResponseDto> responseDtoList = scheduleService.findAll();

        return new ResponseEntity<>(responseDtoList,HttpStatus.OK);
    }

    // 일정 단건 조회
    @GetMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> findAllById(@PathVariable Long id) {

        ScheduleResponseDto responseDto = scheduleService.findById(id);

        return new ResponseEntity<>(responseDto,HttpStatus.OK);
    }

    // 일정 수정
    @PutMapping("/{id}")
    public ResponseEntity<String> updateSchedule(
            @PathVariable Long id,
            @RequestBody UpdateScheduleRequestDto requestDto
    ) {
        String requestUpdate = scheduleService.update(id, requestDto.getTitle(), requestDto.getContents());

        return new ResponseEntity<>(requestUpdate,HttpStatus.OK);
    }

    // 일정 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSchedule(@PathVariable Long id) {

        String responseDelete = scheduleService.delete(id);

        return new ResponseEntity<>(responseDelete,HttpStatus.OK);
    }

}
