package com.vinos.validator.builder;

import android.widget.EditText;

import com.vinos.validator.validator.EmailValidator;
import com.vinos.validator.validator.EmptyValidator;
import com.vinos.validator.validator.ErrorCode;
import com.vinos.validator.validator.TextLengthValidator;
import com.vinos.validator.validator.ValidationBuilder;
import com.vinos.validator.validator.ValidationCallBack;
import com.vinos.validator.validator.Validator;

import java.util.List;


/**
 * Created by Admin on 5/10/2019.
 */

public class LoginBuilder {
    private static LoginBuilder loginBuilder;
    EditText username, password;
    ValidationBuilder usernameValidationBuilder;
    ValidationBuilder passwordValidationBuilder;

    public static LoginBuilder getInstance() {
        if (loginBuilder == null) {
            loginBuilder = new LoginBuilder();
        }
        return loginBuilder;
    }

    LoginBuilder setUsernameField(EditText username) {
        this.username = username;
        return this;
    }

    LoginBuilder setPasswordField(EditText password) {
        this.password = password;
        return this;
    }

    public LoginBuilder addUserNameValidations(ValidationBuilder usernameValidationBuilder) {
        this.usernameValidationBuilder = usernameValidationBuilder;
        return this;
    }

    public List<Validator> getUserNameValidations() {
        return usernameValidationBuilder.getValidators();
    }

    public List<Validator> getPasswordValidations() {
        return passwordValidationBuilder.getValidators();
    }

    public LoginBuilder addPasswordValidations(ValidationBuilder passwordValidationBuilder) {
        this.passwordValidationBuilder = passwordValidationBuilder;
        return this;
    }

    public LoginBuilder build() {
        return this;
    }

    public LoginBuilder setCallBack(ValidationCallBack validationCallBack) {
        this.validationCallBack = validationCallBack;
        return this;
    }

    public void login() {
        validate();
    }

    public void validate() {
        if (username == null) {
            validationCallBack.onError(-1, ErrorCode.USERNAME_NULL);
            return;
        }
        if (password == null) {
            validationCallBack.onError(-1, ErrorCode.PASSWORD_NULL);
            return;
        }

        if (usernameValidationBuilder != null && !usernameValidationBuilder.isEmpty()) {
            for (Validator validator : usernameValidationBuilder.getValidators()) {
                if (!checkValidation(validator, username.getText().toString().trim())) {
                    if (validationCallBack != null) {
                        validationCallBack.onError(username.getId(), validator.errorCode());
                        validationCallBack.onError(username.getId(), validator.errorMessage());
                        return;
                    }
                }
            }

        }
        if (passwordValidationBuilder != null && !passwordValidationBuilder.isEmpty()) {
            for (Validator validator : passwordValidationBuilder.getValidators()) {
                if (!checkValidation(validator, password.getText().toString().trim())) {
                    if (validationCallBack != null) {
                        validationCallBack.onError(password.getId(), validator.errorCode());
                        validationCallBack.onError(password.getId(), validator.errorMessage());
                        return;
                    }
                }
            }

        }
        validationCallBack.onSuccess(username.getText().toString().trim(), password.getText().toString().trim());
    }

    private boolean checkValidation(Validator validator, String text) {
        if (validator instanceof EmptyValidator) {
            return validator.validate(text);
        } else if (validator instanceof TextLengthValidator) {
            return validator.validate(text);
        } else if (validator instanceof EmailValidator) {
            return validator.validate(text);
        } else if (validator instanceof EmptyValidator) {
            return validator.validate(text);
        } else {
            return true;
        }
    }

    ValidationCallBack validationCallBack;


}