package com.buyern.inventory.services;

import com.buyern.inventory.dtos.InventoryCategoryDto;
import com.buyern.inventory.dtos.InventoryDto;
import com.buyern.inventory.models.Inventory;

import java.util.Collections;

import com.buyern.inventory.models.InventoryVariation;
import com.buyern.inventory.repositories.InventoryBaseCategoryRepository;
import com.buyern.inventory.repositories.InventoryCategoryRepository;
import com.buyern.inventory.repositories.InventoryRepository;
import com.buyern.inventory.repositories.MeasurementUnitRepository;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Data
@Service
public class InventoryService {
    final Logger logger = LoggerFactory.getLogger(InventoryService.class);
    final InventoryRepository inventoryRepository;
    final MeasurementUnitRepository measurementUnitRepository;
    final InventoryCategoryRepository inventoryCategoryRepository;
    final InventoryCategoryService inventoryCategoryService;
    final InventoryBaseCategoryRepository inventoryBaseCategoryRepository;

    public Optional<Inventory> getInventory(Long id) {
        return inventoryRepository.findById(id);
    }

    public List<Inventory> getEntityInventories(String entityId, int page, int pageSize) {
        return inventoryRepository.findAllByEntityId(entityId, Pageable.ofSize(pageSize).withPage(page));
    }

    public List<Inventory> getInventoriesById(List<Long> ids) {
        return inventoryRepository.findAllById(ids);
    }

    public List<Inventory> getInventoriesByEntityId(String entityId) {
        return inventoryRepository.findByEntityIdOrderByNameAsc(entityId);
    }

    /**
     * Inventory category should either have the entityId and category id specified or entity id and name
     */
    @Transactional
    public Optional<Inventory> createInventory(InventoryDto inventoryDto) {
        Inventory inventory = inventoryDto.toModel();
        inventory.setUid(UUID.randomUUID().toString());
        if (inventory.getCategory().getId() != null && inventoryCategoryRepository.existsByIdAndEntityId(inventory.getCategory().getId(), 1L))
            throw new IllegalArgumentException("selected Category does not exist or does not belong to entity");
        if (inventory.getCategory().getName() == null)
            throw new IllegalArgumentException("Selected Category doesn't have a name passed");
        inventory.setCategory(inventoryCategoryService.createInventoryCategory(new InventoryCategoryDto(inventory.getCategory().getName(), 1L)));
        inventory.setBaseCategory(inventoryBaseCategoryRepository.findById(inventory.getBaseCategory().getId()).orElseThrow(() -> new EntityNotFoundException("Invalid base Category passed")));
//        measurementUnitRepository.findById()
        inventory.getVariations().forEach(inventoryVariation -> {
            inventoryVariation.getFeatures().forEach(inventoryFeature -> {
                logger.info(inventoryFeature.getMeasurementUnit().toString());
            });
        });
        Inventory savedInventory = inventoryRepository.save(inventory);
        savedInventory.getVariations().forEach(inventoryVariation -> {
            inventoryVariation.setInventory(new Inventory(savedInventory.getId()));
            inventoryVariation.getFeatures().forEach(inventoryFeature -> {
                inventoryFeature.setInventoryVariation(new InventoryVariation(inventoryVariation.getId()));
                inventoryFeature.getMeasurementUnit().setCategoryId(inventory.getCategory().getId());
                inventoryFeature.getMeasurementUnit().setEntityId(1L);
                inventoryFeature.getMeasurementUnit().setBaseCategoryId(inventory.getBaseCategory().getId());
            });
        });
        inventoryRepository.save(savedInventory);
        return Optional.of(savedInventory);
    }

    public List<InventoryVariation> getInventoryVariations(Long inventoryId) {
        Optional<Inventory> inventory = inventoryRepository.findById(inventoryId);
        if (inventory.isPresent())
            return inventory.get().getVariations();
        else return Collections.emptyList();

    }

}
