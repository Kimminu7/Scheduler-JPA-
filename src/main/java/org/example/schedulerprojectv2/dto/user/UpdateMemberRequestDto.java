package org.example.schedulerprojectv2.dto.user;

import lombok.Getter;

@Getter
public class UpdateMemberRequestDto {

    private final String userName;

    private final String email;

    private final String password;

    public UpdateMemberRequestDto(String userName, String email, String password) {
        this.userName = userName;
        this.email = email;
        this.password = password;
    }
}
