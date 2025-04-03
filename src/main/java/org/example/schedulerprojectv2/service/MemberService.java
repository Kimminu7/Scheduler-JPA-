package org.example.schedulerprojectv2.service;

import org.example.schedulerprojectv2.dto.user.MemberResponseDto;

import java.util.List;

public interface MemberService {

    MemberResponseDto createMember(String userName, String email, String password);

    List<MemberResponseDto> findAll();

    MemberResponseDto findById(Long id);

    MemberResponseDto update();
}
