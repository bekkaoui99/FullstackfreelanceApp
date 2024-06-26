package com.hamzabekkaoui.freelancerestapi.repositories;


import com.hamzabekkaoui.freelancerestapi.entities.Freelance;
import com.hamzabekkaoui.freelancerestapi.entities.Role;
import com.hamzabekkaoui.freelancerestapi.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);
}
