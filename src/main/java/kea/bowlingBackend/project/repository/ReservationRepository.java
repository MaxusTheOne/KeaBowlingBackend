package kea.bowlingBackend.project.repository;

import kea.bowlingBackend.project.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, String> {
}
