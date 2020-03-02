package com.duboiscave.passion.rpg.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Getter
@NoArgsConstructor
@FieldNameConstants
public class AbstractEntity {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    protected Long id;
}
