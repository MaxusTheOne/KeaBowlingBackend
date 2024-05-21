package kea.bowlingBackend.project.repository;

import kea.bowlingBackend.project.model.Reservation;
import kea.bowlingBackend.security.entity.UserWithRoles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface ReservationRepository extends JpaRepository<Reservation, String> {

    List<Reservation> findByUser(Optional<UserWithRoles> user);
}
