package com.productmanagement.request;

public class ProductSyncRequest {
	private ProductRequestBody productRequestBody;
	private String apiOwner;
	private String apiKey;
	private boolean flag;
	
	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public ProductRequestBody getProductRequestBody() {
		return productRequestBody;
	}

	public void setProductRequestBody(ProductRequestBody productRequestBody) {
		this.productRequestBody = productRequestBody;
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
	
	
}
