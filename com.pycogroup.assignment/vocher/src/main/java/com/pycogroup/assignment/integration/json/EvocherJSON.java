package com.pycogroup.assignment.integration.json;

import lombok.*;

import java.io.Serializable;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EvocherJSON implements Serializable {

    String evocher;
    String simcard;
    Timestamp dateCreated;
    Timestamp actionDate;
    String status;

}
