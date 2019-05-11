package com.vinos.validator.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Admin on 5/10/2019.
 */

public class EmailValidator extends Validator {
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public EmailValidator() {

    }

    public EmailValidator(String errorMessage) {
        super.errorMessage = errorMessage;
    }

    @Override
    public boolean validate(String email) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
        return matcher.find();
    }

    @Override
    public ErrorCode errorCode() {
        return ErrorCode.INVALID_EMAIL;
    }

}
