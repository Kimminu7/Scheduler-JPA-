package org.example.schedulerprojectv2.controller;

import lombok.RequiredArgsConstructor;
import org.example.schedulerprojectv2.dto.user.CreateMemberRequestDto;
import org.example.schedulerprojectv2.dto.user.MemberResponseDto;
import org.example.schedulerprojectv2.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    public ResponseEntity<MemberResponseDto> createMember(@RequestBody CreateMemberRequestDto requestDto) {

        MemberResponseDto responseDto = memberService.createMember(requestDto.getUserName(), requestDto.getEmail(), requestDto.getPassword());

        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

}
