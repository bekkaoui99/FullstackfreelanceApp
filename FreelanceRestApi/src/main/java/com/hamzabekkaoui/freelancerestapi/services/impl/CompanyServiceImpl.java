package com.hamzabekkaoui.freelancerestapi.services.impl;

import com.hamzabekkaoui.freelancerestapi.dto.request.OfferRequest;
import com.hamzabekkaoui.freelancerestapi.dto.response.OfferResponse;
import com.hamzabekkaoui.freelancerestapi.entities.Company;
import com.hamzabekkaoui.freelancerestapi.entities.ExperienceLevel;
import com.hamzabekkaoui.freelancerestapi.entities.Offer;
import com.hamzabekkaoui.freelancerestapi.exceptions.ResourceNotFoundException;
import com.hamzabekkaoui.freelancerestapi.mapper.OfferMapper;
import com.hamzabekkaoui.freelancerestapi.repositories.CompanyRepository;
import com.hamzabekkaoui.freelancerestapi.repositories.OfferRepository;
import com.hamzabekkaoui.freelancerestapi.services.CompanyService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;
    private final OfferRepository offerRepository;

    private final OfferMapper offerMapper;

    @Override
    @Transactional
    public void createOffer(OfferRequest offerRequest) {
        Offer offer = offerMapper.offerRequestToOffer(offerRequest);
        offerRepository.save(offer);
    }

    @Override
    public List<OfferResponse> getAllOffers(String companyName) {
        Company company = companyRepository.findByCompanyName(companyName)
                .orElseThrow(() -> new ResourceNotFoundException("company doesn't exist with this name : " + companyName));

        return offerRepository.findByCompany(company)
                .stream()
                .map(offerMapper::offerToOfferResponse)
                .toList();

    }

    @Override
    public Page<OfferResponse> getAllOffers(String companyName, int pageNumber, int pageSize) {
        Company company = companyRepository.findByCompanyName(companyName)
                .orElseThrow(() -> new ResourceNotFoundException("company doesn't exist with this name : " + companyName));

        Page<Offer> allCompanyOffers = offerRepository.findByCompany(company, PageRequest.of(pageNumber, pageSize));
        List<OfferResponse> offerResponseList = allCompanyOffers.getContent()
                .stream()
                .map(offerMapper::offerToOfferResponse)
                .toList();

        return new PageImpl<>(offerResponseList , allCompanyOffers.getPageable() , allCompanyOffers.getTotalElements());
    }


}
