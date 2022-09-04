package com.buyern.inventory.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "measurement_unit")
@Data
public class MeasurementUnit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    //METRES, POUNDS, GRAM, KILOGRAM, INCHES
    private String name;
    /**
     * entity that owns this unit
     */
    private Long entityId;
    // M, LBS, G, KG, INCH,
    private String symbol;
    private Long baseCategoryId;
    private Long categoryId;
}