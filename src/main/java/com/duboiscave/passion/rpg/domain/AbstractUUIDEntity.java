package com.duboiscave.passion.rpg.domain;

import com.duboiscave.passion.rpg.controller.dto.UuidDto;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.FieldNameConstants;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.util.UUID;

@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@FieldNameConstants
public class AbstractUUIDEntity extends AbstractEntity{

    @EqualsAndHashCode.Include
    @ToString.Include
    @Column(name = "uuid", unique = true, nullable = false)
    protected UUID uuid = UUID.randomUUID();

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + '(' + "uuid=" + uuid + ')';
    }

    public UuidDto getUuidDto() {
        return new UuidDto(uuid);
    }
}
