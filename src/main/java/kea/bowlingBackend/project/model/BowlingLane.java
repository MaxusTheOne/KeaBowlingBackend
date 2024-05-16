package kea.bowlingBackend.project.model;

import jakarta.persistence.*;

@Entity
public class BowlingLane {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private boolean isChildFriendly;

    @ManyToOne
    private Reservation reservation;

    public BowlingLane() {
    }
    public int getId() {
        return id;
    }

    public boolean isChildFriendly() {
        return isChildFriendly;
    }

    public void setChildFriendly(boolean childFriendly) {
        isChildFriendly = childFriendly;
    }
}