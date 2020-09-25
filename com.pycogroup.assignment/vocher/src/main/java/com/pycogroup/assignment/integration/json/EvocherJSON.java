package com.pycogroup.assignment.integration.json;

import java.io.Serializable;
import java.sql.Timestamp;

public class EvocherJSON implements Serializable {

    String evocher;
    String simcard;
    Timestamp dateCreated;
    Timestamp actionDate;
    String status;

    public EvocherJSON() {
    }

    public EvocherJSON(String evocher, String simcard, Timestamp dateCreated, Timestamp actionDate, String status) {
        this.evocher = evocher;
        this.simcard = simcard;
        this.dateCreated = dateCreated;
        this.actionDate = actionDate;
        this.status = status;
    }

    public String getEvocher() {
        return evocher;
    }

    public void setEvocher(String evocher) {
        this.evocher = evocher;
    }

    public String getSimcard() {
        return simcard;
    }

    public void setSimcard(String simcard) {
        this.simcard = simcard;
    }

    public Timestamp getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Timestamp dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Timestamp getActionDate() {
        return actionDate;
    }

    public void setActionDate(Timestamp actionDate) {
        this.actionDate = actionDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "EvocherJSON{" +
                "evocher='" + evocher + '\'' +
                ", simcard='" + simcard + '\'' +
                ", dateCreated=" + dateCreated +
                ", actionDate=" + actionDate +
                ", status='" + status + '\'' +
                '}';
    }
}
