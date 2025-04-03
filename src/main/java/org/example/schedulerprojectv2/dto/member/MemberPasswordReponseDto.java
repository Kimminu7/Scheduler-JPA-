package org.example.schedulerprojectv2.dto.member;

import lombok.Getter;

@Getter
public class MemberPasswordReponseDto {

    private final String password;

    public MemberPasswordReponseDto(String password) {
        this.password = password;
    }
}
