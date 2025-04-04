package org.example.schedulerprojectv2.service;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.example.schedulerprojectv2.dto.member.LoginRequestDto;
import org.example.schedulerprojectv2.dto.member.MemberResponseDto;
import org.example.schedulerprojectv2.entity.Member;
import org.example.schedulerprojectv2.repository.MemberRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    // 유저 생성
    @Override
    public MemberResponseDto createMember(String userName, String email, String password) {

        Member createMember = new Member(userName, email, password);
        Member createdMember = memberRepository.save(createMember);
        return new MemberResponseDto(createdMember.getId(), createdMember.getUserName(), createdMember.getEmail());
    }

    // 유저 전체 조회
    @Override
    public List<MemberResponseDto> findAll() {

        return memberRepository.findAll()
                .stream()
                .map(MemberResponseDto::toDto)
                .toList();
    }

    // 유저 단건 조회
    @Override
    public MemberResponseDto findById(Long id) {

        Member findMember = memberRepository.findByIdOrElseThrow(id);

        return new MemberResponseDto(findMember.getId(), findMember.getUserName(), findMember.getEmail());
    }

    // 유저 정보 전체 수정
    @Override
    public String update(Long id, String userName, String email, String password) {

        Member findMember = memberRepository.findByIdOrElseThrow(id);

        findMember.update(userName, email, password);

        memberRepository.save(findMember);

        return "id = " + id + " 사용자 정보가 성공적으로 수정되었습니다";
    }

    // 유저 비밀번호만 수정
    @Override
    public String updatePassword(Long id, String password) {

        Member findMember = memberRepository.findByIdOrElseThrow(id);

        findMember.updatePassword(password);

        Member updatedMember = memberRepository.save(findMember);
        // 비밀번호 확인용으로 호출 ( 절대로 민감정보를 노출해선 안됨 ! ! )
        return "password = " + updatedMember.getPassword() + " 비밀번호가 성공적으로 변경되었습니다.";
    }

    // 유저 삭제
    @Override
    public String delete(Long id) {

        Member findMember = memberRepository.findByIdOrElseThrow(id);

        memberRepository.delete(findMember);

        return "유저가 성공적으로 삭제되었습니다.";
    }

    // 로그인 ( + 튜터님 도움 )
    @Override
    public void login(LoginRequestDto requestDto, HttpSession httpSession) {

        Member findMember = memberRepository.findByEmail(requestDto.getEmail()).orElseThrow();

        if (Objects.equals(requestDto.getPassword(), findMember.getPassword())) {
            httpSession.setAttribute("memberEmail", findMember.getEmail());
        } else {
            throw new RuntimeException("비밀번호가 다릅니다.");
        }
    }

    // 로그아웃
    @Override
    public void logout(HttpSession httpSession) {

        httpSession.invalidate(); // 세션 끊기
    }
}
