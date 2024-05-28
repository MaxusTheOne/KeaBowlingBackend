package kea.bowlingBackend.project.dto;


import kea.bowlingBackend.project.model.Schedule;
import kea.bowlingBackend.security.entity.UserWithRoles;
import lombok.Getter;


@Getter
public class ScheduleResponseDTO {

    private int id;
    private String username;
    private String start;
    private String end;

    public ScheduleResponseDTO() {
    }

    public ScheduleResponseDTO(int id, UserWithRoles user, String start, String end) {
        this.id = id;
        this.username = user.getUsername();
        this.start = start;
        this.end = end;
    }

    public ScheduleResponseDTO(Schedule schedule) {
        this.id = schedule.getId();
        this.username = schedule.getUser().getUsername();
        this.start = schedule.getStart();
        this.end = schedule.getEnd();
    }

}