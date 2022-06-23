package com.dhybrid.admin.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.dhybrid.admin.request.RoleRequest;
import com.dhybrid.admin.service.RoleService;

@Controller
public class RoleController {

	@Autowired
	RoleService roleService;

	@GetMapping("/roles/list")
	public ResponseEntity<Map<String, Object>> getRoles(@RequestParam(defaultValue = "", required = false) String name,
			@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
		Map<String, Object> response = roleService.getAll(name, page, size);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping("/role/{id}")
	public ResponseEntity<Map<String, Object>> getRoleById(@PathVariable("id") String id) {
		return new ResponseEntity<>(roleService.get(id), HttpStatus.OK);

	}

	@PostMapping("/role")
	public ResponseEntity<Map<String, Object>> createRole(@RequestBody RoleRequest request) {
		Map<String, Object> response = roleService.createUpdate(request);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PutMapping("/role")
	public ResponseEntity<Map<String, Object>> updateRole(@RequestBody RoleRequest request) {
		Map<String, Object> response = roleService.createUpdate(request);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@DeleteMapping("/role/{id}")
	public ResponseEntity<Map<String, Object>> deleteRole(@PathVariable(required = true) String id) {
		Map<String, Object> response = roleService.delete(id);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
