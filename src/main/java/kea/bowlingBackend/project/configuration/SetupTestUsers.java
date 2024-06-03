package kea.bowlingBackend.project.configuration;

import kea.bowlingBackend.project.model.Product;
import kea.bowlingBackend.security.entity.Role;
import kea.bowlingBackend.security.entity.UserWithRoles;
import kea.bowlingBackend.security.repository.RoleRepository;
import kea.bowlingBackend.security.repository.UserWithRolesRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

@Component
public class SetupTestUsers {
    UserWithRolesRepository userWithRolesRepository;
    RoleRepository roleRepository;

    PasswordEncoder pwEncoder;

    String passwordUsedByAll;

    public SetupTestUsers(UserWithRolesRepository userWithRolesRepository, RoleRepository roleRepository, PasswordEncoder pwEncoder) {
        this.userWithRolesRepository = userWithRolesRepository;
        this.roleRepository = roleRepository;
        this.pwEncoder = pwEncoder;
        this.passwordUsedByAll = "test12";
    }



    void createTestUsers() {
        roleRepository.save(new Role("USER"));
        roleRepository.save(new Role("STAFF"));
        roleRepository.save(new Role("ADMIN"));
        roleRepository.save(new Role("EQUIPMENT_OPERATOR"));
        roleRepository.save(new Role("RESERVATION_STAFF"));
        roleRepository.save(new Role("CLEANING_STAFF"));

        Role roleEquipmentOperator = roleRepository.findById("EQUIPMENT_OPERATOR").orElseThrow(()-> new NoSuchElementException("Role 'equipment_operator' not found"));
        Role roleCleaningStaff = roleRepository.findById("CLEANING_STAFF").orElseThrow(()-> new NoSuchElementException("Role 'cleaning_staff' not found"));
        Role roleUser = roleRepository.findById("USER").orElseThrow(()-> new NoSuchElementException("Role 'user' not found"));
        Role roleAdmin = roleRepository.findById("ADMIN").orElseThrow(()-> new NoSuchElementException("Role 'admin' not found"));
        Role roleStaff = roleRepository.findById("STAFF").orElseThrow(()-> new NoSuchElementException("Role 'staff' not found"));
        Role roleReservationStaff = roleRepository.findById("RESERVATION_STAFF").orElseThrow(()-> new NoSuchElementException("Role 'reservation_staff' not found"));

        List<UserWithRoles> userList = Arrays.asList(
                // Manager
                new UserWithRoles("ManagerMogens", "Mogens Maxprofit", pwEncoder.encode(passwordUsedByAll), "mogens.maxprofit@kea-bowling.dk", Set.of(roleUser, roleAdmin, roleStaff)),

                // Reservation Staff
                new UserWithRoles("RikkeReserve", "Rikke Reserve", pwEncoder.encode(passwordUsedByAll), "rikke.reserve@kea-bowling.dk", Set.of(roleUser, roleStaff, roleReservationStaff)),
                new UserWithRoles("RonnieRental", "Ronnie Rental", pwEncoder.encode(passwordUsedByAll), "ronnie.rental@kea-bowling.dk", Set.of(roleUser, roleStaff, roleReservationStaff)),

                // Equipment Operator
                new UserWithRoles("OperatorOlivia", "Olivia Operator", pwEncoder.encode(passwordUsedByAll), "olivia.operator@kea-bowling.dk", Set.of(roleUser, roleEquipmentOperator)),

                // Cleaning Staff
                new UserWithRoles("CleanerChris", "Chris Cleaner", pwEncoder.encode(passwordUsedByAll), "chris.cleaner@kea-bowling.dk", Set.of(roleUser, roleCleaningStaff)),
                new UserWithRoles("CleanerCasey", "Casey Cleaner", pwEncoder.encode(passwordUsedByAll), "casey.cleaner@kea-bowling.dk", Set.of(roleUser, roleCleaningStaff)),

                // Employees in different roles
                new UserWithRoles("JohnSmith", "John Smith", pwEncoder.encode(passwordUsedByAll), "john.smith@kea-bowling.dk", Set.of(roleUser, roleStaff)),
                new UserWithRoles("JaneDoe", "Jane Doe", pwEncoder.encode(passwordUsedByAll), "jane.doe@kea-bowling.dk", Set.of(roleUser, roleStaff)),
                new UserWithRoles("ChrisJohnson", "Chris Johnson", pwEncoder.encode(passwordUsedByAll), "chris.johnson@kea-bowling.dk", Set.of(roleUser, roleStaff)),
                new UserWithRoles("PatriciaBrown", "Patricia Brown", pwEncoder.encode(passwordUsedByAll), "patricia.brown@kea-bowling.dk", Set.of(roleUser, roleStaff)),
                new UserWithRoles("MichaelWilliams", "Michael Williams", pwEncoder.encode(passwordUsedByAll), "michael.williams@kea-bowling.dk", Set.of(roleUser, roleStaff)),
                new UserWithRoles("LindaJones", "Linda Jones", pwEncoder.encode(passwordUsedByAll), "linda.jones@kea-bowling.dk", Set.of(roleUser, roleStaff)),
                new UserWithRoles("RobertGarcia", "Robert Garcia", pwEncoder.encode(passwordUsedByAll), "robert.garcia@kea-bowling.dk", Set.of(roleUser, roleStaff)),
                new UserWithRoles("MariaMartinez", "Maria Martinez", pwEncoder.encode(passwordUsedByAll), "maria.martinez@kea-bowling.dk", Set.of(roleUser, roleStaff)),
                new UserWithRoles("DavidRodriguez", "David Rodriguez", pwEncoder.encode(passwordUsedByAll), "david.rodriguez@kea-bowling.dk", Set.of(roleUser, roleStaff)),
                new UserWithRoles("SarahWilson", "Sarah Wilson", pwEncoder.encode(passwordUsedByAll), "sarah.wilson@kea-bowling.dk", Set.of(roleUser, roleStaff)),
                new UserWithRoles("JamesLee", "James Lee", pwEncoder.encode(passwordUsedByAll), "james.lee@kea-bowling.dk", Set.of(roleUser, roleStaff)),
                new UserWithRoles("KarenHarris", "Karen Harris", pwEncoder.encode(passwordUsedByAll), "karen.harris@kea-bowling.dk", Set.of(roleUser, roleStaff)),
                new UserWithRoles("EmilyClark", "Emily Clark", pwEncoder.encode(passwordUsedByAll), "emily.clark@kea-bowling.dk", Set.of(roleUser, roleStaff)),
                new UserWithRoles("DanielLewis", "Daniel Lewis", pwEncoder.encode(passwordUsedByAll), "daniel.lewis@kea-bowling.dk", Set.of(roleUser, roleStaff)),
                new UserWithRoles("OliverHall", "Oliver Hall", pwEncoder.encode(passwordUsedByAll), "oliver.hall@kea-bowling.dk", Set.of(roleUser, roleStaff)),
                new UserWithRoles("SophiaYoung", "Sophia Young", pwEncoder.encode(passwordUsedByAll), "sophia.young@kea-bowling.dk", Set.of(roleUser, roleStaff)),
                new UserWithRoles("AvaKing", "Ava King", pwEncoder.encode(passwordUsedByAll), "ava.king@kea-bowling.dk", Set.of(roleUser, roleStaff)),
                new UserWithRoles("MasonScott", "Mason Scott", pwEncoder.encode(passwordUsedByAll), "mason.scott@kea-bowling.dk", Set.of(roleUser, roleStaff))
        );

        userWithRolesRepository.saveAll(userList);

    }

}