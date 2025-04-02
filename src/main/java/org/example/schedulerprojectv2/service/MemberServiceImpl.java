package org.example.schedulerprojectv2.service;

import lombok.RequiredArgsConstructor;
import org.example.schedulerprojectv2.dto.user.MemberResponseDto;
import org.example.schedulerprojectv2.entity.Member;
import org.example.schedulerprojectv2.repository.MemberRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    @Override
    public MemberResponseDto createMember(String userName, String email, String password) {

        Member createMember = new Member(userName, email, password);
        Member createdMember = memberRepository.save(createMember);
        return new MemberResponseDto(createdMember.getId(), createdMember.getUserName(), createdMember.getEmail());
    }
}
