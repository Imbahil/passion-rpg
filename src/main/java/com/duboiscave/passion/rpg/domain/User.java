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
import javax.validation.constraints.Email;

@Entity
@Table(name = "users", indexes = {
        @Index(name = "idx_users_email", columnList = "email")
})
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)  //todo same as inherited from Object?
@NoArgsConstructor
@FieldNameConstants
@AllArgsConstructor
@Builder
public class User extends AbstractUUIDEntity {

    @Column(name = "name", nullable = false)
    private String name;

    @Email
    @Column(name = "email", nullable = false, unique = true)
    private String email;
}
