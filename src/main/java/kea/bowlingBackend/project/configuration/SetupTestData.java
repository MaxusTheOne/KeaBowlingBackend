package kea.bowlingBackend.project.configuration;

import kea.bowlingBackend.project.repository.ProductRepository;
import kea.bowlingBackend.project.repository.ReservationRepository;
import kea.bowlingBackend.project.repository.ScheduleRepository;
import kea.bowlingBackend.security.repository.RoleRepository;
import kea.bowlingBackend.security.repository.UserWithRolesRepository;
import kea.bowlingBackend.security.service.UserWithRolesService;
import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class SetupTestData implements ApplicationRunner {

    UserWithRolesRepository userWithRolesRepository;
    UserWithRolesService userWithRolesService;
    RoleRepository roleRepository;

    PasswordEncoder pwEncoder;
    ReservationRepository reservationRepository;
    ScheduleRepository scheduleRepository;

    SetupTestUsers SetupTestUsers;
    SetupTestProducts SetupTestProducts;
    ProductRepository productRepository;
    SetupTestSchedules SetupTestSchedules;
    SetupTestReservations SetupTestReservations;

    public SetupTestData(UserWithRolesRepository userWithRolesRepository, UserWithRolesService userWithRolesService, RoleRepository roleRepository, PasswordEncoder pwEncoder, ReservationRepository reservationRepository, ScheduleRepository scheduleRepository, SetupTestProducts SetupTestProducts, ProductRepository productRepository) {
        this.userWithRolesRepository = userWithRolesRepository;
        this.userWithRolesService = userWithRolesService;
        this.roleRepository = roleRepository;
        this.pwEncoder = pwEncoder;
        this.reservationRepository = reservationRepository;
        this.scheduleRepository = scheduleRepository;

        this.productRepository = productRepository;
        this.SetupTestProducts = SetupTestProducts;
    }


    public void run(ApplicationArguments args) {
        SetupTestProducts = new SetupTestProducts(productRepository);
        SetupTestProducts.createTestProducts();
        SetupTestUsers = new SetupTestUsers(userWithRolesRepository, roleRepository, pwEncoder);;
        SetupTestUsers.createTestUsers();
        SetupTestReservations = new SetupTestReservations(reservationRepository, userWithRolesRepository);
        SetupTestReservations.createTestReservations();
        SetupTestSchedules = new SetupTestSchedules(scheduleRepository, userWithRolesService);
        SetupTestSchedules.createTestSchedules();
    }
}
