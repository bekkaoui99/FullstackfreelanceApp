package com.hamzabekkaoui.freelancerestapi.controllers;


import com.hamzabekkaoui.freelancerestapi.dto.request.OfferRequest;
import com.hamzabekkaoui.freelancerestapi.dto.response.OfferResponse;
import com.hamzabekkaoui.freelancerestapi.services.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/companies")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;


    @PostMapping("/offer/create")
    @PreAuthorize("hasAuthority('COMPANY')")
    public String createOffer(@RequestBody OfferRequest offerRequest){
        companyService.createOffer(offerRequest);
        return "offer has created by => : " + offerRequest.companyName();
    }

//    @PostMapping("/offer/list")
//    @PreAuthorize("hasAuthority('COMPANY')")
//    public List<OfferResponse> getAllOffersForEachCompany(@RequestBody Map<String , String> request){
//        String companyNam = request.get("companyName");
//        return companyService.getAllOffers(companyNam);
//    }

    @GetMapping("/offer/list")
    @PreAuthorize("hasAuthority('COMPANY')")
    public List<OfferResponse> getAllOffersForEachCompany(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication != null && authentication.isAuthenticated()){
            String companyName = authentication.getName();
            return companyService.getAllOffers(companyName);
        }
        throw new RuntimeException("something went wrong");
    }

    @GetMapping("/offer/page")
    @PreAuthorize("hasAuthority('COMPANY')")
    public Page<OfferResponse> getAllOffersForEachCompany(
            @RequestParam(name = "pageNumber" , defaultValue = "O") int pageNumber,
            @RequestParam(name = "pageSize" , defaultValue = "10") int pageSize
    ){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication != null && authentication.isAuthenticated()){
            String companyName = authentication.getName();
            return companyService.getAllOffers(companyName , pageNumber , pageSize);
        }
        throw new RuntimeException("something went wrong");
    }

}
