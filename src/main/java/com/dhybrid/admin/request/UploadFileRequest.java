package com.dhybrid.admin.request;

import java.util.List;

public class UploadFileRequest {

	private List<String> images;
	private String blogId;

	public List<String> getImages() {
		return images;
	}

	public void setImages(List<String> images) {
		this.images = images;
	}

	public String getBlogId() {
		return blogId;
	}

	public void setBlogId(String blogId) {
		this.blogId = blogId;
	}

}
