package com.buyern.inventory.dtos;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Data
public class InventoryBaseCategoryDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 0L;
    private Long id;
    private String name;
    private String entityUid;
    private boolean isPrivate;
    private List<InventoryCategoryDto> categories;
}
