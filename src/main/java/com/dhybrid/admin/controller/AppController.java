package com.dhybrid.admin.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dhybrid.admin.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.usermanagement.reponse.ApplicationResponse;
import com.usermanagement.reponse.UserResponse;

@Controller
public class AppController {

	@Autowired
	UserService userService;

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/login")
	public String renderLogin(Model model, String error, String logout) {
		if (error != null)
			model.addAttribute("error", "Your username and password is invalid.");

		if (logout != null)
			model.addAttribute("message", "You have been logged out successfully.");

		return "login";
	}

	@GetMapping("/createUser")
	public String createUser(Model model, String error, String logout) {
		return "user";
	}

	@GetMapping({ "/", "/welcome" })
	public String welcome(Model model) {
		return "login";
	}

	@GetMapping("/dashboard")
	public String renderDashboard() {
		return "dashboard";
	}

	@GetMapping("users")
	public String renderloadUser(String users) {
		return "users";
	}

	@GetMapping("roles")
	public String renderloadRoles() {
		return "roles";
	}

	@GetMapping("blogs")
	public String renderloadBlogs() {
		return "blogs";
	}

	@PostMapping("/login")
	public String loginUser(@RequestParam("username") String username, @RequestParam("password") String password,
			HttpSession session, ModelMap modelMap) {
		Object sessionValue = session.getAttribute(username);
		ObjectMapper mapper = new ObjectMapper();
		UserResponse userResponse = null;
		ApplicationResponse applicationResponse = userService.login(username, password);
		try {
			if(null != applicationResponse) {
				userResponse = mapper.readValue(mapper.writeValueAsString(applicationResponse.getData()),
					UserResponse.class);
			}
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		if (null != applicationResponse && applicationResponse.isStatus()) {
			session.setAttribute("username", username);
			session.setAttribute("fullName", userResponse.getFullName());
			session.setAttribute("CSRFToken", userResponse.getJwtToken());
			return "dashboard";
		}
		modelMap.put("error", "Invalid email or password");
		return "login";
	}
}
