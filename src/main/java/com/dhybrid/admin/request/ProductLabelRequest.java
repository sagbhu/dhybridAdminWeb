package com.dhybrid.admin.request;

public class ProductLabelRequest {

	private String id;
	private String labelName;
	private String labelColor;
	private String labelIcon;
	private boolean isDeleted;
	private String state;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLabelName() {
		return labelName;
	}

	public void setLabelName(String labelName) {
		this.labelName = labelName;
	}

	public String getLabelColor() {
		return labelColor;
	}

	public void setLabelColor(String labelColor) {
		this.labelColor = labelColor;
	}

	public String getLabelIcon() {
		return labelIcon;
	}

	public void setLabelIcon(String labelIcon) {
		this.labelIcon = labelIcon;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
