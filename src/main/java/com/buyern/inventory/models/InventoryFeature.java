package com.buyern.inventory.models;

import com.buyern.inventory.enums.InventoryFeaturesType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

/**
 * <h3>Features of each variation variations</h3>
 *
 * @apiNote Example
 * {id:123, name:"color", value:"red", "visible":"true" },
 * {id:123, name:"Sleeve Color", value:"Green", "visible":"true" },
 * {id:123, name:"Sleeve Size", value:"M", "visible":"true" },
 */

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "inventory_features")
public class InventoryFeature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    private String name;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private InventoryFeaturesType type;
    /**
     * book red,
     */
    private String value;
    /**
     * if type is number
     */
    private double minValue;
    /**
     * if type is number
     */
    private double maxValue;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "measurement_unit_id")
    private MeasurementUnit measurementUnit;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "inventory_variation_id")
    private InventoryVariation inventoryVariation;
    /**
     * This is the order in which the items should be
     */
    private int orderId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        InventoryFeature that = (InventoryFeature) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}