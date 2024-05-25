package com.hamzabekkaoui.freelancerestapi.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("company")
public class Company extends User{

    @Column(unique = true)
    private String companyName;
    private String address;

    @OneToMany(mappedBy = "company" , cascade = CascadeType.ALL)
    private Set<Offer> offers  = new HashSet<>();;


}
