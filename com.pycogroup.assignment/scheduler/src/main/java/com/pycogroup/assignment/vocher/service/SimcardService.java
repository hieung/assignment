package com.pycogroup.assignment.vocher.service;

import com.pycogroup.assignment.vocher.entity.Simcard;

public interface SimcardService {

    Simcard findBySimcard(String simcard);

    void create(String simcard);
}
