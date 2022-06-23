package com.productmanagement.response;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SkuList{
	private String createDateText;
	private String modifiedDateText;
	private ArrayList<Object> searchList;
	private String skuCode;
	private String uId;
	private String displaySKUCode;
	private String skuName;
	private String skuClassification;
	private String skuClassificationText;
	private String styleSKUCode;
	private String approveStatus;
	private String approveStatusText;
	private String productStatus;
	private String productStatusText;
	private int imgCount;
	private String brand;
	private String brandText;
	private String merchId;
	private String merchIdText;
	private String skuImgUrl1;
	private double msrp;
	private double basePrice;
	private double height;
	private double width;
	private double weight;
	private double length;
	private CatAtribMap catAtribMap;
	private String hsnCode;
	private String variationTheme;
	private String color;
	private boolean noLimit;
	private double salePrice;
	private boolean folderWiseImageDownload;
	private String size;
	
    public String getCreateDateText() {
		return createDateText;
	}
	public void setCreateDateText(String createDateText) {
		this.createDateText = createDateText;
	}
	public String getModifiedDateText() {
		return modifiedDateText;
	}
	public void setModifiedDateText(String modifiedDateText) {
		this.modifiedDateText = modifiedDateText;
	}
	public ArrayList<Object> getSearchList() {
		return searchList;
	}
	public void setSearchList(ArrayList<Object> searchList) {
		this.searchList = searchList;
	}
	public String getSkuCode() {
		return skuCode;
	}
	public void setSkuCode(String skuCode) {
		this.skuCode = skuCode;
	}
	public String getuId() {
		return uId;
	}
	public void setuId(String uId) {
		this.uId = uId;
	}
	public String getDisplaySKUCode() {
		return displaySKUCode;
	}
	public void setDisplaySKUCode(String displaySKUCode) {
		this.displaySKUCode = displaySKUCode;
	}
	public String getSkuName() {
		return skuName;
	}
	public void setSkuName(String skuName) {
		this.skuName = skuName;
	}
	public String getSkuClassification() {
		return skuClassification;
	}
	public void setSkuClassification(String skuClassification) {
		this.skuClassification = skuClassification;
	}
	public String getSkuClassificationText() {
		return skuClassificationText;
	}
	public void setSkuClassificationText(String skuClassificationText) {
		this.skuClassificationText = skuClassificationText;
	}
	public String getStyleSKUCode() {
		return styleSKUCode;
	}
	public void setStyleSKUCode(String styleSKUCode) {
		this.styleSKUCode = styleSKUCode;
	}
	public String getApproveStatus() {
		return approveStatus;
	}
	public void setApproveStatus(String approveStatus) {
		this.approveStatus = approveStatus;
	}
	public String getApproveStatusText() {
		return approveStatusText;
	}
	public void setApproveStatusText(String approveStatusText) {
		this.approveStatusText = approveStatusText;
	}
	public String getProductStatus() {
		return productStatus;
	}
	public void setProductStatus(String productStatus) {
		this.productStatus = productStatus;
	}
	public String getProductStatusText() {
		return productStatusText;
	}
	public void setProductStatusText(String productStatusText) {
		this.productStatusText = productStatusText;
	}
	public int getImgCount() {
		return imgCount;
	}
	public void setImgCount(int imgCount) {
		this.imgCount = imgCount;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getBrandText() {
		return brandText;
	}
	public void setBrandText(String brandText) {
		this.brandText = brandText;
	}
	public String getMerchId() {
		return merchId;
	}
	public void setMerchId(String merchId) {
		this.merchId = merchId;
	}
	public String getMerchIdText() {
		return merchIdText;
	}
	public void setMerchIdText(String merchIdText) {
		this.merchIdText = merchIdText;
	}
	public String getSkuImgUrl1() {
		return skuImgUrl1;
	}
	public void setSkuImgUrl1(String skuImgUrl1) {
		this.skuImgUrl1 = skuImgUrl1;
	}
	

	public double getMsrp() {
		return msrp;
	}
	public void setMsrp(double msrp) {
		this.msrp = msrp;
	}
	public double getBasePrice() {
		return basePrice;
	}
	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public double getLength() {
		return length;
	}
	
	public double getSalePrice() {
		return salePrice;
	}
	public void setLength(double length) {
		this.length = length;
	}
	public void setSalePrice(double salePrice) {
		this.salePrice = salePrice;
	}
	public CatAtribMap getCatAtribMap() {
		return catAtribMap;
	}
	public void setCatAtribMap(CatAtribMap catAtribMap) {
		this.catAtribMap = catAtribMap;
	}
	public String getHsnCode() {
		return hsnCode;
	}
	public void setHsnCode(String hsnCode) {
		this.hsnCode = hsnCode;
	}
	public String getVariationTheme() {
		return variationTheme;
	}
	public void setVariationTheme(String variationTheme) {
		this.variationTheme = variationTheme;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public boolean isNoLimit() {
		return noLimit;
	}
	public void setNoLimit(boolean noLimit) {
		this.noLimit = noLimit;
	}
	
	public boolean isFolderWiseImageDownload() {
		return folderWiseImageDownload;
	}
	public void setFolderWiseImageDownload(boolean folderWiseImageDownload) {
		this.folderWiseImageDownload = folderWiseImageDownload;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	
	
}
