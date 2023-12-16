package com.example.demo.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class R<T> {

    private int code;
    private int total;
    private String message;
    private T data;

    public R(T data) {
        this.code = 200;
        this.message = "success";
        this.data = data;
    }

    public R(T data, int total) {
        this.code = 200;
        this.total = total;
        this.message = "success";
        this.data = data;
    }

    public R(T data, boolean success, String message) {
        if (success) {
            this.code = 200;
            this.message = "success";
        } else {
            this.code = 500;
            this.message = message;
        }
        this.data = data;
    }

    public R(int code, String message) {
        this.code = code;
        this.message = message;
        this.data = null;
    }

    public static <T> R<T> success(T data) {
        return new R<>(data);
    }

    public static <T> R<T> successPage(T data, int total) {
        return new R<>(data, total);
    }

    public static <T> R<T> fail(String message) {
        return new R<>(500, message);
    }

    public static <T> R<T> fail(int code, String message) {
        return new R<>(code, message);
    }
}

