package com.productmanagement.response;

import java.util.List;

import com.productmanagement.model.Product;

public class ProductSearchResponse {

	private Long count;
	private List<Product> productList;
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public List<Product> getProductList() {
		return productList;
	}
	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}
	
	
	
}
