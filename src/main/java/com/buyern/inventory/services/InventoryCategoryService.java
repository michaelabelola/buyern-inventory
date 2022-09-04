package com.buyern.inventory.services;

import com.buyern.inventory.dtos.InventoryCategoryDto;
import com.buyern.inventory.models.InventoryCategory;
import com.buyern.inventory.repositories.InventoryCategoryRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Data
@Service
public class InventoryCategoryService {
    final InventoryCategoryRepository inventoryCategoryRepository;

    @Transactional
    public InventoryCategory createInventoryCategory(InventoryCategoryDto inventoryCategoryDto) {
        if (inventoryCategoryDto.getEntityId() == null || inventoryCategoryDto.getName() == null) {

        }
        InventoryCategory inventoryCategory = new InventoryCategory();
        inventoryCategory.setName(inventoryCategoryDto.getName());
        inventoryCategory.setEntityId(inventoryCategoryDto.getEntityId());
        return inventoryCategoryRepository.save(inventoryCategory);
    }
}
