package com.pycogroup.assignment.vocher.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "vocher")
public class Vocher implements Serializable {

    @EmbeddedId
    private VocherPk vocherPk;

    @Column(name = "vocher")
    private String vocher;

    @Column(name = "action_date")
    private Timestamp actionDate;

    @Column(name = "status")
    private String status;

    public Vocher() {
    }

    public VocherPk getVocherPk() {
        return vocherPk;
    }

    public void setVocherPk(VocherPk vocherPk) {
        this.vocherPk = vocherPk;
    }

    public String getVocher() {
        return vocher;
    }

    public void setVocher(String vocher) {
        this.vocher = vocher;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getActionDate() {
        return actionDate;
    }

    public void setActionDate(Timestamp actionDate) {
        this.actionDate = actionDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vocher)) return false;
        Vocher vocher1 = (Vocher) o;
        return Objects.equals(vocherPk, vocher1.vocherPk) &&
                Objects.equals(vocher, vocher1.vocher) &&
                Objects.equals(actionDate, vocher1.actionDate) &&
                Objects.equals(status, vocher1.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vocherPk, vocher, actionDate, status);
    }

    @Override
    public String toString() {
        return "Vocher{" +
                "vocherPk=" + vocherPk +
                ", vocher='" + vocher + '\'' +
                ", actionDate=" + actionDate +
                ", status='" + status + '\'' +
                '}';
    }
}
