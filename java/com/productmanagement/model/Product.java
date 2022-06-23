package com.productmanagement.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Product {

	@Id
	private String skuCode;
	private String skuName;
	private String skuClassification;
	private String style;
	private String isApproved;
	private String isActive;
	private String productStatus;
	private String brandName;
	private String color;
	private double mrp;
	private double salePrice;
	private double baseCost;
	private double packageWidth;
	private double packageHeight;
	private double packageLength;
	private double packageWeight;
	private String description;
	private String productDetails;
	private String productImagesVideo;
	private String productParameters;
	private String productCategory;
	private String taxCode;
	private String importerDetails;
	private String manufacturerDetails;
	private String packerDetails;
	private String listingDate;
	private String updateDate;
	private String userId;

	@DBRef
	private List<ProductSlug> slug;
	@DBRef
	private ProductLabel label;
	private String intro;
	private String byLine;
	private String desc;
	private String aboutTheBrand;
	private String serviceCode;
	private List<String> keyword;
	private List<String> mixedFile;
	private String file3d;

//	@
//	private String totalRecords;

	public String getSkuCode() {
		return skuCode;
	}

	public void setSkuCode(String skuCode) {
		this.skuCode = skuCode;
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

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getIsApproved() {
		return isApproved;
	}

	public void setIsApproved(String isApproved) {
		this.isApproved = isApproved;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public String getProductStatus() {
		return productStatus;
	}

	public void setProductStatus(String productStatus) {
		this.productStatus = productStatus;
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

	public double getMrp() {
		return mrp;
	}

	public void setMrp(double mrp) {
		this.mrp = mrp;
	}

	public double getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(double salePrice) {
		this.salePrice = salePrice;
	}

	public double getBaseCost() {
		return baseCost;
	}

	public void setBaseCost(double baseCost) {
		this.baseCost = baseCost;
	}

	public double getPackageWidth() {
		return packageWidth;
	}

	public void setPackageWidth(double packageWidth) {
		this.packageWidth = packageWidth;
	}

	public double getPackageHeight() {
		return packageHeight;
	}

	public void setPackageHeight(double packageHeight) {
		this.packageHeight = packageHeight;
	}

	public double getPackageLength() {
		return packageLength;
	}

	public void setPackageLength(double packageLength) {
		this.packageLength = packageLength;
	}

	public double getPackageWeight() {
		return packageWeight;
	}

	public void setPackageWeight(double packageWeight) {
		this.packageWeight = packageWeight;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getProductDetails() {
		return productDetails;
	}

	public void setProductDetails(String productDetails) {
		this.productDetails = productDetails;
	}

	public String getProductImagesVideo() {
		return productImagesVideo;
	}

	public void setProductImagesVideo(String productImagesVideo) {
		this.productImagesVideo = productImagesVideo;
	}

	public String getProductParameters() {
		return productParameters;
	}

	public void setProductParameters(String productParameters) {
		this.productParameters = productParameters;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public String getTaxCode() {
		return taxCode;
	}

	public void setTaxCode(String taxCode) {
		this.taxCode = taxCode;
	}

	public String getImporterDetails() {
		return importerDetails;
	}

	public void setImporterDetails(String importerDetails) {
		this.importerDetails = importerDetails;
	}

	public String getManufacturerDetails() {
		return manufacturerDetails;
	}

	public void setManufacturerDetails(String manufacturerDetails) {
		this.manufacturerDetails = manufacturerDetails;
	}

	public String getPackerDetails() {
		return packerDetails;
	}

	public void setPackerDetails(String packerDetails) {
		this.packerDetails = packerDetails;
	}

	public String getListingDate() {
		return listingDate;
	}

	public void setListingDate(String listingDate) {
		this.listingDate = listingDate;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<ProductSlug> getSlug() {
		return slug;
	}

	public void setSlug(List<ProductSlug> slug) {
		this.slug = slug;
	}

	public ProductLabel getLabel() {
		return label;
	}

	public void setLabel(ProductLabel label) {
		this.label = label;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getByLine() {
		return byLine;
	}

	public void setByLine(String byLine) {
		this.byLine = byLine;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getAboutTheBrand() {
		return aboutTheBrand;
	}

	public void setAboutTheBrand(String aboutTheBrand) {
		this.aboutTheBrand = aboutTheBrand;
	}

	public String getServiceCode() {
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}

	public List<String> getKeyword() {
		return keyword;
	}

	public void setKeyword(List<String> keyword) {
		this.keyword = keyword;
	}

	public List<String> getMixedFile() {
		return mixedFile;
	}

	public void setMixedFile(List<String> mixedFile) {
		this.mixedFile = mixedFile;
	}

	public String getFile3d() {
		return file3d;
	}

	public void setFile3d(String file3d) {
		this.file3d = file3d;
	}

}
