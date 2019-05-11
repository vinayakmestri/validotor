package com.vinos.validator.validator;

public abstract class ValidationCallBack {
    public abstract void onSuccess(String username, String password);

    public void onError(int id, ErrorCode errorCode) {
    }

    public void onError(int id, String errorCode) {

    }
}