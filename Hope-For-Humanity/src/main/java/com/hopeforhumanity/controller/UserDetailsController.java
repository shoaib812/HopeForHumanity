package com.hopeforhumanity.controller;

import com.hopeforhumanity.entity.UserDetails;
import com.hopeforhumanity.helper.ResponseProvider;
import com.hopeforhumanity.model.request.UserDetailsPostRequest;
import com.hopeforhumanity.model.request.UserDetailsPutRequest;
import com.hopeforhumanity.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/userDetails")
public class UserDetailsController implements UserDetailsControllerApi {

    @Autowired
    UserDetailsService userDetailsService;

    @Override
    public ResponseEntity<?> createuserDetail(@RequestBody UserDetailsPostRequest userDetailsPostRequest) {
        //return ResponseEntity.status(HttpStatus.CREATED).body(userDetailsService.save(userDetails)).getBody();

        UserDetails userDetails = userDetailsService.save(userDetailsPostRequest);
        return ResponseProvider.success(userDetails);
        //return userDetailsResponse;
    }

    @Override
    public ResponseEntity<Optional<UserDetails>> getSingleUserDetails(Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(Optional.ofNullable(userDetailsService.getById(id)));
    }

    @Override
    public ResponseEntity<List<UserDetails>> getAllUserDetails() {
        return ResponseEntity.ok(userDetailsService.getAll());
    }

    @Override
    public ResponseEntity<?> delete(@RequestParam(value = "id") Integer id)
    {
        userDetailsService.deleteUser(id);
        return ResponseProvider.success("");
    }

    @Override
    public ResponseEntity<?> update(@RequestBody UserDetailsPutRequest userDetailsPutRequest,
                                    @RequestParam("id") Integer id){
        UserDetails userDetails =  userDetailsService.updateUser(userDetailsPutRequest, id);
        return ResponseProvider.success(userDetails);
    }
}
