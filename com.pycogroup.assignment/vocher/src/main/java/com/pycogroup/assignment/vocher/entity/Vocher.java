package com.pycogroup.assignment.vocher.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "vocher")
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Vocher implements Serializable {

    @EmbeddedId
    private VocherPk vocherPk;

    @Column(name = "vocher")
    private String vocher;

    @Column(name = "action_date")
    private Timestamp actionDate;

    @Column(name = "status")
    private String status;

}
