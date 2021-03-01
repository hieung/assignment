package com.pycogroup.assignment.vocher.repository;

import com.pycogroup.assignment.vocher.entity.Simcard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SimcardRepository extends JpaRepository<Simcard, String> {

    Simcard findBySimcard(String simcard);

}
