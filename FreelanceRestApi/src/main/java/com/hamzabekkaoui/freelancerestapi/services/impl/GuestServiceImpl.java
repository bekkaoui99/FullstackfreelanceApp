package com.hamzabekkaoui.freelancerestapi.services.impl;

import com.hamzabekkaoui.freelancerestapi.dto.response.CompanyResponse;
import com.hamzabekkaoui.freelancerestapi.dto.response.FreelanceResponse;
import com.hamzabekkaoui.freelancerestapi.dto.response.OfferResponse;
import com.hamzabekkaoui.freelancerestapi.entities.Company;
import com.hamzabekkaoui.freelancerestapi.entities.Freelance;
import com.hamzabekkaoui.freelancerestapi.entities.Offer;
import com.hamzabekkaoui.freelancerestapi.mapper.CompanyMapper;
import com.hamzabekkaoui.freelancerestapi.mapper.FreelanceMapper;
import com.hamzabekkaoui.freelancerestapi.mapper.OfferMapper;
import com.hamzabekkaoui.freelancerestapi.repositories.CompanyRepository;
import com.hamzabekkaoui.freelancerestapi.repositories.FreelanceRepository;
import com.hamzabekkaoui.freelancerestapi.repositories.OfferRepository;
import com.hamzabekkaoui.freelancerestapi.repositories.UserRepository;
import com.hamzabekkaoui.freelancerestapi.services.GuestService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class GuestServiceImpl implements GuestService {


    private final CompanyRepository companyRepository;
    private final FreelanceRepository freelanceRepository;
    private final OfferRepository offerRepository;

    private final FreelanceMapper freelanceMapper;
    private final OfferMapper offerMapper;
    private final CompanyMapper companyMapper;


    @Override
    public List<FreelanceResponse> getAllFreelances() {
        return freelanceRepository.findAll()
                .stream()
                .map(freelanceMapper::freelaceToFreelanceResponse)
                .toList();

    }

    @Override
    public Page<FreelanceResponse> getAllFreelances(int pageNumber, int pageSize) {
        Page<Freelance> freelances = freelanceRepository.findAll(PageRequest.of(pageNumber, pageSize));
        List<FreelanceResponse> freelanceResponseList = freelances.getContent()
                .stream()
                .map(freelanceMapper::freelaceToFreelanceResponse)
                .toList();

        return new PageImpl<>(freelanceResponseList , freelances.getPageable() , freelances.getTotalElements());
    }

    @Override
    public List<CompanyResponse> getAllCompanies() {
        return companyRepository.findAll()
                .stream()
                .map(companyMapper::companyToCompanyResponse)
                .toList();
    }

    @Override
    public Page<CompanyResponse> getAllCompanies(int pageNumber, int pageSize) {
        Page<Company> companies = companyRepository.findAll(PageRequest.of(pageNumber, pageSize));
        List<CompanyResponse> companyResponseList = companies.getContent()
                .stream()
                .map(companyMapper::companyToCompanyResponse)
                .toList();

        return new PageImpl<>(companyResponseList , companies.getPageable() , companies.getTotalElements());

    }

    @Override
    public List<OfferResponse> getAllOffers() {
        return offerRepository.findAll()
                .stream()
                .map(offerMapper::offerToOfferResponse)
                .toList();
    }

    @Override
    public Page<OfferResponse> getAllOffers(int pageNumber, int pageSize) {
        Page<Offer> offers = offerRepository.findAll(PageRequest.of(pageNumber, pageSize));
        List<OfferResponse> offerResponseList = offers.getContent()
                .stream()
                .map(offerMapper::offerToOfferResponse)
                .toList();

        return new PageImpl<>(offerResponseList , offers.getPageable() , offers.getTotalElements());

    }
}
