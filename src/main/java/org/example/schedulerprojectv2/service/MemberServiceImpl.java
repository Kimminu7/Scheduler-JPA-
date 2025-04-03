package org.example.schedulerprojectv2.service;

import lombok.RequiredArgsConstructor;
import org.example.schedulerprojectv2.dto.user.MemberResponseDto;
import org.example.schedulerprojectv2.entity.Member;
import org.example.schedulerprojectv2.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public MemberResponseDto update() {
        return null;
    }
}
