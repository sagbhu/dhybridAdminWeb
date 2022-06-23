package com.productmanagement.request;

public class ProductCategorySearchRequest {
	
	private String merchName;
	private String parentMerchCode;
	public String getMerchName() {
		return merchName;
	}
	public void setMerchName(String merchName) {
		this.merchName = merchName;
	}
	public String getParentMerchCode() {
		return parentMerchCode;
	}
	public void setParentMerchCode(String parentMerchCode) {
		this.parentMerchCode = parentMerchCode;
	}
	
	
}
