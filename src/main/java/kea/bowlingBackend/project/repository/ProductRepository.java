package kea.bowlingBackend.project.repository;

import kea.bowlingBackend.project.model.Equipment;
import kea.bowlingBackend.project.model.Product;
import kea.bowlingBackend.security.entity.UserWithRoles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByName(String name);
}
