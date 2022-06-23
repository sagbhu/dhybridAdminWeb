package com.dhybrid.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dhybrid.admin.request.Content;
import com.dhybrid.admin.service.ContentService;

@RestController
public class ContentController {

	@Autowired
	private ContentService contentService;

	@GetMapping("/content")
	public ResponseEntity<List<Content>> getContent() {
		List<Content> contentObj = contentService.getContent();
		return new ResponseEntity<>(contentObj, HttpStatus.OK);
	}

}
