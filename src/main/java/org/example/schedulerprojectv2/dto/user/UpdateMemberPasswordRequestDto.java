package org.example.schedulerprojectv2.dto.user;

import lombok.Getter;

@Getter
public class UpdateMemberPasswordRequestDto {

    private final String password;

    public UpdateMemberPasswordRequestDto(String password) {
        this.password = password;
    }
}
