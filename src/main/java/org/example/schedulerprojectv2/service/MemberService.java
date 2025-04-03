package org.example.schedulerprojectv2.service;

import jakarta.servlet.http.HttpSession;
import org.example.schedulerprojectv2.dto.member.LoginRequestDto;
import org.example.schedulerprojectv2.dto.member.MemberResponseDto;

import java.util.List;

public interface MemberService {

    MemberResponseDto createMember(String userName, String email, String password);

    List<MemberResponseDto> findAll();

    MemberResponseDto findById(Long id);

    String update(Long id, String userName, String email, String password);

    String updatePassword(Long id, String password);

    String delete(Long id);

    void login(LoginRequestDto requestDto, HttpSession httpSession);
}
