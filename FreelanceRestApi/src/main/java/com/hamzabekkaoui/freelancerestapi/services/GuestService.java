package com.hamzabekkaoui.freelancerestapi.services;

import com.hamzabekkaoui.freelancerestapi.dto.response.CompanyResponse;
import com.hamzabekkaoui.freelancerestapi.dto.response.FreelanceResponse;
import com.hamzabekkaoui.freelancerestapi.dto.response.OfferResponse;
import com.hamzabekkaoui.freelancerestapi.entities.Offer;
import org.springframework.data.domain.Page;

import java.util.List;

public interface GuestService {
    List<FreelanceResponse> getAllFreelances();
    Page<FreelanceResponse> getAllFreelances(int pageNumber , int pageSize);
    List<CompanyResponse> getAllCompanies();
    Page<CompanyResponse> getAllCompanies(int pageNumber , int pageSize);
    List<OfferResponse> getAllOffers();
    Page<OfferResponse> getAllOffers(int pageNumber , int pageSize);
}
