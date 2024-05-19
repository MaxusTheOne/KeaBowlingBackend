package kea.bowlingBackend.project.model;

import jakarta.persistence.*;
import kea.bowlingBackend.security.entity.Role;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.jdbc.Work;

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
    private String username;

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
    @ElementCollection
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    private List<String> roles;

    public User(String name, String username, String password,String email,List<String> roles){
        this.name = name;
        this.password = password;
        this.email = email;
        this.roles = roles ;
        this.username = username;
    }
    public User() {
        roles = new ArrayList<>();
    }

    public void addRole(String role){
        this.roles.add(role);
    }

    public String[] getRoles(){
        String[] roles = new String[this.roles.size()];
        for (int i = 0; i < this.roles.size(); i++) {
            roles[i] = this.roles.get(i);
        }
        return roles;
    }


}