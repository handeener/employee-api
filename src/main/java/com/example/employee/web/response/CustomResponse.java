package com.example.employee.web.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomResponse<T> {

    private T data;
    private String message;
    private int statusCode;
    private boolean success;

    public CustomResponse(boolean success, T data, String message, int statusCode) {
        this.success = success;
        this.data = data;
        this.message = message;
        this.statusCode = statusCode;
    }
    public CustomResponse(boolean success, String message, int statusCode) {
        this(success,null, message, statusCode);
    }
    public CustomResponse() {
        this(true, null, "success", 200);
    }
    public static <T> CustomResponse<T> success(T data) {
        return new CustomResponse<>(true, data, "success", 200);
    }

    public static <T> CustomResponse<T> error(String message, int statusCode) {
        return new CustomResponse<>(false,null, message, statusCode);
    }

}
