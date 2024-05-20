package kea.bowlingBackend.project.controller;

import kea.bowlingBackend.project.dto.ReservationResponseDTO;
import kea.bowlingBackend.project.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {


    private final ReservationService reservationService;


    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }


    @GetMapping("")
    public List<ReservationResponseDTO> getAllReservations() {
        return reservationService.getAllReservations();
    }
}
