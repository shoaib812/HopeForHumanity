package com.hopeforhumanity.controller;

import com.hopeforhumanity.entity.UserDetails;
import com.hopeforhumanity.model.request.UserDetailsPostRequest;
import com.hopeforhumanity.model.request.UserDetailsPutRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

public interface UserDetailsControllerApi {

    @PostMapping("/add")
    ResponseEntity<?> createuserDetail(@RequestBody UserDetailsPostRequest userDetailsPostRequest);

//    public UserDetails createuserDetail(@RequestBody UserDetails userDetails);

    @GetMapping("/{id}")
    public ResponseEntity<Optional<UserDetails>> getSingleUserDetails(@PathVariable Integer id);

    @GetMapping("/allUsers")
    public ResponseEntity<List<UserDetails>> getAllUserDetails();

    @DeleteMapping("/deleteUser")
    public ResponseEntity<?> delete(@RequestParam(value = "id") Integer id);

    @PutMapping("/updateUser")
    public ResponseEntity<?> update(@RequestBody UserDetailsPutRequest userDetailsPutRequest,
                                    @RequestParam("id") Integer id);
}