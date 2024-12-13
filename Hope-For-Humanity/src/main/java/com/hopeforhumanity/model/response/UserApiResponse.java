package com.hopeforhumanity.model.response;

import org.springframework.http.HttpStatus;

public class UserApiResponse<T> {

    private HttpStatus status;
    private String code;
    private String message;
    private T data;

    public String getCode() {
        return code;
    }

    public void setCode(String errorCode) {
        this.code = errorCode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
