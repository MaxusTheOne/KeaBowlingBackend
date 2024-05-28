package kea.bowlingBackend.project.repository;

import kea.bowlingBackend.project.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, String> {
}
