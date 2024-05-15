package kea.bowlingBackend.security.repository;

import kea.bowlingBackend.security.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, String> {

}
