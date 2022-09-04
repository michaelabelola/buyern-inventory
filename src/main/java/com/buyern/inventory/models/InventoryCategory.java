package com.buyern.inventory.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;


/**
 * @apiNote <b><b>isPrivate</b></b>
 * false - if buyern should include everywhere
 * true - it should only be seen on your page
 */
@Entity(name = "inventory_category")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class InventoryCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "base_category_id")
    private InventoryBaseCategory baseCategory;
    private String name;
    private Long entityId;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        InventoryCategory that = (InventoryCategory) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}