package com.dhybrid.admin.request;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class BlogRequest {
	private String id;
	private String title;
	private String subTitle;
	private String description;
	private List<Content> contents;
	private String tags;
	private String poweredBy;
	private String createdDate;
	private List<String> selfTags;
	private List<String> crossTags;
	private List<String> exernalLink;
	private String categoryId;
	private boolean addToBag;
	private String authorName;
	private String publishDate;
	private String state;
	private String expiryDate;
	private List<BlogLabel> blogLabels;
	private Long claps;
	private List<Keyword> keywords;
	private List<Keyword> photoCredits;
	private List<MultipartFile> blogFiles;

	public List<Keyword> getKeywords() {
		return keywords;
	}

	public void setKeywords(List<Keyword> keywords) {
		this.keywords = keywords;
	}

	public List<Keyword> getPhotoCredits() {
		return photoCredits;
	}

	public void setPhotoCredits(List<Keyword> photoCredits) {
		this.photoCredits = photoCredits;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubTitle() {
		return subTitle;
	}

	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Content> getContents() {
		return contents;
	}

	public void setContents(List<Content> contents) {
		this.contents = contents;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getPoweredBy() {
		return poweredBy;
	}

	public void setPoweredBy(String poweredBy) {
		this.poweredBy = poweredBy;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public List<String> getSelfTags() {
		return selfTags;
	}

	public void setSelfTags(List<String> selfTags) {
		this.selfTags = selfTags;
	}

	public List<String> getCrossTags() {
		return crossTags;
	}

	public void setCrossTags(List<String> crossTags) {
		this.crossTags = crossTags;
	}

	public List<String> getExernalLink() {
		return exernalLink;
	}

	public void setExernalLink(List<String> exernalLink) {
		this.exernalLink = exernalLink;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public boolean isAddToBag() {
		return addToBag;
	}

	public void setAddToBag(boolean addToBag) {
		this.addToBag = addToBag;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public List<BlogLabel> getBlogLabels() {
		return blogLabels;
	}

	public void setBlogLabels(List<BlogLabel> blogLabels) {
		this.blogLabels = blogLabels;
	}

	public Long getClaps() {
		return claps;
	}

	public void setClaps(Long claps) {
		this.claps = claps;
	}

	public List<MultipartFile> getBlogFiles() {
		return blogFiles;
	}

	public void setBlogFiles(List<MultipartFile> blogFiles) {
		this.blogFiles = blogFiles;
	}
}
