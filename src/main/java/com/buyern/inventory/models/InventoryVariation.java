package com.buyern.inventory.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
/**
 * @apiNote if price = -1, price is inherited from inventory
 * */
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "inventory_variations")
public class InventoryVariation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "inventory_id")
    private Inventory inventory;
    private Double price;
    @JsonManagedReference
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "inventoryVariation", cascade = CascadeType.ALL)
    private List<InventoryFeature> features = new java.util.ArrayList<>();
    /**
     * <h3>images Array</h3>
     */
    private String images;
    /**
     * <h3>videos Array</h3>
     */
    private String videos;

    public InventoryVariation(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        InventoryVariation that = (InventoryVariation) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}