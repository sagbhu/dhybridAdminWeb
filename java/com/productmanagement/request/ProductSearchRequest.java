package com.productmanagement.request;

public class ProductSearchRequest {

	private String searchParam;
	private String inStock;
	private String brandName;
	private String slugId;
	private String color;
	private double priceStart;
	private double priceEnd;
	private String availability;
	private int numberOfRecord;
	private int pageNumber;
	private String sortColumnName;
	private String sortOrder;
	
	
	
	public String getSlugId() {
		return slugId;
	}
	public void setSlugId(String slugId) {
		this.slugId = slugId;
	}
	public String getSearchParam() {
		return searchParam;
	}
	public void setSearchParam(String searchParam) {
		this.searchParam = searchParam;
	}
	public String getInStock() {
		return inStock;
	}
	public void setInstock(String inStock) {
		this.inStock = inStock;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public double getPriceStart() {
		return priceStart;
	}
	public void setPriceStart(double priceStart) {
		this.priceStart = priceStart;
	}
	public double getPriceEnd() {
		return priceEnd;
	}
	public void setPriceEnd(int priceEnd) {
		this.priceEnd = priceEnd;
	}
	public String getAvailability() {
		return availability;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}
	public int getNumberOfRecord() {
		return numberOfRecord;
	}
	public void setNumberOfRecord(int numberOfRecord) {
		this.numberOfRecord = numberOfRecord;
	}
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public String getSortColumnName() {
		return sortColumnName;
	}
	public void setSortColumnName(String sortColumnName) {
		this.sortColumnName = sortColumnName;
	}
	public String getSortOrder() {
		return sortOrder;
	}
	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}
	public void setInStock(String inStock) {
		this.inStock = inStock;
	}
		
	
}
