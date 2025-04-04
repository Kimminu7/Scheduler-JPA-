package org.example.schedulerprojectv2.dto.schedule;

import jakarta.validation.constraints.Min;
import lombok.Getter;

@Getter
public class CreateScheduleRequetsDto {

    @Min(5)
    private final String title;

    @Min(4)
    private final String userName;

    private final String contents;

    public CreateScheduleRequetsDto(String title, String userName, String contents) {
        this.title = title;
        this.userName = userName;
        this.contents = contents;
    }
}
