package com.duboiscave.passion.rpg.controller;

import com.duboiscave.passion.rpg.controller.response.ApiErrorResponse;
import com.duboiscave.passion.rpg.controller.response.ResponseError;
import com.duboiscave.passion.rpg.controller.response.ValidationError;
import com.duboiscave.passion.rpg.exception.ForbiddenException;
import com.duboiscave.passion.rpg.exception.NonUniqueException;
import com.duboiscave.passion.rpg.exception.NotFoundException;
import com.duboiscave.passion.rpg.exception.ValueTooBigException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.data.mapping.PropertyReferenceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Collections.singletonList;


@Slf4j
@RestControllerAdvice
public class ControllerAdvice {

    public interface ErrorMessages {

        String MUST_BE_UNIQUE = "MUST_BE_UNIQUE";
        String CONNECTED_OBJECT = "CONNECTED_OBJECT";
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public void defaultExceptionHandler(final Exception exception) {
        log.error(exception.getMessage(), exception);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public void httpMessageNotReadableExceptionHandler(final HttpMessageNotReadableException exception) {
        log.error(exception.getMessage(), exception);
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public void fileNotFoundExceptionHandler(final NotFoundException exception) {
        log.warn(exception.getMessage());
    }

    @ExceptionHandler(NonUniqueException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public List<ResponseError> nonUniqueExceptionHandler(final NonUniqueException exception) {
        log.warn(exception.getMessage());
        return exception.getFields().stream()
                .map(errorFields -> new ResponseError(ErrorMessages.MUST_BE_UNIQUE, errorFields))
                .collect(Collectors.toList());
    }

    @ExceptionHandler(ForbiddenException.class)
    @ResponseStatus(value = HttpStatus.FORBIDDEN)
    public void forbiddenException(final ForbiddenException exception) {
        log.error(exception.getMessage(), exception);
    }

    @ExceptionHandler(PropertyReferenceException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public void propertyNotFoundExceptionHandler(final PropertyReferenceException exception) {
        log.error(exception.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public List<ResponseError> bodyValidationError(final MethodArgumentNotValidException exception) {
        return resolveBindingResult(exception.getBindingResult());
    }

    @ExceptionHandler(BindException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public List<ResponseError> pathValidationError(final BindException exception) {
        return resolveBindingResult(exception.getBindingResult());
    }

    @ExceptionHandler(ValueTooBigException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public List<ResponseError> valueTooBigExceptionHandler(final ValueTooBigException exception) {
        log.warn(exception.getMessage());
        return singletonList(new ResponseError(ValidationError.VALUE_TOO_BIG.name(), exception.getField()));
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ApiErrorResponse methodArgumentTypeMismatchExceptionHandler(final MethodArgumentTypeMismatchException exception) {
        log.warn(exception.getMessage());
        return new ApiErrorResponse(exception);
    }

    private List<ResponseError> resolveBindingResult(final BindingResult bindingResult) {
        return bindingResult
                .getAllErrors()
                .stream()
                .map(this::mapObjectError)
                .collect(Collectors.toList());
    }

    private ResponseError mapObjectError(final ObjectError objectError) {
        if (objectError instanceof FieldError) {
            final FieldError fieldError = (FieldError) objectError;
            return new ResponseError(fieldError.getDefaultMessage(), fieldError.getField());
        } else {
            return new ResponseError(objectError.getDefaultMessage());
        }
    }
}
