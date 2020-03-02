package com.duboiscave.passion.rpg.domain.Repository;

import com.duboiscave.passion.rpg.domain.Property;

import java.util.Optional;


public interface PropertyRepository extends UUIDAwareJpaRepository<Property, Long> {

    Optional<Property> findByPropertyCode (final String code);
}
