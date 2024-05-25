package com.hamzabekkaoui.freelancerestapi.controllers;

import com.hamzabekkaoui.freelancerestapi.dto.request.ApplyToOfferRequest;
import com.hamzabekkaoui.freelancerestapi.dto.response.OfferResponse;
import com.hamzabekkaoui.freelancerestapi.services.FreelanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/freelances")
@RequiredArgsConstructor
public class FreelanceController {

    private final FreelanceService freelanceService;


    @PostMapping("/byUserName")
    @PreAuthorize("hasAuthority('FREELANCE')")
    public List<OfferResponse> getAllFreelanceForEachFreelancer(@RequestBody Map<String , String> request) {
        String userName = request.get("userName");
        return freelanceService.getAllOffers(userName);
    }

    @PostMapping("/applied/offer/list")
    @PreAuthorize("hasAuthority('FREELANCE')")
    public List<OfferResponse> getAllFreelanceForEachFreelancer() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            String userName = authentication.getName();
            return freelanceService.getAllOffers(userName);
        }
        throw new RuntimeException("something went wrong");
    }


    @GetMapping("/applied/offer/page")
    @PreAuthorize("hasAuthority('FREELANCE')")
    public Page<OfferResponse> getAllFreelanceForEachFreelancer(
            @RequestParam(name = "pageNumber" , defaultValue = "O") int pageNumber,
            @RequestParam(name = "pageSize" , defaultValue = "10") int pageSize
    ) {
        if (pageNumber < 0) {
            pageNumber = 0; // default to 0 if a negative number is provided
        }
        if (pageSize <= 0) {
            pageSize = 10; // default to 10 if a non-positive number is provided
        }

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            String userName = authentication.getName();
            return freelanceService.getAllOffers(userName,pageNumber ,pageSize);
        }
        else
            throw new RuntimeException("something went wrong");
    }


    @PostMapping("/offer/apply")
    @PreAuthorize("hasAuthority('FREELANCE')")
    public void applyToOffer(@RequestBody ApplyToOfferRequest  applyToOfferRequest){
        freelanceService.applyToOffer(applyToOfferRequest);
    }



}
