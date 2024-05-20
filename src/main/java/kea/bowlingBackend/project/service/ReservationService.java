package kea.bowlingBackend.project.service;

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
}
