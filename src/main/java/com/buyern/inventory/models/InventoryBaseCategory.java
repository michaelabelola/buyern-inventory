package com.buyern.inventory.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "inventory_base_category")
public class InventoryBaseCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    private String name;
    private String entityUid;
    @Column(columnDefinition="boolean default false")
    private boolean isPrivate;
    @JsonManagedReference
    @OneToMany(mappedBy = "baseCategory", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private List<InventoryCategory> categories;

    public InventoryBaseCategory(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        InventoryBaseCategory that = (InventoryBaseCategory) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}