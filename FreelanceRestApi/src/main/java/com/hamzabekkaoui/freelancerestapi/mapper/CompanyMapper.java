package com.hamzabekkaoui.freelancerestapi.mapper;

import com.hamzabekkaoui.freelancerestapi.dto.response.CompanyResponse;
import com.hamzabekkaoui.freelancerestapi.entities.Company;
import org.springframework.stereotype.Service;

@Service
public class CompanyMapper {


    public CompanyResponse companyToCompanyResponse(Company company){
        return CompanyResponse.builder()
                .companyName(company.getCompanyName())
                .address(company.getAddress())
                .build();
    }
}
