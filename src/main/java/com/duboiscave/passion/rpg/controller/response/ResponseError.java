package com.duboiscave.passion.rpg.controller.response;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public final class ResponseError implements ApiError {

    @NonNull
    private final String reason;

    private final String field;

    public ResponseError(final String reason) {
        this.reason = reason;
        this.field = null;
    }
}
