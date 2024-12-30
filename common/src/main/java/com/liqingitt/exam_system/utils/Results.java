package com.liqingitt.exam_system.utils;

import lombok.Data;

@Data
public class Results<T> {
    private Integer code;
    private String message;
    private T data;

    private Results(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> Results<T> success() {
        return new Results<>(200, "操作成功", null);
    }

    public static <T> Results<T> success(T data) {
        return new Results<>(200, "操作成功", data);
    }

    public static <T> Results<T> success(String message, T data) {
        return new Results<>(200, message, data);
    }

    public static <T> Results<T> error() {
        return new Results<>(500, "操作失败", null);
    }

    public static <T> Results<T> error(String message) {
        return new Results<>(500, message, null);
    }

    public static <T> Results<T> error(Integer code, String message) {
        return new Results<>(code, message, null);
    }
}
