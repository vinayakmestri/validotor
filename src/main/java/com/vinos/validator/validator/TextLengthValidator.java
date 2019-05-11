package com.vinos.validator.validator;

/**
 * Created by Admin on 5/10/2019.
 */

public class TextLengthValidator extends Validator {
    int minSize = 0;

    TextLengthValidator() {

    }

    public TextLengthValidator(int minSize) {
        this.minSize = minSize;
    }

    public TextLengthValidator(int minSize, String errorMessage) {
        this(minSize);
        super.errorMessage = errorMessage;

    }

    @Override
    public boolean validate(String text) {
        if (text.length() < minSize)
            return false;

        return true;
    }

    @Override
    public ErrorCode errorCode() {
        return ErrorCode.LENGTH_SHORT;
    }
}
