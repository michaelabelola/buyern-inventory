package com.buyern.inventory.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "inventories")
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    @Column(unique = true, nullable = false)
    private String uid = UUID.randomUUID().toString();
    private String name;
    private String entityId;
    private String about;
    @CreationTimestamp
    @JsonFormat(pattern = "YYYY-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeAdded;
    private Long addedBy;//user Id
    private int qty;
    private int unit;
    private double price;
    /**
     * <h3>Promo Json Array</h3>
     * {promoId:123, promoName:"Summer Discount", }
     */
//    @OneToMany(fetch = FetchType.LAZY)
//    @JoinTable(name = "promo_inventory_ids", joinColumns = @JoinColumn(name = "inventory_id"), inverseJoinColumns = @JoinColumn(name = "promo_id"))
//    private List<Promo> promos; // promo json array
    private String image;
    @Column(columnDefinition = "LONGTEXT")
    private String media; // image link json array
    @ManyToOne
    @JoinColumn(name = "base_category_id")
    private InventoryBaseCategory baseCategory;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "category_id")//    @JoinColumn(name = "sub_category_id", nullable = true)
    private InventoryCategory category;
    @JsonManagedReference
    @OneToMany(mappedBy = "inventory", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private List<InventoryVariation> variations;

    public Inventory(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Inventory inventory = (Inventory) o;
        return id != null && Objects.equals(id, inventory.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}