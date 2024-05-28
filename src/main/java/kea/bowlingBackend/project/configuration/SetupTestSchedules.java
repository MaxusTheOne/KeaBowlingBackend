package kea.bowlingBackend.project.configuration;

import kea.bowlingBackend.project.model.Schedule;
import kea.bowlingBackend.project.repository.ScheduleRepository;
import kea.bowlingBackend.project.service.ScheduleService;
import lombok.NoArgsConstructor;
import org.springframework.boot.ApplicationArguments;


@NoArgsConstructor
public class SetupTestSchedules {
    ScheduleRepository scheduleRepository;

    public SetupTestSchedules(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    public void createTestSchedules() {
        //Create test schedules
        Schedule schedule1 = new Schedule(1, "user1", "2021-05-01 10:00:00", "2021-05-01 12:00:00");
        Schedule schedule2 = new Schedule(2, "user2", "2021-05-01 12:00:00", "2021-05-01 14:00:00");
        Schedule schedule3 = new Schedule(3, "user3", "2021-05-01 14:00:00", "2021-05-01 16:00:00");
        Schedule schedule4 = new Schedule(4, "user1", "2021-05-01 16:00:00", "2021-05-01 18:00:00");
        Schedule schedule5 = new Schedule(5, "user1", "2021-05-01 18:00:00", "2021-05-01 20:00:00");

        scheduleRepository.save(schedule1);
        scheduleRepository.save(schedule2);
        scheduleRepository.save(schedule3);
        scheduleRepository.save(schedule4);
        scheduleRepository.save(schedule5);
    }

}
