package com.dhybrid.admin.request;

import java.util.List;

import javax.validation.Valid;

public class ProductRequest {

	private String skuCode;

	@Valid
	// @SlugValidation
	private List<ProductSlugRequest> slug;
//	
	@Valid
//	@LabelValidation
	private ProductLabelRequest label;
	private List<String> productId;
	private String intro;
	private String byLine;
	private String desc;
	private String aboutTheBrand;
	private String serviceCode;
	private List<String> keyword;
	private List<String> mixedFile;
	private String file3d;
	private String imageTransition;
	private String videoTransition;

	/**
	 * @return the skuCode
	 */
	public String getSkuCode() {
		return skuCode;
	}

	/**
	 * @param skuCode the skuCode to set
	 */
	public void setSkuCode(String skuCode) {
		this.skuCode = skuCode;
	}

	/**
	 * @return the slug
	 */
	public List<ProductSlugRequest> getSlug() {
		return slug;
	}

	/**
	 * @param slug the slug to set
	 */
	public void setSlug(List<ProductSlugRequest> slug) {
		this.slug = slug;
	}

	/**
	 * @return the label
	 */
	public ProductLabelRequest getLabel() {
		return label;
	}

	/**
	 * @param label the label to set
	 */
	public void setLabel(ProductLabelRequest label) {
		this.label = label;
	}

	/**
	 * @return the productId
	 */
	public List<String> getProductId() {
		return productId;
	}

	/**
	 * @param productId the productId to set
	 */
	public void setProductId(List<String> productId) {
		this.productId = productId;
	}

	/**
	 * @return the intro
	 */
	public String getIntro() {
		return intro;
	}

	/**
	 * @param intro the intro to set
	 */
	public void setIntro(String intro) {
		this.intro = intro;
	}

	/**
	 * @return the byLine
	 */
	public String getByLine() {
		return byLine;
	}

	/**
	 * @param byLine the byLine to set
	 */
	public void setByLine(String byLine) {
		this.byLine = byLine;
	}

	/**
	 * @return the desc
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * @param desc the desc to set
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}

	/**
	 * @return the aboutTheBrand
	 */
	public String getAboutTheBrand() {
		return aboutTheBrand;
	}

	/**
	 * @param aboutTheBrand the aboutTheBrand to set
	 */
	public void setAboutTheBrand(String aboutTheBrand) {
		this.aboutTheBrand = aboutTheBrand;
	}

	/**
	 * @return the serviceCode
	 */
	public String getServiceCode() {
		return serviceCode;
	}

	/**
	 * @param serviceCode the serviceCode to set
	 */
	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}

	/**
	 * @return the keyword
	 */
	public List<String> getKeyword() {
		return keyword;
	}

	/**
	 * @param keyword the keyword to set
	 */
	public void setKeyword(List<String> keyword) {
		this.keyword = keyword;
	}

	/**
	 * @return the mixedFile
	 */
	public List<String> getMixedFile() {
		return mixedFile;
	}

	/**
	 * @param mixedFile the mixedFile to set
	 */
	public void setMixedFile(List<String> mixedFile) {
		this.mixedFile = mixedFile;
	}

	/**
	 * @return the file3d
	 */
	public String getFile3d() {
		return file3d;
	}

	/**
	 * @param file3d the file3d to set
	 */
	public void setFile3d(String file3d) {
		this.file3d = file3d;
	}

	/**
	 * @return the imageTransition
	 */
	public String getImageTransition() {
		return imageTransition;
	}

	/**
	 * @param imageTransition the imageTransition to set
	 */
	public void setImageTransition(String imageTransition) {
		this.imageTransition = imageTransition;
	}

	/**
	 * @return the videoTransition
	 */
	public String getVideoTransition() {
		return videoTransition;
	}

	/**
	 * @param videoTransition the videoTransition to set
	 */
	public void setVideoTransition(String videoTransition) {
		this.videoTransition = videoTransition;
	}

}
