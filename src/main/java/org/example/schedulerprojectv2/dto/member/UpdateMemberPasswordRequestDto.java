package org.example.schedulerprojectv2.dto.member;

import lombok.Getter;

@Getter
public class UpdateMemberPasswordRequestDto {

    private final String password;

    public UpdateMemberPasswordRequestDto(String password) {
        this.password = password;
    }
}
