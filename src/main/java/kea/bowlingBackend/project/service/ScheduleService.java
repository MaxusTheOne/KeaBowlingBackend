package kea.bowlingBackend.project.service;

import kea.bowlingBackend.project.dto.ScheduleResponseDTO;
import kea.bowlingBackend.project.model.Schedule;
import kea.bowlingBackend.project.repository.ScheduleRepository;
import kea.bowlingBackend.security.service.UserWithRolesService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final UserWithRolesService userWithRolesService;

    public ScheduleService(ScheduleRepository scheduleRepository, UserWithRolesService userWithRolesService) {
        this.scheduleRepository = scheduleRepository;
        this.userWithRolesService = userWithRolesService;
    }

    public List<Schedule> getSchedules() {
        return scheduleRepository.findAll();
    }

    public Optional<Schedule> getScheduleById(int id) {
        return scheduleRepository.findById(id);
    }

   public void createSchedule(Schedule newSchedule) {
        scheduleRepository.save(newSchedule);
        }
    public void deleteSchedule(int id) {
        scheduleRepository.deleteById(id);
    }

    public void updateSchedule(int id, Schedule schedule) {
        if (scheduleRepository.findById(id).isEmpty()) {
            throw new IllegalArgumentException("Schedule with id " + id + " not found");
        }
        schedule.setId(id);
        scheduleRepository.save(schedule);
    }

    public ScheduleResponseDTO toResponseDTO(Schedule schedule) {
        return new ScheduleResponseDTO(schedule.getId(), schedule.getUser(), schedule.getStart(), schedule.getEnd());
    }
}
