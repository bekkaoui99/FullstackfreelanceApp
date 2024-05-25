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
@Builder
public class Technology {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    //@Enumerated(EnumType.STRING)
    private String level;


    @ManyToMany(mappedBy = "technologies")
    private Set<Freelance> freelances = new HashSet<>();;
}
