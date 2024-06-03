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

        UserWithRoles user1 = userWithRolesRepository.findByUsername("ManagerMogens").get();
        UserWithRoles user2 = userWithRolesRepository.findByUsername("MariaMartinez").get();
        UserWithRoles user3 = userWithRolesRepository.findByUsername("AvaKing").get();

        //    public Reservation(int userId, int reservationLengthMinutes, int peopleAmount, String bookingType, boolean childFriendly, List<String> equipment)
        Reservation reservation1 = new Reservation(user1, "2021-05-01 12:00:00", 60, 4, "dinner", true, null);
        Reservation reservation2 = new Reservation(user2, "2021-05-10 12:00:00", 120, 6, "dinner", false, null);
        Reservation reservation3 = new Reservation(user3, "2021-05-12 12:00:00", 90, 5, "dinner", true, null);
        Reservation reservation4 = new Reservation(user1, "2021-06-01 12:00:00", 60, 4, "bowling", true, null);
        Reservation reservation5 = new Reservation(user2, "2021-07-09 12:00:00", 120, 6, "bowling", false, null);
        Reservation reservation6 = new Reservation(user3, "2021-08-03 12:00:00", 90, 5, "bowling", true, null);
        Reservation reservation7 = new Reservation(user1, "2021-09-13 12:00:00", 60, 4, "dinner airhockey", true, null);
        Reservation reservation8 = new Reservation(user2, "2021-01-04 12:00:00", 120, 6, "dinner airhockey", false, null);
        Reservation reservation9 = new Reservation(user3, "2021-05-06 12:00:00", 90, 5, "dinner airhockey", true, null);

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
