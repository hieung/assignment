package com.pycogroup.assignment.vocher.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "simcard")
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Simcard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "simcard", unique = true)
    private String simcard;

}
