package com.duboiscave.passion.rpg.exception;

import java.util.UUID;

public class FoundException extends RuntimeException {

    private static final long serialVersionUID = -5587603791001252625L;

    public FoundException(){
    }

    public FoundException(final UUID uuid) {
        super(String.format("Entity with UUID %s already exists", uuid));
    }

    public FoundException(final String message, final Object... args) {
        super(String.format(message, args));
    }

    public FoundException(final String message) {
        super(message);
    }
}
