package com.dhybrid.admin.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.dhybrid.admin.request.UserRequest;
import com.dhybrid.admin.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping("/users/list")
	public ResponseEntity<Map<String, Object>> getUsers(@RequestParam(defaultValue = "", required = false) String name,
			@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
		Map<String, Object> response = userService.getAll(name, page, size);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping("/user/{id}")
	public ResponseEntity<Map<String, Object>> getUserById(@RequestParam(required = true) String id) {
		Map<String, Object> response = userService.get(id);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PostMapping("/user")
	public ResponseEntity<Map<String, Object>> createUser(@RequestBody UserRequest request) {
		Map<String, Object> response = userService.createUpdate(request);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PutMapping("/user")
	public ResponseEntity<Map<String, Object>> updateBlogs(@RequestBody UserRequest request) {
		Map<String, Object> response = userService.createUpdate(request);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@DeleteMapping("/user")
	public ResponseEntity<Map<String, Object>> deleteBlog(@RequestParam(required = true) String id) {
		Map<String, Object> response = userService.delete(id);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
