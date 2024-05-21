package kea.bowlingBackend.project.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double price;
    private int stock;
    private String image;

    public Product(String name, double price, int stock, String image) {
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.image = image;
    }

    public Product() {
    }

}

