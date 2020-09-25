package com.pycogroup.assignment.vocher.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

@Embeddable
public class VocherPk implements Serializable {

    @Column(name = "simcard")
    private String simcard;

    @Column(name = "create_date")
    private Timestamp createdDate;

    public VocherPk() {
    }

    public VocherPk(String simcard, Timestamp createdDate) {
        this.simcard = simcard;
        this.createdDate = createdDate;
    }

    public String getSimcard() {
        return simcard;
    }

    public void setSimcard(String simcard) {
        this.simcard = simcard;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "VocherPk{" +
                "simcard='" + simcard + '\'' +
                ", createdDate=" + createdDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VocherPk)) return false;
        VocherPk vocherPk = (VocherPk) o;
        return Objects.equals(simcard, vocherPk.simcard) &&
                Objects.equals(createdDate, vocherPk.createdDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(simcard, createdDate);
    }
}
