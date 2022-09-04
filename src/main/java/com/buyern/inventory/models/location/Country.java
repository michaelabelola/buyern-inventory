package com.buyern.inventory.models.location;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity(name = "countries")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//  @Column(nullable = false, columnDefinition = "mediumint(8) NOT NULL AUTO_INCREMENT")
  @Column(nullable = false)
    private Long id;
    @Column(columnDefinition = "varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL")
    private String name;
    @Column(columnDefinition = "char(3) COLLATE utf8mb4_unicode_ci DEFAULT NULL")
    private String iso3;
    @Column(name = "numeric_code", columnDefinition = "char(3) COLLATE utf8mb4_unicode_ci DEFAULT NULL")
    private String numericCode;
    @Column(columnDefinition = "char(2) COLLATE utf8mb4_unicode_ci DEFAULT NULL")
    private String iso2;
    @Column(name = "phonecode", columnDefinition = "varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL")
    private String phoneCode;
    @Column(columnDefinition = "varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL")
    private String capital;
    @Column(columnDefinition = "varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL")
    private String currency;
    @Column(name = "currency_name", columnDefinition = "varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL")
    private String currencyName;
    @Column(name = "currency_symbol", columnDefinition = "varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL")
    private String currency_symbol;
    @Column(columnDefinition = "varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL")
    private String tld;
    @Column(name = "native", columnDefinition = "varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL")
    private String _native;
    @Column(name = "region", columnDefinition = "varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL")
    private String region;
    @Column(name = "subregion", columnDefinition = "varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL")
    private String subRegion;
    @Column(columnDefinition = "text COLLATE utf8mb4_unicode_ci")
    private String timezones;
    @Column(columnDefinition = "text COLLATE utf8mb4_unicode_ci")
    private String translations;
    @Column(columnDefinition = "decimal(10,8) DEFAULT NULL")
    private Double latitude;
    @Column(columnDefinition = "decimal(11,8) DEFAULT NULL")
    private Double longitude;
    @Column(columnDefinition = "varchar(191) COLLATE utf8mb4_unicode_ci DEFAULT NULL")
    private String emoji;
    @Column(columnDefinition = "varchar(191) COLLATE utf8mb4_unicode_ci DEFAULT NULL")
    private String emojiU;
    @CreationTimestamp
    @JsonFormat(pattern = "YYYY-MM-dd HH:mm:ss")
    @Column(name = "created_at", columnDefinition = "timestamp NULL DEFAULT NULL")
    private Date createdAt;
    @UpdateTimestamp
    @JsonFormat(pattern = "YYYY-MM-dd HH:mm:ss")
    @Column(name = "updated_at", columnDefinition = "timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private Date updatedAt;
    @Column(name = "flag", columnDefinition = "tinyint(1) NOT NULL DEFAULT '1'")
    private boolean flag;
    @Column(name = "wikiDataId", columnDefinition = "varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Rapid API GeoDB Cities'")
    private String wikiDataId;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    Country country = (Country) o;
    return id != null && Objects.equals(id, country.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
