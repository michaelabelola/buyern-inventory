package com.buyern.inventory.dtos;

import com.buyern.inventory.enums.InventoryFeaturesType;
import com.buyern.inventory.models.InventoryFeature;
import com.buyern.inventory.models.MeasurementUnit;
import lombok.Data;

@Data
public class InventoryFeatureDto {
    private Long id;
    private String name;
    private InventoryFeaturesType type;
    private String value;
    private double minValue;
    private double maxValue;
    private MeasurementUnit measurementUnit;
    private int orderId;

    public InventoryFeature toModel() {
        InventoryFeature inventoryFeature = new InventoryFeature();
        inventoryFeature.setName(name);
        inventoryFeature.setValue(value);
        inventoryFeature.setType(type);
        inventoryFeature.setMinValue(minValue);
        inventoryFeature.setMaxValue(maxValue);
        inventoryFeature.setMeasurementUnit(measurementUnit);
        inventoryFeature.setOrderId(orderId);
        return inventoryFeature;
    }
}
