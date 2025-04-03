package org.example.schedulerprojectv2.dto.user;

import lombok.Getter;
import org.example.schedulerprojectv2.entity.Member;

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

    public static MemberResponseDto toDto(Member member) {
        return new MemberResponseDto(member.getId(), member.getUserName(), member.getEmail());
    }
}
