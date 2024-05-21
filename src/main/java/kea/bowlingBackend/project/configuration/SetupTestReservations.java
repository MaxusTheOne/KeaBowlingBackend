package kea.bowlingBackend.project.configuration;


import kea.bowlingBackend.project.model.Reservation;
import kea.bowlingBackend.project.repository.ReservationRepository;
import kea.bowlingBackend.security.entity.UserWithRoles;
import kea.bowlingBackend.security.repository.UserWithRolesRepository;
import org.springframework.stereotype.Component;

@Component
public class SetupTestReservations {

    ReservationRepository reservationRepository;
    UserWithRolesRepository userWithRolesRepository;


    public SetupTestReservations(ReservationRepository reservationRepository, UserWithRolesRepository userWithRolesRepository) {
        this.reservationRepository = reservationRepository;
        this.userWithRolesRepository = userWithRolesRepository;
    }

    public void createTestReservations() {

        UserWithRoles user1 = userWithRolesRepository.findByUsername("user1").get();
        UserWithRoles user2 = userWithRolesRepository.findByUsername("user2").get();
        UserWithRoles user3 = userWithRolesRepository.findByUsername("user3").get();

        //    public Reservation(int userId, int reservationLengthMinutes, int peopleAmount, String bookingType, boolean childFriendly, List<String> equipment)
        Reservation reservation1 = new Reservation(user1, 60, 4, "dinner", true, null);
        Reservation reservation2 = new Reservation(user2, 120, 6, "dinner", false, null);
        Reservation reservation3 = new Reservation(user3, 90, 5, "airhockey", true, null);
        Reservation reservation4 = new Reservation(user1, 60, 4, "airhockey", true, null);
        Reservation reservation5 = new Reservation(user2, 120, 6, "bowling", false, null);
        Reservation reservation6 = new Reservation(user3, 90, 5, "bowling", true, null);
        Reservation reservation7 = new Reservation(user1, 60, 4, "dinner bowling", true, null);
        Reservation reservation8 = new Reservation(user2, 120, 6, "dinner airhockey", false, null);
        Reservation reservation9 = new Reservation(user3, 90, 5, "bowling airhockey", true, null);

        reservationRepository.save(reservation1);
        reservationRepository.save(reservation2);
        reservationRepository.save(reservation3);
        reservationRepository.save(reservation4);
        reservationRepository.save(reservation5);
        reservationRepository.save(reservation6);
        reservationRepository.save(reservation7);
        reservationRepository.save(reservation8);
        reservationRepository.save(reservation9);
    }
}
