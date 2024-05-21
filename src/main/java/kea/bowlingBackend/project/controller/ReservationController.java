package kea.bowlingBackend.project.controller;

import kea.bowlingBackend.project.dto.ReservationRequestDTO;
import kea.bowlingBackend.project.dto.ReservationResponseDTO;
import kea.bowlingBackend.project.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public ReservationResponseDTO getReservationById(@PathVariable String id) {
        return reservationService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteReservation(@PathVariable String id) {
        reservationService.deleteReservation(id);
    }

    @PostMapping("")
    public void addReservation(@RequestBody ReservationRequestDTO reservationRequestDTO) {
        reservationService.addReservation(reservationRequestDTO);
    }
}
