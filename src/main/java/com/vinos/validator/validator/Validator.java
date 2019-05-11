package com.vinos.validator.validator;

/**
 * Created by Admin on 5/10/2019.
 */

public abstract class Validator {
    String errorMessage = "";

    public boolean validate(String text) {
        return false;
    }

    public ErrorCode errorCode() {
        return ErrorCode.NO_ERROR;
    }

    public String errorMessage() {
        return errorMessage;
    }
}
