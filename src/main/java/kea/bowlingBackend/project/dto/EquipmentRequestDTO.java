package kea.bowlingBackend.project.dto;

import kea.bowlingBackend.project.model.Equipment;
import lombok.Getter;

@Getter
public class EquipmentRequestDTO {
    private int id;
    private String name;
    private String description;
    private String brand;
    private String type;
    private int stockAmount;

    public EquipmentRequestDTO() {
    }

    public EquipmentRequestDTO(int id, String name, String description, String brand, String type, int stockAmount) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.brand = brand;
        this.type = type;
        this.stockAmount = stockAmount;
    }

    public Equipment toEquipment() {
        return new Equipment(id, name, description, brand, type, stockAmount);
    }
}
