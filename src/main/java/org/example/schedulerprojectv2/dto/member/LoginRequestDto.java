package org.example.schedulerprojectv2.dto.member;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class LoginRequestDto {

    @Email
    private final String email;

    @Size(min = 4, message = "비밀번호는 최소 4글자 이상이어야 합니다.")
    private final String password;

    public LoginRequestDto(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
