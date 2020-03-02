package com.duboiscave.passion.rpg.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
@Table(name = "properties", indexes = {
        @Index(name = "idx_properties_code", columnList = "property_code")
})
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)  //todo same as inherited from Object?
@NoArgsConstructor
@FieldNameConstants
@AllArgsConstructor
@Builder
public class Property extends AbstractUUIDEntity {

    @Column(name = "property_code", nullable = false, unique = true)
    @Length(min = 1, max = 10)
    private String propertyCode;

    @Column(name = "leased", nullable = false)
    private Boolean leased;

    @Column(name = "address", nullable = false, unique = true)
    @Length(min = 1, max = 255)
    private String address;

    @Column(name = "number_of_apartments", nullable = false)
    private Integer numberOfApartments;
}
