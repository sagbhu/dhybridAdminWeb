package com.dhybrid.admin.request;

public class ProductSlugRequest {

	public String slugName;
	private String state;
	private String id;
	
	public String getSlugName() {
		return slugName;
	}
	public void setSlugName(String slugName) {
		this.slugName = slugName;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
}
