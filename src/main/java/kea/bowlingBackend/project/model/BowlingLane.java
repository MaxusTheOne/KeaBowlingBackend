package kea.bowlingBackend.project.model;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
public class BowlingLane {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private boolean isChildFriendly;

    @ManyToOne
    private Reservation reservation;

    public BowlingLane() {
    }

    public boolean isChildFriendly() {
        return isChildFriendly;
    }

    public void setChildFriendly(boolean childFriendly) {
        isChildFriendly = childFriendly;
    }
}