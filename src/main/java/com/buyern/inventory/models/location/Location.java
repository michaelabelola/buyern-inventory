package com.buyern.inventory.models.location;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "locations")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    private String tag;
    private String address;
    @ManyToOne()
    private City city;
    @ManyToOne()
    private State state;
    @ManyToOne()
    private Country country;
    private String zipcode;
    private Double latitude;
    private Double longitude;
//    private String ownerId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Location location = (Location) o;
        return id != null && Objects.equals(id, location.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
