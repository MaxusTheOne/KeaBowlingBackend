package kea.bowlingBackend.project.controller;

import kea.bowlingBackend.project.dto.ScheduleResponseDTO;
import kea.bowlingBackend.project.model.Schedule;
import kea.bowlingBackend.project.service.ScheduleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {

    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @GetMapping("")
    public ResponseEntity<List<ScheduleResponseDTO>> getSchedules() {
        return ResponseEntity.ok(scheduleService.getSchedules().stream().map(scheduleService::toResponseDTO).toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScheduleResponseDTO> getScheduleById(@PathVariable int id) {
        return ResponseEntity.ok(new ScheduleResponseDTO(scheduleService.getScheduleById(id)));
    }

    @PostMapping("")
    public ResponseEntity<ScheduleResponseDTO> createSchedule(@RequestBody Schedule schedule) {
        return ResponseEntity.ok(new ScheduleResponseDTO(scheduleService.createSchedule(schedule)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable int id) {
        scheduleService.deleteSchedule(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ScheduleResponseDTO> updateSchedule(@PathVariable int id, @RequestBody Schedule schedule) {
        return ResponseEntity.ok(new ScheduleResponseDTO(scheduleService.updateSchedule(id, schedule)));
    }
}
