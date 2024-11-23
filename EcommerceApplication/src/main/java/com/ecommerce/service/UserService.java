package com.ecommerce.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ecommerce.entity.User;

@Component
public interface UserService {
	
	User registerUser(User user);

    User getUserById(Long id); // Changed to Long

    User updateUserById(Long id, User user); // Changed to Long

    void deleteUserById(Long id); // Changed to Long

    List<User> getAllUsers();
	
	

}
