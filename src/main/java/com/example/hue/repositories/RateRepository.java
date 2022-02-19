package com.example.hue.repositories;

import com.example.hue.models.entity.Rates;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RateRepository extends JpaRepository<Rates, Long> {
}
