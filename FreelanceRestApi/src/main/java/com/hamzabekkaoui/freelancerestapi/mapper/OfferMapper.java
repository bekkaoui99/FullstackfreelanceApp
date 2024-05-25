package com.hamzabekkaoui.freelancerestapi.mapper;

import com.hamzabekkaoui.freelancerestapi.dto.request.OfferRequest;
import com.hamzabekkaoui.freelancerestapi.dto.response.OfferResponse;
import com.hamzabekkaoui.freelancerestapi.entities.Company;
import com.hamzabekkaoui.freelancerestapi.entities.ExperienceLevel;
import com.hamzabekkaoui.freelancerestapi.entities.Offer;
import com.hamzabekkaoui.freelancerestapi.exceptions.ResourceNotFoundException;
import com.hamzabekkaoui.freelancerestapi.repositories.CompanyRepository;
import com.hamzabekkaoui.freelancerestapi.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OfferMapper {


    private final CompanyRepository companyRepository;

    public Offer offerRequestToOffer(OfferRequest offerRequest){
        Company company = companyRepository.findByCompanyName(offerRequest.companyName()).orElseThrow(() -> new ResourceNotFoundException("company doesn't exist"));

        return Offer.builder()
                .id(UUID.randomUUID().toString())
                .title(offerRequest.title())
                .description(offerRequest.description())
                .experienceLevel(ExperienceLevel.valueOf(offerRequest.experienceLevel()))
                .publishDate(offerRequest.publishDate())
                .offerTechnologies(offerRequest.offerTechnologies())
                .company(company)
                .build();
    }

    public OfferResponse offerToOfferResponse(Offer offer){
        return OfferResponse.builder()
                .id(offer.getId())
                .title(offer.getTitle())
                .description(offer.getDescription())
                .experienceLevel(offer.getExperienceLevel().toString())
                .publishDate(offer.getPublishDate())
                .offerTechnologies(offer.getOfferTechnologies())
                .companyName(offer.getCompany().getCompanyName())
                .build();

    }

}
