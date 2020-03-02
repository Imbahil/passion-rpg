package com.duboiscave.passion.rpg.exception;


import lombok.Getter;

public class ValueTooBigException extends RuntimeException {

    public static final String VALUE_TOO_BIG_MESSAGE = "%s must be less or equal than: %s";

    @Getter
    private final String field;

    public ValueTooBigException(final String field, final String value) {
        super(String.format(VALUE_TOO_BIG_MESSAGE, field, value));
        this.field = field;
    }
}
