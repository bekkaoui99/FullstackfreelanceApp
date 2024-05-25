package com.hamzabekkaoui.freelancerestapi.services;

import com.hamzabekkaoui.freelancerestapi.dto.request.ApplyToOfferRequest;
import com.hamzabekkaoui.freelancerestapi.dto.request.OfferRequest;
import com.hamzabekkaoui.freelancerestapi.dto.response.FreelanceResponse;
import com.hamzabekkaoui.freelancerestapi.dto.response.OfferResponse;
import com.hamzabekkaoui.freelancerestapi.exceptions.ResourceNotFoundException;
import org.springframework.data.domain.Page;

import java.util.List;

public interface FreelanceService {

    FreelanceResponse getFreelance(String id) throws ResourceNotFoundException;
    void applyToOffer(ApplyToOfferRequest applyToOfferRequest);
    List<OfferResponse> getAllOffers(String userName);
    Page<OfferResponse> getAllOffers(String userName , int pageNumber , int pageSize);


}
