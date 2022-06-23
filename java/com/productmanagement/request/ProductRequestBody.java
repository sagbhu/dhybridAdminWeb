package com.productmanagement.request;

import java.util.List;

public class ProductRequestBody {
	private String pageNumber;
	private String pageSize;
	private List<String> displaySkuList;
	private String fromDate;
	private String toDate;

	public String getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(String pageNumber) {
		this.pageNumber = pageNumber;
	}

	public String getPageSize() {
		return pageSize;
	}

	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}

	public List<String> getDisplaySkuList() {
		return displaySkuList;
	}

	public void setDisplaySkuList(List<String> displaySkuList) {
		this.displaySkuList = displaySkuList;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
}
