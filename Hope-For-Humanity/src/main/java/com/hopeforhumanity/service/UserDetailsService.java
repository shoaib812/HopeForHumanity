package com.hopeforhumanity.service;

import com.hopeforhumanity.entity.UserDetails;
import com.hopeforhumanity.model.request.UserDetailsPostRequest;
import com.hopeforhumanity.model.request.UserDetailsPutRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface UserDetailsService {

    public UserDetails getById(Integer id);

    public List<UserDetails> getAll();

    public UserDetails save(UserDetailsPostRequest userDetailsPostRequest);

    public void deleteUser(Integer id);

    public UserDetails updateUser(UserDetailsPutRequest userDetailsPutRequest, Integer id);

}
