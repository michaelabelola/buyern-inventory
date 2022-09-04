package com.buyern.inventory.dtos;

import com.buyern.inventory.helpers.ListMapper;
import com.buyern.inventory.models.InventoryFeature;
import com.buyern.inventory.models.InventoryVariation;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class InventoryVariationDto {
    private final Long id;
    private final List<InventoryFeatureDto> features;
    private final String images;
    private final String videos;
    private Double price;

    public InventoryVariation toModel() {
        InventoryVariation inventoryVariation = new InventoryVariation();
        inventoryVariation.setImages(images);
        inventoryVariation.setVideos(videos);
        inventoryVariation.setFeatures(new ListMapper<InventoryFeatureDto, InventoryFeature>().map(features, InventoryFeatureDto::toModel));
        return inventoryVariation;
    }
}
