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
    private int stockAmount;

    @ManyToOne
    private  Reservation reservation;


    public Equipment() {
    }
}