package kea.bowlingBackend.project.controller;

import kea.bowlingBackend.project.dto.ScheduleRequestDTO;
import kea.bowlingBackend.project.dto.ScheduleResponseDTO;
import kea.bowlingBackend.project.model.Schedule;
import kea.bowlingBackend.project.service.ScheduleService;
import kea.bowlingBackend.security.entity.UserWithRoles;
import kea.bowlingBackend.security.service.UserWithRolesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {

    private final ScheduleService scheduleService;
    private final UserWithRolesService userWithRolesService;

    public ScheduleController(ScheduleService scheduleService, UserWithRolesService userWithRolesService) {
        this.scheduleService = scheduleService;
        this.userWithRolesService = userWithRolesService;
    }

    @GetMapping("")
    public ResponseEntity<List<ScheduleResponseDTO>> getSchedules() {
        return ResponseEntity.ok(scheduleService.getSchedules().stream().map(scheduleService::toResponseDTO).toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScheduleResponseDTO> getScheduleById(@PathVariable int id) {
        Optional<Schedule> optionalSchedule = scheduleService.getScheduleById(id);
        if (optionalSchedule.isPresent()) {
            return ResponseEntity.ok(new ScheduleResponseDTO(optionalSchedule.get()));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("")
    public ResponseEntity<ScheduleResponseDTO> createSchedule(@RequestBody ScheduleRequestDTO scheduleRequest) {
        Schedule schedule = new Schedule(userWithRolesService, scheduleRequest.getUsername(), scheduleRequest.getStart(), scheduleRequest.getEnd());
        scheduleService.createSchedule(schedule);
        return ResponseEntity.ok(new ScheduleResponseDTO(schedule));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable int id) {
        scheduleService.deleteSchedule(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ScheduleResponseDTO> updateSchedule(@PathVariable int id, @RequestBody ScheduleRequestDTO scheduleRequest) {
        Optional<Schedule> optionalSchedule = scheduleService.getScheduleById(id);
        if (optionalSchedule.isPresent()) {
            Schedule existingSchedule = optionalSchedule.get();
            existingSchedule.setUser(userWithRolesService.getUser(scheduleRequest.getUsername()));
            existingSchedule.setStart(scheduleRequest.getStart());
            existingSchedule.setEnd(scheduleRequest.getEnd());
            scheduleService.updateSchedule(id, existingSchedule);
            return ResponseEntity.ok(new ScheduleResponseDTO(existingSchedule));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
