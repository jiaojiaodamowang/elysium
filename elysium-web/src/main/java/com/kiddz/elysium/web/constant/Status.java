package com.kiddz.elysium.web.constant;

public enum Status {

    SUCCESS(1001),

    ERROR(1002);

    Status(int code) {
        this.code = code;
    }

    private int code;

    public int getCode() {
        return this.code;
    }
}
