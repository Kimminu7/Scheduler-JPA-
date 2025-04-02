package org.example.schedulerprojectv2.service;

import org.example.schedulerprojectv2.dto.user.MemberResponseDto;

public interface MemberService {

    MemberResponseDto createMember(String userName, String email, String password);
}
