package com.productmanagement.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class ProductLabel {

	@Id
	private String labelId;
	private String labelName;
	private String labelColor;
	private String labelIcon;
	private String labelState;
	private boolean isDeleted;
	
	public String getLabelColor() {
		return labelColor;
	}
	public void setLabelColor(String labelColor) {
		this.labelColor = labelColor;
	}
	public String getLabelState() {
		return labelState;
	}
	public void setLabelSate(String labelState) {
		this.labelState = labelState;
	}
	public boolean isIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	public String getLabelId() {
		return labelId;
	}
	public void setLabelId(String labelId) {
		this.labelId = labelId;
	}
	public String getLabelName() {
		return labelName;
	}
	public void setLabelName(String labelName) {
		this.labelName = labelName;
	}
	public String getLabelIcon() {
		return labelIcon;
	}
	public void setLabelIcon(String labelIcon) {
		this.labelIcon = labelIcon;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((labelId == null) ? 0 : labelId.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductLabel other = (ProductLabel) obj;
		if (labelId == null) {
			if (other.labelId != null)
				return false;
		} else if (!labelId.equals(other.labelId))
			return false;
		return true;
	}
	
	

}
