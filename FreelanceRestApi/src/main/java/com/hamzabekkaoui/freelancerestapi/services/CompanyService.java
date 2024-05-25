package com.hamzabekkaoui.freelancerestapi.services;

import com.hamzabekkaoui.freelancerestapi.dto.request.OfferRequest;
import com.hamzabekkaoui.freelancerestapi.dto.response.OfferResponse;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CompanyService {


    void createOffer(OfferRequest offerRequest);
    List<OfferResponse> getAllOffers(String companyName);
    Page<OfferResponse> getAllOffers(String companyName , int pageNumber , int pageSize);

}
