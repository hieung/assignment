package com.pycogroup.assignment.vocher.repository;

import com.pycogroup.assignment.vocher.entity.Vocher;
import com.pycogroup.assignment.vocher.entity.VocherPk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VocherRepository extends JpaRepository<Vocher, VocherPk> {

    Optional<Vocher> findById(VocherPk vocherPk);

    List<Vocher> findByStatus(String fail);
}
