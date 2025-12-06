package com.example.employee.web.response;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class CustomResponse<T> {

    private T data;
    private String message;
    private int status;
    private boolean success;

    public CustomResponse(boolean success, T data, String message, int status) {
        this.success = success;
        this.data = data;
        this.message = message;
        this.status = status;
    }
    public CustomResponse(boolean success, String message, int status) {
        this(success,null, message, status);
    }
    public CustomResponse() {
        this(true, null, "success", 200);
    }
    public static <T> CustomResponse<T> success(T data) {
        return new CustomResponse<>(true, data, "success", 200);
    }

    public static <T> CustomResponse<T> error(String message, int status) {
        return new CustomResponse<>(false,null, message, status);
    }

}
