package com.buyern.inventory.repositories;

import com.buyern.inventory.models.InventoryBaseCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryBaseCategoryRepository extends JpaRepository<InventoryBaseCategory, Long> {
}