package com.pycogroup.assignment.vocher.entity;

import javax.persistence.*;

@Entity
@Table(name = "simcard")
public class Simcard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "simcard", unique = true)
    private String simcard;

//    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "simcard")
//    private List<Vocher> vocherList;

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

//    public List<Vocher> getVocherList() {
//        return vocherList;
//    }
//
//    public void setVocherList(List<Vocher> vocherList) {
//        this.vocherList = vocherList;
//    }

    @Override
    public String toString() {
        return "Simcard{" +
                "id=" + id +
                ", simcard='" + simcard + '\'' +
                '}';
    }
}
