package com.hamzabekkaoui.freelancerestapi.repositories;

import com.hamzabekkaoui.freelancerestapi.entities.Company;
import com.hamzabekkaoui.freelancerestapi.entities.Freelance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FreelanceRepository extends JpaRepository<Freelance , String> {


    Optional<Freelance> findByUserName(String userName);
    boolean existsByUserName(String userName);
}
