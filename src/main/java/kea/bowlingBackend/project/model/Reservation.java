package kea.bowlingBackend.project.model;

import jakarta.persistence.*;
import kea.bowlingBackend.security.entity.UserWithRoles;
import kea.bowlingBackend.security.repository.UserWithRolesRepository;
import lombok.Getter;
import lombok.Setter;
import org.apache.catalina.User;

import java.util.Date;
import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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

    private LocalDateTime reservationDateTime;
    private int reservationLengthMinutes;
    private int peopleAmount;
    private String bookingType;
    private boolean childFriendly;

    @OneToMany(mappedBy = "reservation", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Equipment> equipment;


    public Reservation() {
    }




    public Reservation(int userId, int reservationLengthMinutes, int peopleAmount, String bookingType, boolean childFriendly, List<String> equipment) {
        this.user = new UserWithRoles();
        this.user.setUserId((long) userId);
        this.reservationLengthMinutes = reservationLengthMinutes;
        this.peopleAmount = peopleAmount;
        this.bookingType = bookingType;
        this.childFriendly = childFriendly;
        this.equipment = equipment.stream().map(Equipment::new).toList();

    }
    public Reservation(UserWithRoles user,String reservationDateTime, int reservationLengthMinutes, int peopleAmount, String bookingType, boolean childFriendly, List<String> equipment) {
        String reservationDateTimeString = "2021-12-12 12:12:12";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        this.user = user;
        this.reservationDateTime = LocalDateTime.parse(reservationDateTime, formatter);
        this.reservationLengthMinutes = reservationLengthMinutes;
        this.peopleAmount = peopleAmount;
        this.bookingType = bookingType;
        this.childFriendly = childFriendly;
        if (equipment != null){
            this.equipment = equipment.stream().map(Equipment::new).toList();
        } else {
            this.equipment = null;
        }
    }


    public Reservation(String id, int userId, String reservationDateTime, int reservationLengthMinutes, int peopleAmount, String bookingType, boolean childFriendly, List<String> equipment, UserWithRolesRepository userWithRolesRepository) {
        String dateTimeString = "2024-06-05T15:14:00.000";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS");
        this.id = Integer.parseInt(id);
        this.user = userWithRolesRepository.findById(Integer.toString(userId)).orElseThrow(() -> new IllegalArgumentException("User with id " + userId + " not found"));
        this.reservationDateTime = LocalDateTime.parse(dateTimeString, formatter);
        this.reservationLengthMinutes = reservationLengthMinutes;
        this.peopleAmount = peopleAmount;
        this.bookingType = bookingType;
        this.childFriendly = childFriendly;
        if (equipment != null){
            this.equipment = equipment.stream().map(Equipment::new).toList();
        } else {
            this.equipment = null;
        }
    }
}