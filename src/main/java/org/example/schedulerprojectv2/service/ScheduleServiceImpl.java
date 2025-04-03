package org.example.schedulerprojectv2.service;

import lombok.RequiredArgsConstructor;
import org.example.schedulerprojectv2.dto.schedule.ScheduleResponseDto;
import org.example.schedulerprojectv2.entity.Member;
import org.example.schedulerprojectv2.entity.Schedule;
import org.example.schedulerprojectv2.repository.MemberRepository;
import org.example.schedulerprojectv2.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleServiceImpl implements ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final MemberRepository memberRepository; // 멤버에서 조회한 값을 가져와야 하기 때문에 의존성 주입을 받는다.

    // 일정 생성
    @Override
    public ScheduleResponseDto addSchedule(Long id, String title, String contents, String requetsDtoContents) {

        // 튜터님의 새로운 예외처리 방법 !! Optional 예외처리 하는법 대체
        Member member = memberRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Not Found Member" + id)
        );

        Schedule schedule = new Schedule(title, contents, member);

        Schedule addSchdule = scheduleRepository.save(schedule);

        return new ScheduleResponseDto(addSchdule.getId(), addSchdule.getTitle(), addSchdule.getMember().getUserName() , addSchdule.getContents());
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

        return new ScheduleResponseDto(findSchedule.getId(), findSchedule.getTitle(), findSchedule.getMember().getUserName(), findSchedule.getContents());
    }

    // 일정 수정
    //@Transactional // 도 가능함. ( 영속성 컨텍스트 ?? ) . . . 트랜잭션 단위를 잡는역할?
    // 1 2 3 하나로 묶는다
    @Override
    public String update(Long id, String title, String contents) {

        Schedule findSchedule = scheduleRepository.findByIdOrElseThrow(id);

        findSchedule.update(title,contents);
        // 여기서 예외가발생하면? 롤백?
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
