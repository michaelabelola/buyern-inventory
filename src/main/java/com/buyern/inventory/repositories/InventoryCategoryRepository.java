package com.buyern.inventory.repositories;

import com.buyern.inventory.models.InventoryCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;

public interface InventoryCategoryRepository extends JpaRepository<InventoryCategory, Long> {
    boolean existsByIdAndEntityId(Long id, @Nullable Long entityId);


}