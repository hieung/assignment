package com.pycogroup.assignment.vocher.repository;

import com.pycogroup.assignment.vocher.entity.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryRepository extends JpaRepository<History, String> {

}
