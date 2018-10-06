package com.timesinternet.model.response;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Articles {
	private Source source;
	private String author;
	private String title;
	private String description;
	private String url;
	private String urlToImage;
	private Date publishedAt;
	private String content;
	public String getAuthor() {
		return author;
	}
	public String getContent() {
		return content;
	}
	public String getDescription() {
		return description;
	}
	public Date getPublishedAt() {
		return publishedAt;
	}
	public Source getSource() {
		return source;
	}
	public String getTitle() {
		return title;
	}
	public String getUrl() {
		return url;
	}
	public String getUrlToImage() {
		return urlToImage;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setPublishedAt(Date publishedAt) {
		this.publishedAt = publishedAt;
	}
	public void setSource(Source source) {
		this.source = source;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public void setUrlToImage(String urlToImage) {
		this.urlToImage = urlToImage;
	}
	@Override
	public String toString() {
		return "Articles [source=" + source + ", author=" + author + ", title=" + title + ", description=" + description
				+ ", url=" + url + ", urlToImage=" + urlToImage + ", publishedAt=" + publishedAt + ", content="
				+ content + "]";
	}
}
