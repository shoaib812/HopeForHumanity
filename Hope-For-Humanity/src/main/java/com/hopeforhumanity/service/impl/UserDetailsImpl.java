package com.hopeforhumanity.service.impl;

import com.hopeforhumanity.entity.UserDetails;
import com.hopeforhumanity.model.request.UserDetailsPostRequest;
import com.hopeforhumanity.model.request.UserDetailsPutRequest;
import com.hopeforhumanity.repository.UserDetailsRepository;
import com.hopeforhumanity.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserDetailsImpl implements UserDetailsService {

    @Autowired
    UserDetailsRepository userDetailsRepository;

    @Override
    public UserDetails getById(Integer id) {
        Optional<UserDetails> optUser = userDetailsRepository.findById(id);
//        if(!optUser.isPresent()) {
//            throw new MyCustomException(Constants.USER_NOT_FOUND, ApiCodes.NOT_FOUND, HttpStatus.NOT_FOUND)
//        }
       // return userDetailsRepository.findById(id);
        return optUser.get();
    }

    @Override
    public List<UserDetails> getAll() {
        return userDetailsRepository.findAll();
    }
    
    @Override
    public UserDetails save(UserDetailsPostRequest userDetailsPostRequest) {
        UserDetails userDetails = new UserDetails();
        userDetails.setFirstName(userDetailsPostRequest.getFirstName());
        userDetails.setLastName(userDetailsPostRequest.getLastName());
        userDetails.setPhoneNumber(userDetailsPostRequest.getPhoneNumber());
        userDetails.setEmailId(userDetailsPostRequest.getEmailId());
        userDetails.setStreetAddress(userDetailsPostRequest.getStreetAddress());
        userDetails.setCity(userDetailsPostRequest.getCity());
        userDetails.setCountry(userDetailsPostRequest.getCountry());
        userDetails.setAmount(userDetailsPostRequest.getAmount());
        userDetails.setMessage(userDetailsPostRequest.getMessage());

        return userDetailsRepository.save(userDetails);
    }

    public void deleteUser(Integer id) {
        if(getById(id) != null) {
            userDetailsRepository.deleteById(id);
        }
//        else {
//            System.out.println(" The id is not present... ");
//        }
    }

    public UserDetails updateUser(UserDetailsPutRequest userDetailsPutRequest, Integer id) {
        UserDetails currentUser = getById(id);

        if (currentUser != null) {
            currentUser.setId(id);

            if (userDetailsPutRequest.getFirstName() != null) {
                currentUser.setFirstName(userDetailsPutRequest.getFirstName());
            }
            if (userDetailsPutRequest.getLastName() != null) {
                currentUser.setLastName(userDetailsPutRequest.getLastName());
            }
            if (userDetailsPutRequest.getPhoneNumber() != null) {
                currentUser.setPhoneNumber(userDetailsPutRequest.getPhoneNumber());
            }
            if (userDetailsPutRequest.getEmailId() != null) {
                currentUser.setEmailId(userDetailsPutRequest.getEmailId());
            }
            if (userDetailsPutRequest.getStreetAddress() != null) {
                currentUser.setStreetAddress(userDetailsPutRequest.getStreetAddress());
            }
            if (userDetailsPutRequest.getCity() != null) {
                currentUser.setCity(userDetailsPutRequest.getCity());
            }
            if (userDetailsPutRequest.getCountry() != null) {
                currentUser.setCountry(userDetailsPutRequest.getCountry());
            }
            if (userDetailsPutRequest.getAmount() != null) {
                currentUser.setAmount(userDetailsPutRequest.getAmount());
            }
            if (userDetailsPutRequest.getMessage() != null) {
                currentUser.setMessage(userDetailsPutRequest.getMessage());
            }
            currentUser = userDetailsRepository.save(currentUser);
        }
        return currentUser;
    }
}
