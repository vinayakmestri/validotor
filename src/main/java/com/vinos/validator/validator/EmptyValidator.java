package com.vinos.validator.validator;

/**
 * Created by Admin on 5/10/2019.
 */

public class EmptyValidator extends Validator {
    public EmptyValidator() {
    }

    public EmptyValidator(String errorMessage) {
        super.errorMessage = errorMessage;
    }

    @Override
    public boolean validate(String text) {
        return !text.isEmpty();
    }

    @Override
    public ErrorCode errorCode() {
        return ErrorCode.EMPTY;
    }
}
