package kea.bowlingBackend.project.repository;

import kea.bowlingBackend.project.model.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipmentRepository extends JpaRepository<Equipment, Long> {
}
