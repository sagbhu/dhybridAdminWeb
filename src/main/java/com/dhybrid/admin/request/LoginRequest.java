package com.dhybrid.admin.request;

import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;

public class LoginRequest {
	private String username;
	private String password;
	private HttpSession session;
	private ModelMap modelMap;

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the session
	 */
	public HttpSession getSession() {
		return session;
	}

	/**
	 * @param session the session to set
	 */
	public void setSession(HttpSession session) {
		this.session = session;
	}

	/**
	 * @return the modelMap
	 */
	public ModelMap getModelMap() {
		return modelMap;
	}

	/**
	 * @param modelMap the modelMap to set
	 */
	public void setModelMap(ModelMap modelMap) {
		this.modelMap = modelMap;
	}

}
