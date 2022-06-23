package com.productmanagement.response;

import java.util.ArrayList;

public class ProductCategoryResponse {

	private int responseCode;
	private String responseMessage;
	private int currentPage;
	private ArrayList<SkuCategoryList> skuCategoryList;
	public int getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}
	public String getResponseMessage() {
		return responseMessage;
	}
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public ArrayList<SkuCategoryList> getSkuCategoryList() {
		return skuCategoryList;
	}
	public void setSkuCategoryList(ArrayList<SkuCategoryList> skuCategoryList) {
		this.skuCategoryList = skuCategoryList;
	}
	@Override
	public String toString() {
		return "ProductCategoryResponse [responseCode=" + responseCode + ", responseMessage=" + responseMessage
				+ ", currentPage=" + currentPage + ", skuCategoryList=" + skuCategoryList + "]";
	}
	
	

}