package org.example.schedulerprojectv2.dto.schedule;

import lombok.Getter;

@Getter
public class ScheduleResponseDto {

    private final Long id;

    private final String title;

    private final String userName;

    private final String contents;

    public ScheduleResponseDto(Long id, String title, String userName, String contents) {
        this.id = id;
        this.title = title;
        this.userName = userName;
        this.contents = contents;
    }
}
