package com.kiddz.elysium.web.response;

import com.kiddz.elysium.web.constant.Status;

import java.io.Serializable;

public class Result<T> implements Serializable {

    private int code;

    private String message;

    private T data;

    private Result(Status status, String message, T data) {
        this.code = status.getCode();
        this.message = message;
        this.data = data;
    }

    private Result(Status status, String message) {
        this.code = status.getCode();
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    public static <T> Result<T> success(T data) {
        return new Result<>(Status.SUCCESS, "", data);
    }

    public static Result error(String message) {
        return new Result(Status.ERROR, message);
    }

    public static Result other(Status status, String message) {
        return new Result(status, message);
    }
}
