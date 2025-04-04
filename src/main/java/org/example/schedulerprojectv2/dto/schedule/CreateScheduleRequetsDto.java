package org.example.schedulerprojectv2.dto.schedule;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class CreateScheduleRequetsDto {


    @Size(min = 5, message = "제목은 최소 5글자 이상 이어야 합니다.")
    private final String title;

    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "영어 알파벳과 숫자만 입력할 수 있습니다.")
    @Size(min = 4, message = "유저명은 최소 4글자 이상이어야 합니다.")
    @NotBlank(message = "유저명은 필수 입력 값입니다.")
    private final String userName;

    private final String contents;

    public CreateScheduleRequetsDto(String title, String userName, String contents) {
        this.title = title;
        this.userName = userName;
        this.contents = contents;
    }
}
