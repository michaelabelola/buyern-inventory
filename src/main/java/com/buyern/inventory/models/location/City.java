package com.buyern.inventory.models.location;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity(name = "cities")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//  @Column(nullable = false, columnDefinition = "mediumint(8) NOT NULL AUTO_INCREMENT")
  @Column(nullable = false)
    private Long id;
    @Column(columnDefinition = "varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL")
    private String name;
    @Column(name = "state_id", columnDefinition = "mediumint(8) unsigned NOT NULL")
    private Long stateId;
    @Column(name = "state_code", columnDefinition = "varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL")
    private String stateCode;
    @Column(name = "country_id", columnDefinition = "mediumint(8) unsigned NOT NULL")
    private Long countryId;
    @Column(name = "country_code", columnDefinition = "char(2) COLLATE utf8mb4_unicode_ci NOT NULL")
    private String countryCode;
    @Column(columnDefinition = "decimal(10,8) NOT NULL")
    private Double latitude;
    @Column(columnDefinition = "decimal(11,8) NOT NULL")
    private Double longitude;
    @CreationTimestamp
    @JsonFormat(pattern = "YYYY-MM-dd HH:mm:ss")
    @Column(name = "created_at", columnDefinition = "timestamp NOT NULL DEFAULT '2014-01-01 06:31:01'")
    private Date createdAt;
    @UpdateTimestamp
    @JsonFormat(pattern = "YYYY-MM-dd HH:mm:ss")
    @Column(name = "updated_at", columnDefinition = "timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private Date updatedAt;
    @Column(columnDefinition = "tinyint(1) NOT NULL DEFAULT '1'")
    private boolean flag;
    @Column(columnDefinition = "varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Rapid API GeoDB Cities'")
    private String wikiDataId;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    City city = (City) o;
    return id != null && Objects.equals(id, city.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}