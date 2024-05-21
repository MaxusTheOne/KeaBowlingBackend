package kea.bowlingBackend.project.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private String brand;
    private String type;
    private int stockAmount;

    @ManyToOne
    private  Reservation reservation;

    public Equipment(String name, String description, String brand, String type, int stockAmount) {
        this.name = name;
        this.description = description;
        this.brand = brand;
        this.type = type;
        this.stockAmount = stockAmount;
    }

    public Equipment() {
    }
}