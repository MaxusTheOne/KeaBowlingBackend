package kea.bowlingBackend.security.repository;

import kea.bowlingBackend.security.entity.UserWithRoles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface
UserWithRolesRepository extends JpaRepository<UserWithRoles,String> {
    Boolean existsByEmail(String email);
    Boolean existsByUsername(String username);
    Optional<UserWithRoles> findByUsername(String currentUsername);

    Optional<UserWithRoles> findByRoles_RoleName(String roleName);
}
