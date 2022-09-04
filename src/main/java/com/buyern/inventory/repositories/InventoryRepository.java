package com.buyern.inventory.repositories;

import com.buyern.inventory.models.Inventory;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InventoryRepository extends JpaRepository<Inventory, Long>, JpaSpecificationExecutor<Inventory> {
    List<Inventory> findByEntityIdOrderByNameAsc(String entityId);

    @Query("select i from Inventory i where i.entityId = ?1")
    List<Inventory> findAllByEntityId(String entityId, Pageable pageable);

}