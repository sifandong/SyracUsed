package com.sifan.mp_api.repository;


import com.sifan.mp_api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByLatBetweenAndLngBetween(
        double lowerLat, double upperLat,
        double lowerLng, double upperLng
    );
}
