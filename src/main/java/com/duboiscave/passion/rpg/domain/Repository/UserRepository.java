package com.duboiscave.passion.rpg.domain.Repository;

import com.duboiscave.passion.rpg.domain.User;

import java.util.Optional;


public interface UserRepository extends UUIDAwareJpaRepository<User, Long> {

    Optional<User> findByEmail (final String code);
}
