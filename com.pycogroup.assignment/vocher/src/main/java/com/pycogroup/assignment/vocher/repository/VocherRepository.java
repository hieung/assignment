package com.pycogroup.assignment.vocher.repository;

import com.pycogroup.assignment.vocher.entity.Vocher;
import com.pycogroup.assignment.vocher.entity.VocherPk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VocherRepository extends JpaRepository<Vocher, VocherPk> {

    Optional<Vocher> findById(VocherPk vocherPk);

    @Query("Select v From Vocher v where v.status='Failed' or v.status='Send'")
    List<Vocher> findFailedVocher();
}
