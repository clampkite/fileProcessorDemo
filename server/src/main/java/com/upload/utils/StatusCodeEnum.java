package com.upload.utils;

public enum StatusCodeEnum {
    SUCCESS(200),
    FAIL(404);

    private int statusCode;

    StatusCodeEnum(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusCode() {
        return String.valueOf(statusCode);
    }
}
