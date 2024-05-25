package com.hamzabekkaoui.freelancerestapi.repositories;

import com.hamzabekkaoui.freelancerestapi.entities.Technology;
import com.hamzabekkaoui.freelancerestapi.entities.TechnologyLevel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TechnologyRepository extends JpaRepository<Technology, Long> {
    boolean existsByNameAndLevel(String name, String level);

    Optional<Technology> findByNameAndLevel(String name, String level);
}
