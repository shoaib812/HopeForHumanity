package com.hopeforhumanity.repository;

import com.hopeforhumanity.entity.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsRepository extends JpaRepository<UserDetails, Integer> {
}
