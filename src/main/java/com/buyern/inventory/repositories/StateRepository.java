package com.buyern.inventory.repositories;


import com.buyern.inventory.models.location.State;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StateRepository extends JpaRepository<State, Long> {

    List<State> findAllByCountryIdOrderByName(Long id);
    List<State> findAllByCountryCode(String countryCode);
}