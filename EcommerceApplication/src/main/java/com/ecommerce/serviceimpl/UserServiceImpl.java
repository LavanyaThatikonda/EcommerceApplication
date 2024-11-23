package com.ecommerce.serviceimpl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.entity.User;
import com.ecommerce.repository.UserRepository;
import com.ecommerce.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
    
	 @Override
	    public User registerUser(User user) {
	        return userRepository.save(user); // Save and return the newly registered user
	    }

	    @Override
	    public User getUserById(Long id) {
	        // Fetch user by ID, throw exception if not found
	        return userRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
	    }

	    @Override
	    public User updateUserById(Long id, User user) {
	        // Fetch existing user by ID
	        User existingUser = userRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));

	        // Update user fields
	        existingUser.setFirstName(user.getFirstName());
	        existingUser.setLastName(user.getLastName());
	        existingUser.setEmail(user.getEmail());
	        existingUser.setPassword(user.getPassword());
	        existingUser.setRole(user.getRole());
	        existingUser.setStatus(user.getStatus());
	        existingUser.setPhoneNumber(user.getPhoneNumber());

	        // Save and return the updated user
	        return userRepository.save(existingUser);
	    }

	    @Override
	    public void deleteUserById(Long id) {
	        // Fetch user by ID and throw exception if not found
	        User user = userRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));

	        // Delete the user
	        userRepository.deleteById(id);
	    }

	    @Override
	    public List<User> getAllUsers() {
	        // Fetch and return all users
	        return userRepository.findAll();
	    }
	}
   
  



