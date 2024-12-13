package com.hopeforhumanity.helper;

import com.hopeforhumanity.model.response.UserApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.hopeforhumanity.constants.ApiCodes;

public class ResponseProvider {

    public static ResponseEntity<?> success(Object data) {
        UserApiResponse userApiResponse = new UserApiResponse<>();
        userApiResponse.setStatus(HttpStatus.OK);
        userApiResponse.setCode(ApiCodes.SUCCESS);
        userApiResponse.setData(data);

        return new ResponseEntity<UserApiResponse<?>>(userApiResponse, HttpStatus.OK);
    }

    public static ResponseEntity<Object> fail(HttpStatus status, String errorCode, String message) {
        UserApiResponse response = new UserApiResponse();
        response.setStatus(status);
        response.setCode(errorCode);
        response.setMessage(message);
        return new ResponseEntity<>(response, status);
    }
}
