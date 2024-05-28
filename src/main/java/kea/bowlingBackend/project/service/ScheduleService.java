package kea.bowlingBackend.project.service;

import kea.bowlingBackend.project.model.Schedule;
import kea.bowlingBackend.project.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    public List<Schedule> getSchedules() {
        return scheduleRepository.findAll();
    }

    public Schedule getScheduleById(int id) {
        return scheduleRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Schedule with id " + id + " not found"));
    }

    public Schedule createSchedule(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    public void deleteSchedule(int id) {
        scheduleRepository.deleteById(id);
    }

    public Schedule updateSchedule(int id, Schedule schedule) {
        if (scheduleRepository.findById(id).isEmpty()) {
            throw new IllegalArgumentException("Schedule with id " + id + " not found");
        }
        schedule.setId(id);
        return scheduleRepository.save(schedule);
    }
}
