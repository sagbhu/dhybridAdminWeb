package com.productmanagement.request;

import java.util.List;

import javax.validation.Valid;

import com.productmanagement.custom.validation.LabelValidation;
import com.productmanagement.custom.validation.SlugValidation;
import com.productmanagement.model.ProductLabel;
import com.productmanagement.model.ProductSlug;

public class ProductRequest {

	private String productId;
	
	@Valid
	@SlugValidation
	private List<ProductSlug> slug;
	
	@Valid
	@LabelValidation
	private ProductLabel label;
	private String intro;
	private String byLine;
	private String desc;
	private String aboutTheBrand;
	private String serviceCode;
	private List<String> keyword;
	private List<String>mixedFile;
	private String file3d;

	
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
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
