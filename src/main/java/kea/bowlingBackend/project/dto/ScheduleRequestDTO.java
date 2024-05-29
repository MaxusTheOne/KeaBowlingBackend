package kea.bowlingBackend.project.dto;


import kea.bowlingBackend.project.model.Schedule;
import kea.bowlingBackend.security.entity.UserWithRoles;
import lombok.Getter;


@Getter
public class ScheduleRequestDTO {
    private int id;

    private String username;
    private String start;
    private String end;

    public ScheduleRequestDTO() {
    }

    public ScheduleRequestDTO(int id, UserWithRoles user, String start, String end) {
        this.id = id;
        this.username = user.getUsername();
        this.start = start;
        this.end = end;
    }

    public Schedule toSchedule() {
        return new Schedule(id, username, start, end);
    }
}