package com.timesinternet.model.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Headlines {
	private int totalResults;
	private List<Articles> articles;
	public List<Articles> getArticles() {
		return articles;
	}
	public int getTotalResults() {
		return totalResults;
	}
	public void setArticles(List<Articles> articles) {
		this.articles = articles;
	}
	public void setTotalResults(int totalResults) {
		this.totalResults = totalResults;
	}
	@Override
	public String toString() {
		return "Headlines [totalResults=" + totalResults + ", articles=" + articles + "]";
	}
	
}
