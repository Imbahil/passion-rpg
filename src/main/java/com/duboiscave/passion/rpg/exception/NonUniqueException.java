package com.duboiscave.passion.rpg.exception;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class NonUniqueException extends RuntimeException {

    private static final long serialVersionUID = 279839536260756538L;

    @Getter
    private final List<String> fields = new ArrayList<>();

    public NonUniqueException() {
    }

    public NonUniqueException(final String message) {
        super(message);
    }

    public NonUniqueException(final String message, final String... fields) {
        super(message);
        this.fields.addAll(Arrays.asList(fields));
    }

    public NonUniqueException(final String message, final Collection<String> fields) {
        super(message);
        this.fields.addAll(fields);
    }

    public NonUniqueException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public NonUniqueException(final Throwable cause) {
        super(cause);
    }

    public NonUniqueException(final String message, final Throwable cause, final boolean enableSuppression, final boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
