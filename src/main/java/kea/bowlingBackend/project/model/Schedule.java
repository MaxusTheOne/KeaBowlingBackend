package kea.bowlingBackend.project.model;

import jakarta.persistence.*;
import kea.bowlingBackend.security.entity.UserWithRoles;
import kea.bowlingBackend.security.service.UserWithRolesService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "schedule")
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private UserWithRoles user;
    private String start;
    private String end;

    public Schedule(UserWithRolesService userWithRolesService, String user, String start, String end) {
        this.user = userWithRolesService.getUser(user);
        this.start = start;
        this.end = end;
    }



}
