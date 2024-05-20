package kea.bowlingBackend.project.model;

import jakarta.persistence.*;
import kea.bowlingBackend.security.entity.UserWithRoles;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ScheduleTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne()
    private UserWithRoles staff;
    private String date;
    private String startTime;
    private String hours;

    public ScheduleTime() {
    }

}