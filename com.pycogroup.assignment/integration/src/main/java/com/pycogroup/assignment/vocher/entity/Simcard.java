package com.pycogroup.assignment.vocher.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "simcard")
public class Simcard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "simcard", unique = true)
    private String simcard;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSimcard() {
        return simcard;
    }

    public void setSimcard(String simcard) {
        this.simcard = simcard;
    }

    @Override
    public String toString() {
        return "Simcard{" +
                "id=" + id +
                ", simcard='" + simcard + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Simcard)) return false;
        Simcard simcard1 = (Simcard) o;
        return id == simcard1.id &&
                Objects.equals(simcard, simcard1.simcard);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, simcard);
    }
}
