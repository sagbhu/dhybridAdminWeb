package com.productmanagement.request;

public class ProductCategorySyncRequest {
	
	private ProductCategorySyncRequestBody categoryRequestBody;
	private String apiOwner;
	private String apiKey;
	public ProductCategorySyncRequestBody getCategoryRequestBody() {
		return categoryRequestBody;
	}
	public void setCategoryRequestBody(ProductCategorySyncRequestBody categoryRequestBody) {
		this.categoryRequestBody = categoryRequestBody;
	}
	public String getApiOwner() {
		return apiOwner;
	}
	public void setApiOwner(String apiOwner) {
		this.apiOwner = apiOwner;
	}
	public String getApiKey() {
		return apiKey;
	}
	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}
	public ProductCategorySyncRequest(ProductCategorySyncRequestBody categoryRequestBody, String apiOwner, String apiKey) {
		super();
		this.categoryRequestBody = categoryRequestBody;
		this.apiOwner = apiOwner;
		this.apiKey = apiKey;
	}
	public ProductCategorySyncRequest() {
		super();
	}
	
	
}
