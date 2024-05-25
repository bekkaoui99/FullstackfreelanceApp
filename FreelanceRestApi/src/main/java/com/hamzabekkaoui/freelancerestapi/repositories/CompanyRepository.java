package com.hamzabekkaoui.freelancerestapi.repositories;

import com.hamzabekkaoui.freelancerestapi.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company , String> {
    Optional<Company> findByCompanyName(String companyName);
    boolean existsByCompanyName(String companyName);
}
