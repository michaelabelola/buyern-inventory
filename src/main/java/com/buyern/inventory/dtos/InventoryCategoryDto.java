package com.buyern.inventory.dtos;

import lombok.Data;
import java.io.Serializable;

@Data
public class InventoryCategoryDto implements Serializable {
    private Long id;
    private InventoryBaseCategoryDto category;
    private String name;
    private Long entityId;

    public InventoryCategoryDto(String name, Long entityId) {
        this.name = name;
        this.entityId = entityId;
    }
}
