package com.hamzabekkaoui.freelancerestapi.controllers;

import com.hamzabekkaoui.freelancerestapi.dto.response.CompanyResponse;
import com.hamzabekkaoui.freelancerestapi.dto.response.FreelanceResponse;
import com.hamzabekkaoui.freelancerestapi.dto.response.OfferResponse;
import com.hamzabekkaoui.freelancerestapi.services.GuestService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@RestController
@RequestMapping("/api/v1/guests")
@RequiredArgsConstructor
public class GuestController {

    private final GuestService guestService;


    @GetMapping("/freelance/list")
    public List<FreelanceResponse> getFreelances() {
        return guestService.getAllFreelances();
    }

    @GetMapping("/freelance/page")
    public Page<FreelanceResponse> getFreelances(
            @RequestParam(name = "pageNumber" , defaultValue = "O") int pageNumber,
            @RequestParam(name = "pageSize" , defaultValue = "O") int pageSize
    ) {
        return guestService.getAllFreelances(pageNumber , pageSize);
    }

    @GetMapping("/company/list")
    public List<CompanyResponse> getCompanies() {
        return guestService.getAllCompanies();
    }

    @GetMapping("/company/page")
    public Page<CompanyResponse> getCompanies(
            @RequestParam(name = "pageNumber" , defaultValue = "O") int pageNumber,
            @RequestParam(name = "pageSize" , defaultValue = "O") int pageSize
    ) {
        return guestService.getAllCompanies(pageNumber , pageSize);
    }


    @GetMapping("/offer/list")
    public List<OfferResponse> getOffers() {
        return guestService.getAllOffers();
    }


    @GetMapping("/offer/page")
    public Page<OfferResponse> getOffers(
            @RequestParam(name = "pageNumber" , defaultValue = "O") int pageNumber,
            @RequestParam(name = "pageSize" , defaultValue = "O") int pageSize
    ) {
        return guestService.getAllOffers(pageNumber , pageSize);
    }

}
