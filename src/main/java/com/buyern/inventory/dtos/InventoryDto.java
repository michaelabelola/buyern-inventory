package com.buyern.inventory.dtos;

import com.buyern.inventory.helpers.ListMapper;
import com.buyern.inventory.models.Inventory;
import com.buyern.inventory.models.InventoryBaseCategory;
import com.buyern.inventory.models.InventoryCategory;
import com.buyern.inventory.models.InventoryVariation;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class InventoryDto {
    private Long id;
    private String uid;
    private String name;
    private String entityId;
    private String about;
    private Date timeAdded;
    private Long addedBy;
    private int qty;
    private int unit;
    private Double price;
    private String image;
    private String media;
    private InventoryBaseCategory baseCategory;
    private InventoryCategory category;
    private List<InventoryVariationDto> variations;

    public Inventory toModel(){
        Inventory inventory = new Inventory();
        inventory.setId(this.id);
        inventory.setUid(uid);
        inventory.setName(name);
        inventory.setEntityId(entityId);
        inventory.setAbout(about);
        inventory.setAddedBy(addedBy);
        inventory.setQty(qty);
        inventory.setUnit(unit);
        inventory.setPrice(price);
        inventory.setImage(image);
        inventory.setMedia(media);
        inventory.setBaseCategory(baseCategory);
        inventory.setCategory(category);
        inventory.setVariations(new ListMapper<InventoryVariationDto, InventoryVariation>().map(variations, InventoryVariationDto::toModel));
        return inventory;
    }
}
