package com.duboiscave.passion.rpg.exception;


import java.util.UUID;

public class NotFoundException extends RuntimeException {

    private static final long serialVersionUID = -5517431799381512683L;

    public NotFoundException() {
    }

    public NotFoundException(final UUID uuid) {
        super(String.format("No entity with UUID: %s", uuid));
    }

    public NotFoundException(final String message) {
        super(message);
    }

    public NotFoundException(final String message, final Object... args) {
        super(String.format(message, args));
    }

    public NotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public NotFoundException(final Throwable cause) {
        super(cause);
    }

    public NotFoundException(final String message, final Throwable cause, final boolean enableSuppression, final boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
