package org.example.schedulerprojectv2.dto.user;

import lombok.Getter;

@Getter
public class MemberResponseDto {

    private final Long id;

    private final String userName;

    private final String email;

    public MemberResponseDto(Long id, String userName, String email) {
        this.id = id;
        this.userName = userName;
        this.email = email;
    }
}
