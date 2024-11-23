package com.ecommerce.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.entity.User;
import com.ecommerce.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	 @PostMapping("/register")
	    public ResponseEntity<User> registerUser(@RequestBody User user) {
	        return ResponseEntity.ok(userService.registerUser(user));
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<User> getUserById(@PathVariable Long id) {
	        return ResponseEntity.ok(userService.getUserById(id));
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<User> updateUserById(@PathVariable Long id, @RequestBody User user) {
	        return ResponseEntity.ok(userService.updateUserById(id, user));
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteUserById(@PathVariable Long id) {
	        userService.deleteUserById(id);
	        return ResponseEntity.noContent().build();
	    }

	    @GetMapping
	    public ResponseEntity<List<User>> getAllUsers() {
	        return ResponseEntity.ok(userService.getAllUsers());
	    }

}
