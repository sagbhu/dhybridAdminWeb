package com.dhybrid.admin.controller;

import java.util.List;
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
import org.springframework.web.multipart.MultipartFile;

import com.dhybrid.admin.request.BlogRequest;
import com.dhybrid.admin.service.BlogService;
import com.dhybrid.admin.utils.AWSUtil;

@Controller
public class BlogController {

	@Autowired
	BlogService blogService;

	@GetMapping("/blogs/list")
	public ResponseEntity<Map<String, Object>> getBlogs(@RequestParam(defaultValue = "", required = false) String search,@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size) {
		Map<String, Object> response = blogService.getAll(search,page, size);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	
	@GetMapping("/blogs/{id}")
	public ResponseEntity<Map<String, Object>> getBlogById(@PathVariable String id) {
		Map<String, Object> mapobj=blogService.getById(id);
		return new ResponseEntity<>(mapobj, HttpStatus.OK);
	}
	
	@PostMapping("/blogs")
	public ResponseEntity<Map<String, Object>> addBlogs(@RequestBody BlogRequest blogRequest) {
		Map<String, Object> response = blogService.addUpdate(blogRequest);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PutMapping("/blogs")
	public ResponseEntity<Map<String, Object>> updateBlogs(@RequestBody BlogRequest blogRequest) {
		Map<String, Object> response = blogService.addUpdate(blogRequest);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@DeleteMapping("/blogs/{id}")
	public ResponseEntity<Map<String, Object>> deleteBlog(@PathVariable String id) {
		Map<String, Object> response = blogService.delete(id);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping("/getBlogCategories")
	public ResponseEntity<String> getBlogCategories() {
		String response = blogService.getBlogCategories();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PostMapping("/uploadFiles")
	public ResponseEntity<String> uploadFiles(@RequestParam List<MultipartFile> blogFiles,@RequestParam String id) {
		String response =blogService.uploadFiles(blogFiles, id);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
