package com.hamzabekkaoui.freelancerestapi.entities;


import jakarta.persistence.*;
import lombok.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Offer {

    @Id
    private String id;
    private String title;
    private String description;
    @Enumerated(EnumType.STRING)
    private ExperienceLevel experienceLevel;
    private Date publishDate;

    @ElementCollection(targetClass = String.class)
    @CollectionTable(name = "offerTechnologies", joinColumns = @JoinColumn(name = "offer_id"))
    private Set<String> offerTechnologies = new HashSet<>();;


    @ManyToMany
    @JoinTable(
            name = "apply_offer",
            joinColumns = @JoinColumn(name = "offer_id"),
            inverseJoinColumns = @JoinColumn(name = "freelance_id")
    )
    private Set<Freelance> freelances  = new HashSet<>();;

    @ManyToOne()
    private Company company;



}
