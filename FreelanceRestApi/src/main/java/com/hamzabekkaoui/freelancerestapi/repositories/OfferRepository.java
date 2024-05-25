package com.hamzabekkaoui.freelancerestapi.repositories;

import com.hamzabekkaoui.freelancerestapi.entities.Company;
import com.hamzabekkaoui.freelancerestapi.entities.Offer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OfferRepository extends JpaRepository<Offer, String> {


    List<Offer> findByCompany(Company company);
    Page<Offer> findByCompany(Company company , Pageable pageable);

    @Query("SELECT o FROM Offer o JOIN o.freelances f WHERE f.id = :freelanceId")
    List<Offer> findOffersAppliedByFreelance(String freelanceId);

    @Query("SELECT o FROM Offer o JOIN o.freelances f WHERE f.id = :freelanceId")
    Page<Offer> findOffersAppliedByFreelance(String freelanceId , Pageable pageable);


}
