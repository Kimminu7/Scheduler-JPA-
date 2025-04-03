package org.example.schedulerprojectv2.dto.user;

import lombok.Getter;

@Getter
public class MemberPasswordReponseDto {

    private final String password;

    public MemberPasswordReponseDto(String password) {
        this.password = password;
    }
}
