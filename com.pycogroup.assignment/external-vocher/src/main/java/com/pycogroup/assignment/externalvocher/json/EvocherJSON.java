package com.pycogroup.assignment.externalvocher.json;

import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EvocherJSON {
    String evocher;
    String simcard;
    Timestamp actionDate;

}
