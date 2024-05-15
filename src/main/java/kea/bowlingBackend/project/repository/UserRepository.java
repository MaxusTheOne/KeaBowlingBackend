package kea.bowlingBackend.project.repository;

import kea.bowlingBackend.project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
