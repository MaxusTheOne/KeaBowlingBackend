package kea.bowlingBackend.project.dto;


import kea.bowlingBackend.project.model.Reservation;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReservationRequestDTO {
    private String id;
    private int userId;
    private String reservationDateTime;
    private int reservationLengthMinutes;
    private int peopleAmount;
    private String bookingType;
    private boolean childFriendly;

    private List<String> equipment;

    public ReservationRequestDTO() {
    }

    public ReservationRequestDTO(String id, int userId, String reservationDateTime , int reservationLengthMinutes, int peopleAmount, String bookingType, boolean childFriendly, List<String> equipment) {
        this.id = id;
        this.userId = userId;
        this.reservationDateTime = reservationDateTime;
        this.reservationLengthMinutes = reservationLengthMinutes;
        this.peopleAmount = peopleAmount;
        this.bookingType = bookingType;
        this.childFriendly = childFriendly;
        this.equipment = Objects.requireNonNullElseGet(equipment, ArrayList::new);
    }

    public Reservation toReservation() {
        return new Reservation(id, userId,reservationDateTime, reservationLengthMinutes, peopleAmount, bookingType, childFriendly, equipment);
    }
}
