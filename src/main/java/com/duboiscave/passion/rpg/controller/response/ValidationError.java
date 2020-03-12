package com.duboiscave.passion.rpg.controller.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum ValidationError {
    MUST_BE_NULL("javax.validation.constraints.Null.message"),
    MUST_NOT_BE_NULL("javax.validation.constraints.NotNull.message"),
    MUST_NOT_BE_EMPTY("javax.validation.constraints.NotEmpty.message"),
    MUST_NOT_BE_BLANK("javax.validation.constraints.NotBlank.message"),

    MUST_BE_FALSE("javax.validation.constraints.AssertFalse.message"),
    MUST_BE_TRUE("javax.validation.constraints.AssertTrue.message"),

    MUST_BE_SMALLER_THAN_ZERO("javax.validation.constraints.Negative.message"),
    MUST_BE_SMALLER_THAN_OR_EQUAL_ZERO("javax.validation.constraints.NegativeOrZero.message"),
    MUST_BE_GREATER_THAN_OR_EQUAL_ZERO("javax.validation.constraints.PositiveOrZero.message"),
    MUST_BE_GREATER_THAN_ZERO("javax.validation.constraints.Positive.message"),
    VALUE_TOO_SMALL("javax.validation.constraints.Min.message"),
    DECIMAL_VALUE_TOO_SMALL("javax.validation.constraints.DecimalMin.message"),
    VALUE_TOO_BIG("javax.validation.constraints.Max.message"),
    DECIMAL_VALUE_TOO_BIG("javax.validation.constraints.DecimalMax.message"),
    MUST_BE_IN_RANGE("javax.validation.constraints.Size.message"),

    MUST_BE_IN_PAST("javax.validation.constraints.Past.message"),
    MUST_BE_IN_PAST_OR_PRESENT("javax.validation.constraints.PastOrPresent.message"),
    MUST_BE_PRESENT_OR_IN_FUTURE("javax.validation.constraints.FutureOrPresent.message"),
    MUST_BE_IN_FUTURE("javax.validation.constraints.Future.message"),

    WRONG_NUMBER_OF_DIGITS("javax.validation.constraints.Digits.message"),
    MUST_MATCH_PATTERN("javax.validation.constraints.Pattern.message"),
    WRONG_EMAIL_ADDRESS("javax.validation.constraints.Email.message"),

    INVALID_URL("org.hibernate.validator.constraints.URL.message");

    @Getter
    private String code;
}
