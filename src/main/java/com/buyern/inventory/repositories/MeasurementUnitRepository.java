package com.buyern.inventory.repositories;

import com.buyern.inventory.models.MeasurementUnit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeasurementUnitRepository extends JpaRepository<MeasurementUnit, Long> {
}