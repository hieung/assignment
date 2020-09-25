package com.pycogroup.assignment.vocher.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "history")
public class History implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "status")
    private String status;

    @Column(name = "simcard")
    private String simcard;

    @Column(name = "interaction_date")
    private Timestamp interactionDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSimcard() {
        return simcard;
    }

    public void setSimcard(String simcard) {
        this.simcard = simcard;
    }

    public Timestamp getInteractionDate() {
        return interactionDate;
    }

    public void setInteractionDate(Timestamp interactionDate) {
        this.interactionDate = interactionDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof History)) return false;
        History history = (History) o;
        return id == history.id &&
                Objects.equals(status, history.status) &&
                Objects.equals(simcard, history.simcard) &&
                Objects.equals(interactionDate, history.interactionDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, status, simcard, interactionDate);
    }

    @Override
    public String toString() {
        return "History{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", simcard='" + simcard + '\'' +
                ", interactionDate=" + interactionDate +
                '}';
    }
}
