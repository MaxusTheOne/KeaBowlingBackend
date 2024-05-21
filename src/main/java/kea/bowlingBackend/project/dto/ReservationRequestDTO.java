package kea.bowlingBackend.project.dto;


import kea.bowlingBackend.project.model.Reservation;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReservationRequestDTO {
    private String id;
    private int userId;
    private int reservationLengthMinutes;
    private int peopleAmount;
    private String bookingType;
    private boolean childFriendly;

    private List<String> equipment;

    public ReservationRequestDTO() {
    }

    public ReservationRequestDTO(int userId,  int reservationLengthMinutes, int peopleAmount, String bookingType, boolean childFriendly, List<String> equipment) {
        this.userId = userId;
        this.reservationLengthMinutes = reservationLengthMinutes;
        this.peopleAmount = peopleAmount;
        this.bookingType = bookingType;
        this.childFriendly = childFriendly;
        this.equipment = equipment;
    }

    public Reservation toReservation() {
        return new Reservation(userId, reservationLengthMinutes, peopleAmount, bookingType, childFriendly, equipment);
    }
}
