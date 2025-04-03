package org.example.schedulerprojectv2.controller;

import lombok.RequiredArgsConstructor;
import org.example.schedulerprojectv2.dto.member.*;
import org.example.schedulerprojectv2.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    // 유저 생성
    @PostMapping
    public ResponseEntity<MemberResponseDto> createMember(@RequestBody CreateMemberRequestDto requestDto) {

        MemberResponseDto responseDto = memberService.createMember(requestDto.getUserName(), requestDto.getEmail(), requestDto.getPassword());

        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    // 유저 전체 조회
    @GetMapping
    public ResponseEntity<List<MemberResponseDto>> findAll() {

        List<MemberResponseDto> responseDtoList = memberService.findAll();

        return new ResponseEntity<>(responseDtoList,HttpStatus.OK);
    }

    // 유저 단건 조회
    @GetMapping("/{id}")
    public ResponseEntity<MemberResponseDto> findById(@PathVariable Long id) {

        MemberResponseDto responseDto = memberService.findById(id);

        return new ResponseEntity<>(responseDto,HttpStatus.OK);
    }

    // 유저 정보 전체 수정
    @PutMapping("/{id}")
    public ResponseEntity<String> updateMember(
            @PathVariable Long id,
            @RequestBody UpdateMemberRequestDto requestDto
            ) {

        String updateInfo = memberService.update(id, requestDto.getUserName(), requestDto.getEmail(), requestDto.getPassword());

        return new ResponseEntity<>(updateInfo,HttpStatus.OK);
    }

    // 유저 비밀번호 수정
    @PatchMapping("/{id}")
    public ResponseEntity<String> updatePassword(
            @PathVariable Long id,
            @RequestBody UpdateMemberPasswordRequestDto requestDto
    ) {

        String updatePassword = memberService.updatePassword(id, requestDto.getPassword());

        return new ResponseEntity<>(updatePassword,HttpStatus.OK);
    }

    // 유저 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMember(@PathVariable Long id) {

        String deleteResponse = memberService.delete(id);

        return new ResponseEntity<>(deleteResponse,HttpStatus.OK);
    }
}
