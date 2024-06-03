package kea.bowlingBackend.project.service;

import kea.bowlingBackend.project.dto.ReservationRequestDTO;
import kea.bowlingBackend.project.dto.ReservationResponseDTO;
import kea.bowlingBackend.project.repository.ReservationRepository;
import kea.bowlingBackend.security.repository.UserWithRolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final UserWithRolesRepository userWithRolesRepository;

    public ReservationService(ReservationRepository reservationRepository, UserWithRolesRepository userWithRolesRepository) {
        this.reservationRepository = reservationRepository;
        this.userWithRolesRepository = userWithRolesRepository;
    }


    public List<ReservationResponseDTO> getAllReservations() {
        return reservationRepository.findAll().stream()
                .map(ReservationResponseDTO::new)
                .collect(Collectors.toList());
    }

    public ReservationResponseDTO getById(String id) {
        return reservationRepository.findById(id)
                .map(ReservationResponseDTO::new)
                .orElseThrow(() -> new IllegalArgumentException("Reservation with id " + id + " not found"));
    }


    public void deleteReservation(String id) {
        reservationRepository.deleteById(id);
    }

    public void addReservation(ReservationRequestDTO reservationRequestDTO) {
        reservationRepository.save(reservationRequestDTO.toReservation(userWithRolesRepository));
    }

    public List<ReservationResponseDTO> getReservationsByUserId(int userId) {
        return reservationRepository.findByUser(userWithRolesRepository.findById(Integer.toString(userId))).stream().map(ReservationResponseDTO::new).collect(Collectors.toList());
    }

    public void updateReservation(ReservationRequestDTO reservationRequestDTO) {
        Optional<ReservationResponseDTO> reservation = reservationRepository.findById((reservationRequestDTO.getId())).map(ReservationResponseDTO::new);
        if (reservation.isEmpty()) {
            throw new IllegalArgumentException("Reservation with id " + reservationRequestDTO.getId() + " not found");
        }
        reservationRepository.save(reservationRequestDTO.toReservation(userWithRolesRepository));
    }
}
