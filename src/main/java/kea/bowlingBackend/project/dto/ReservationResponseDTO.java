package kea.bowlingBackend.project.dto;

import kea.bowlingBackend.project.model.Reservation;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReservationResponseDTO {
    private String id;
    private int userId;
    private String reservationDateTime;
    private int reservationLengthMinutes;
    private int peopleAmount;
    private String bookingType;
    private boolean childFriendly;

    public ReservationResponseDTO(Reservation reservation) {
        this.id = String.valueOf(reservation.getId());
        this.userId = Math.toIntExact(reservation.getUser().getUserId());
        this.reservationDateTime = reservation.getReservationDateTime().toString();
        this.reservationLengthMinutes = reservation.getReservationLengthMinutes();
        this.peopleAmount = reservation.getPeopleAmount();
        this.bookingType = reservation.getBookingType();
        this.childFriendly = reservation.isChildFriendly();

    }

}
