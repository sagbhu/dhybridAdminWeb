package com.productmanagement.request;

import java.util.List;

public class ProductCategorySyncRequestBody {
	
	private List<String> merchId;
	private String extMerchCode;
	private List<String>merchName;
	private String parentMerchCode;
	private String fromDate;
	private String toDate;
	private String pageNumber;
	private String filterBy;
	
	public List<String> getMerchId() {
		return merchId;
	}
	public void setMerchId(List<String> merchId) {
		this.merchId = merchId;
	}
	public String getExtMerchCode() {
		return extMerchCode;
	}
	public void setExtMerchCode(String extMerchCode) {
		this.extMerchCode = extMerchCode;
	}
	public List<String> getMerchName() {
		return merchName;
	}
	public void setMerchName(List<String> merchName) {
		this.merchName = merchName;
	}
	public String getParentMerchCode() {
		return parentMerchCode;
	}
	public void setParentMerchCode(String parentMerchCode) {
		this.parentMerchCode = parentMerchCode;
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
	public String getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(String pageNumber) {
		this.pageNumber = pageNumber;
	}
	public String getFilterBy() {
		return filterBy;
	}
	public void setFilterBy(String filterBy) {
		this.filterBy = filterBy;
	}
	public ProductCategorySyncRequestBody(List<String> merchId, String extMerchCode, List<String> merchName,
			String parentMerchCode, String fromDate, String toDate, String pageNumber, String filterBy) {
		super();
		this.merchId = merchId;
		this.extMerchCode = extMerchCode;
		this.merchName = merchName;
		this.parentMerchCode = parentMerchCode;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.pageNumber = pageNumber;
		this.filterBy = filterBy;
	}
	public ProductCategorySyncRequestBody() {
		super();
	}	

	
}
