package kea.bowlingBackend.project.model;

import jakarta.persistence.*;
import kea.bowlingBackend.security.entity.UserWithRoles;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne()
    private UserWithRoles user;
    private Date reservationDateTime;
    private int reservationLengthMinutes;
    private int peopleAmount;
    private String bookingType;
    private boolean childFriendly;

    @OneToMany(mappedBy = "reservation", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Equipment> equipment;


    public Reservation() {
    }


}