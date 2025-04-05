package org.example.schedulerprojectv2.controller;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
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
    @PostMapping("/signup")  // 사실상 회원가입이 여기서 진행됨 ( ★ )
    public ResponseEntity<MemberResponseDto> createMember(@Valid @RequestBody CreateMemberRequestDto requestDto) {

        MemberResponseDto responseDto = memberService.createMember(requestDto.getUserName(), requestDto.getEmail(), requestDto.getPassword());

        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    // 로그인
    @PostMapping("/login")
    public ResponseEntity<String> login(
            @Valid @RequestBody LoginRequestDto requestDto,
            HttpSession httpSession
    ) {
        try {
            memberService.login(requestDto, httpSession);
            return new ResponseEntity<>("로그인 성공",HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
        }
    }

    // 로그아웃  ( 이 경우는 연결된 세션을 끊으면 되니까? invalidate )
    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpSession httpSession) {

        try {
            memberService.logout(httpSession);
            return new ResponseEntity<>("로그아웃 성공!",HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.UNAUTHORIZED);
        }
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
            @Valid @RequestBody UpdateMemberRequestDto requestDto
            ) {

        String updateInfo = memberService.update(id, requestDto.getUserName(), requestDto.getEmail(), requestDto.getPassword());

        return new ResponseEntity<>(updateInfo,HttpStatus.OK);
    }

    // 유저 비밀번호 수정
    @PatchMapping("/{id}")
    public ResponseEntity<String> updatePassword(
            @PathVariable Long id,
            @Valid @RequestBody UpdateMemberPasswordRequestDto requestDto
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
