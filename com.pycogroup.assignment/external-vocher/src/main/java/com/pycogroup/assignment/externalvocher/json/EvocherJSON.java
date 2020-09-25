package com.pycogroup.assignment.externalvocher.json;

import java.sql.Timestamp;

public class EvocherJSON {

    String evocher;
    String simcard;
    Timestamp actionDate;

    public EvocherJSON(String evocher, String simcard, Timestamp actionDate) {
        this.evocher = evocher;
        this.simcard = simcard;
        this.actionDate = actionDate;
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

    public Timestamp getActionDate() {
        return actionDate;
    }

    public void setActionDate(Timestamp actionDate) {
        this.actionDate = actionDate;
    }
}
