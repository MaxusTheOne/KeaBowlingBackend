package kea.bowlingBackend.project.configuration;

import kea.bowlingBackend.project.repository.ReservationRepository;
import kea.bowlingBackend.security.repository.RoleRepository;
import kea.bowlingBackend.security.repository.UserWithRolesRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class SetupTestData implements ApplicationRunner {

    UserWithRolesRepository userWithRolesRepository;
    RoleRepository roleRepository;
    PasswordEncoder pwEncoder;

    ReservationRepository reservationRepository;

    private SetupTestUsers SetupTestUsers;


    private SetupTestReservations SetupTestReservations;

    public SetupTestData(UserWithRolesRepository userWithRolesRepository, RoleRepository roleRepository, PasswordEncoder pwEncoder, ReservationRepository reservationRepository) {
        this.userWithRolesRepository = userWithRolesRepository;
        this.roleRepository = roleRepository;
        this.pwEncoder = pwEncoder;
        this.reservationRepository = reservationRepository;
    }



    public void run(ApplicationArguments args) {

        SetupTestUsers = new SetupTestUsers(userWithRolesRepository, roleRepository, pwEncoder);;
        SetupTestUsers.createTestUsers();

        SetupTestReservations = new SetupTestReservations(reservationRepository, userWithRolesRepository);
        SetupTestReservations.createTestReservations();


    }
}
