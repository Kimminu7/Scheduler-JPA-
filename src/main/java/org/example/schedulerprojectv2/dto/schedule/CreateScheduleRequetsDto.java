package org.example.schedulerprojectv2.dto.schedule;

import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class CreateScheduleRequetsDto {


    @Size(min = 5, message = "제목은 최소 5글자 이상 이어야 합니다.")
    private final String title;

    private final String contents;

    public CreateScheduleRequetsDto(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }
}
