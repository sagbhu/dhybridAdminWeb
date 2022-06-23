package com.dhybrid.admin.request;

public class AuthenticationResponseDto {
	private final String jwtToken;

	public AuthenticationResponseDto(String jwtToken) {
		super();
		this.jwtToken = jwtToken;
	}

	public String getJwtToken() {
		return jwtToken;
	}
	
}
