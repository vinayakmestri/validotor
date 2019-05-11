package com.vinos.validator.validator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 5/10/2019.
 */

public class ValidationBuilder {
    private List<Validator> validators;

    public ValidationBuilder() {
        validators = new ArrayList<>();
    }

    public ValidationBuilder add(Validator validator) {
        if (validators != null) {
            if (validator instanceof EmptyValidator) {
                validators.add(0, validator);
                return this;
            }
            validators.add(validator);
        }
        return this;
    }

    public List<Validator> getValidators() {
        return validators;
    }

    public boolean isEmpty() {
        return validators.isEmpty();
    }
}
