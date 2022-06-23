package com.productmanagement.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class ProductSlug {

	@Id
	private String slugId;
	private String slugName;
	private String state;
	private boolean isDeleted;

	public String getSlugId() {
		return slugId;
	}

	public void setSlugId(String slugId) {
		this.slugId = slugId;
	}

	public String getSlugName() {
		return slugName;
	}

	public void setSlugName(String slugName) {
		this.slugName = slugName;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((slugId == null) ? 0 : slugId.hashCode());
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
		ProductSlug other = (ProductSlug) obj;
		if (slugId == null) {
			if (other.slugId != null)
				return false;
		} else if (!slugId.equals(other.slugId))
			return false;
		return true;
	}

}
