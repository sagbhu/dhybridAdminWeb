package com.productmanagement.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class ProductCategory {

	@Id
	private String merchId;
	private String merchLevel;
	private String extMerchCode;
	private String merchName;
	private String merchDesc;
	private String parentMerchCode;
	private String isActive;
	private String udf1;
	private String udf2;
	private String udf3;
	private String udf4;
	private String udf5;
	private String userId;
	private String updateDate;

	public String getMerchId() {
		return merchId;
	}

	public void setMerchId(String merchId) {
		this.merchId = merchId;
	}

	public String getMerchLevel() {
		return merchLevel;
	}

	public void setMerchLevel(String merchLevel) {
		this.merchLevel = merchLevel;
	}

	public String getExtMerchCode() {
		return extMerchCode;
	}

	public void setExtMerchCode(String extMerchCode) {
		this.extMerchCode = extMerchCode;
	}

	public String getMerchName() {
		return merchName;
	}

	public void setMerchName(String merchName) {
		this.merchName = merchName;
	}

	public String getMerchDesc() {
		return merchDesc;
	}

	public void setMerchDesc(String merchDesc) {
		this.merchDesc = merchDesc;
	}

	public String getParentMerchCode() {
		return parentMerchCode;
	}

	public void setParentMerchCode(String parentMerchCode) {
		this.parentMerchCode = parentMerchCode;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public String getUdf1() {
		return udf1;
	}

	public void setUdf1(String udf1) {
		this.udf1 = udf1;
	}

	public String getUdf2() {
		return udf2;
	}

	public void setUdf2(String udf2) {
		this.udf2 = udf2;
	}

	public String getUdf3() {
		return udf3;
	}

	public void setUdf3(String udf3) {
		this.udf3 = udf3;
	}

	public String getUdf4() {
		return udf4;
	}

	public void setUdf4(String udf4) {
		this.udf4 = udf4;
	}

	public String getUdf5() {
		return udf5;
	}

	public void setUdf5(String udf5) {
		this.udf5 = udf5;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}



	@Override
	public String toString() {
		return "ProductCategory [merchId=" + merchId + ", merchLevel=" + merchLevel + ", extMerchCode=" + extMerchCode
				+ ", merchName=" + merchName + ", merchDesc=" + merchDesc + ", parentMerchCode=" + parentMerchCode
				+ ", isActive=" + isActive + ", udf1=" + udf1 + ", udf2=" + udf2 + ", udf3=" + udf3 + ", udf4=" + udf4
				+ ", udf5=" + udf5 + ", userId=" + userId + ", updateDate=" + updateDate + "]";
	}

}
