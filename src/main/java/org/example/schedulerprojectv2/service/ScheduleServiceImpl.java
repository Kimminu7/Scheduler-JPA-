package org.example.schedulerprojectv2.service;

import lombok.RequiredArgsConstructor;
import org.example.schedulerprojectv2.dto.schedule.ScheduleResponseDto;
import org.example.schedulerprojectv2.entity.Schedule;
import org.example.schedulerprojectv2.repository.ScheduleRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

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

    // 일정 단건 조회
    @Override
    public ScheduleResponseDto findById(Long id) {

        Schedule findSchedule = scheduleRepository.findByIdOrElseThrow(id);

        return new ScheduleResponseDto(findSchedule.getId(), findSchedule.getTitle(), findSchedule.getUserName(), findSchedule.getContents());
    }

    // 일정 수정
    @Override
    // @Transactional도 가능함. ( 영속성 컨텍스트 ?? ) . . . 트랜잭션 단위를 잡는역할?
    public String update(Long id, String title, String contents) {

        Schedule findSchedule = scheduleRepository.findByIdOrElseThrow(id);

        findSchedule.update(title,contents);

        scheduleRepository.save(findSchedule);

        return "일정이 성공적으로 수정되었습니다.";
    }

    // 일정 삭제
    @Override
    public String delete(Long id) {

        Schedule findSchedule = scheduleRepository.findByIdOrElseThrow(id);

        scheduleRepository.delete(findSchedule);

        return "일정이 성공적으로 삭제되었습니다.";
    }
}
