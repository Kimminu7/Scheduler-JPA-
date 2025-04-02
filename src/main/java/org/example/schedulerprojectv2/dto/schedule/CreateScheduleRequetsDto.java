package org.example.schedulerprojectv2.dto.schedule;

import lombok.Getter;

@Getter
public class CreateScheduleRequetsDto {

    private final String title;

    private final String userName;

    private final String contents;

    public CreateScheduleRequetsDto(String title, String userName, String contents) {
        this.title = title;
        this.userName = userName;
        this.contents = contents;
    }
}
