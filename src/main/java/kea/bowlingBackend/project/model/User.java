package kea.bowlingBackend.project.model;

import jakarta.persistence.*;
import kea.bowlingBackend.security.entity.Role;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String password;

    @Getter
    @Setter
    private String email;

    @Getter
    @Setter
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Purchase> purchase;

    @Getter
    @Setter
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Reservation> reservations;

    @Getter
    @Setter
    @OneToMany(mappedBy = "staff", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ScheduleTime> scheduledTimes;

    @Getter
    @Setter
    private Date dateCreated;

    @Getter
    @Setter
    private Date dateLastLogin;

    @Getter
    @Setter
    private Date dateEdited;


    @Setter
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Role> roles;

    public User(String name,String password,String email,List<Role> roles){
        this.name = name;
        this.password = password;
        this.email = email;
        this.roles = roles ;

    }
    public User() {
        roles = new ArrayList<>();
    }

    public void addRole(Role role){
        this.roles.add(role);
    }

    public String[] getRoles(){
        String[] roles = new String[this.roles.size()];
        for (int i = 0; i < this.roles.size(); i++) {
            roles[i] = this.roles.get(i).getRoleName();
        }
        return roles;
    }


}