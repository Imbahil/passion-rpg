package com.duboiscave.passion.rpg.domain.Repository;

import com.duboiscave.passion.rpg.domain.AbstractUUIDEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;
import java.util.UUID;

@NoRepositoryBean
public interface UUIDAwareJpaRepository<T extends AbstractUUIDEntity, ID> extends JpaRepository<T, ID> {

    Optional<T> findByUuid(UUID uuid);

    boolean existsByUuid(UUID uuid);
}