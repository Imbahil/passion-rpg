package com.duboiscave.passion.rpg.controller.response;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.time.OffsetDateTime;

@Getter
public class ApiErrorResponse implements ApiError {

    public interface ErrorMessages {
        String METHOD_ARGUMENT_TYPE_MISMATCH_EXCEPTION = "Method argument with value: %s has invalid type. Required type: %s";
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssXXXXX")
    private final OffsetDateTime time = OffsetDateTime.now();

    private final String message;
    private final String exceptionMessage;

    public ApiErrorResponse(final MethodArgumentTypeMismatchException exception) {
        final String parameterType = exception.getParameter().getParameterType().getSimpleName();
        final Object parameterValue = exception.getValue();

        this.message = String.format(ErrorMessages.METHOD_ARGUMENT_TYPE_MISMATCH_EXCEPTION, parameterValue, parameterType);
        this.exceptionMessage = exception.getMessage();
    }
}

