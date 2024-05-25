package com.hamzabekkaoui.freelancerestapi.services.impl;

import com.hamzabekkaoui.freelancerestapi.dto.request.ApplyToOfferRequest;
import com.hamzabekkaoui.freelancerestapi.dto.request.OfferRequest;
import com.hamzabekkaoui.freelancerestapi.dto.response.FreelanceResponse;
import com.hamzabekkaoui.freelancerestapi.dto.response.OfferResponse;
import com.hamzabekkaoui.freelancerestapi.entities.Freelance;
import com.hamzabekkaoui.freelancerestapi.entities.Offer;
import com.hamzabekkaoui.freelancerestapi.entities.User;
import com.hamzabekkaoui.freelancerestapi.exceptions.ResourceNotFoundException;
import com.hamzabekkaoui.freelancerestapi.mapper.FreelanceMapper;
import com.hamzabekkaoui.freelancerestapi.mapper.OfferMapper;
import com.hamzabekkaoui.freelancerestapi.repositories.FreelanceRepository;
import com.hamzabekkaoui.freelancerestapi.repositories.OfferRepository;
import com.hamzabekkaoui.freelancerestapi.repositories.UserRepository;
import com.hamzabekkaoui.freelancerestapi.services.FreelanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class FreelanceServiceImpl implements FreelanceService {


    private final UserRepository userRepository;
    private final FreelanceMapper freelanceMapper;
    private final FreelanceRepository freelanceRepository;
    private final OfferRepository offerRepository;
    private final OfferMapper offerMapper;

    @Override
    public FreelanceResponse getFreelance(String id) throws ResourceNotFoundException {
        User freelance = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        return freelanceMapper.freelaceToFreelanceResponse((Freelance) freelance);

    }



    @Override
    public void applyToOffer(ApplyToOfferRequest applyToOfferRequest) {

        Freelance freelance = freelanceRepository.findByUserName(applyToOfferRequest.UserName())
                .orElseThrow(() -> new ResourceNotFoundException("Freelancer doesn't exist"));
        Offer offer = offerRepository.findById(applyToOfferRequest.offerId())
                .orElseThrow(() -> new ResourceNotFoundException("offer doesn't exist"));

        Set<Freelance> freelances = new HashSet<>();
        freelances.add(freelance);
        offer.setFreelances(freelances);
        offerRepository.save(offer);
    }

    @Override
    public List<OfferResponse> getAllOffers(String userName) {

        Freelance freelance = freelanceRepository.findByUserName(userName)
                .orElseThrow(() -> new ResourceNotFoundException("Freelancer doesn't exist"));

        return offerRepository.findOffersAppliedByFreelance(freelance.getId())
                .stream()
                .map(offerMapper::offerToOfferResponse)
                .toList();

    }

    @Override
    public Page<OfferResponse> getAllOffers(String userName, int pageNumber, int pageSize) {

        Freelance freelance = freelanceRepository.findByUserName(userName)
                .orElseThrow(() -> new ResourceNotFoundException("Freelancer doesn't exist"));

        Page<Offer> offersAppliedByFreelance = offerRepository.findOffersAppliedByFreelance(freelance.getId(), PageRequest.of(pageNumber, pageSize));
        List<OfferResponse> offerResponseList = offersAppliedByFreelance.getContent()
                .stream()
                .map(offerMapper::offerToOfferResponse)
                .toList();


        return new PageImpl<>(offerResponseList , offersAppliedByFreelance.getPageable() , offersAppliedByFreelance.getTotalElements());
    }
}
