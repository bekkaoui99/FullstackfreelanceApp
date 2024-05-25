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
@DiscriminatorValue("freelance")
public class Freelance extends User {

    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String userName;
    private String city;
    private String phoneNumber;
    private String jobTitle;
    private String image;
    private String CV;


    @ManyToMany
    @JoinTable(
            name = "freelance_technology",
            joinColumns = @JoinColumn(name = "technology_id" , referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "freelance_id" , referencedColumnName = "id")
    )
    private Set<Technology> technologies = new HashSet<>();;



    @ManyToMany(mappedBy = "freelances")
    private Set<Offer> offers = new HashSet<>();;


}
