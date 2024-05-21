package kea.bowlingBackend.project.service;

import kea.bowlingBackend.project.dto.ReservationRequestDTO;
import kea.bowlingBackend.project.dto.ReservationResponseDTO;
import kea.bowlingBackend.project.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
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
        reservationRepository.save(reservationRequestDTO.toReservation());
    }
}
