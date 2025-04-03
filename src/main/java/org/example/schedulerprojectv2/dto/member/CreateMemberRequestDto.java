package org.example.schedulerprojectv2.dto.member;

import lombok.Getter;

@Getter
public class CreateMemberRequestDto {

    private final String userName;

    private final String email;

    private final String password;

    public CreateMemberRequestDto(String userName, String email, String password) {
        this.userName = userName;
        this.email = email;
        this.password = password;
    }
}
