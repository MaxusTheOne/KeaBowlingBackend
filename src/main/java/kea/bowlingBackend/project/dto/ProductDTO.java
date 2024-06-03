package kea.bowlingBackend.project.dto;

import kea.bowlingBackend.project.model.Purchase;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

public record ProductDTO(int id, String name, double price, int stock, String image) {

}
