package com.pycogroup.assignment.vocher.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.sql.Timestamp;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class VocherPk implements Serializable {

    @Column(name = "simcard")
    private String simcard;

    @Column(name = "create_date")
    private Timestamp createdDate;

}
