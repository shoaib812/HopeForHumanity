package com.hopeforhumanity.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDetailsPutRequest {

    private String firstName;
    private String lastName;
    private Long phoneNumber;
    private String emailId;
    private String streetAddress;
    private String city;
    private String country;
    private Double amount;
    private String message;
}
