package com.timesinternet.model.request;
/**
 * 
 * @author sanjaydutt
 *
 */
public class NewsRequest {
	private String query;
	private String country;
	private String category;
	private String sources;
	private int pageSize = 20;
	private int page = 1;
	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public String getSources() {
		return sources;
	}


	public void setSources(String sources) {
		this.sources = sources;
	}


	public int getPageSize() {
		return pageSize;
	}


	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}


	public int getPage() {
		return page;
	}


	public void setPage(int page) {
		this.page = page;
	}


	public String getQuery() {
		return query;
	}

	
	public void setQuery(String query) {
		this.query = query;
	}


	@Override
	public String toString() {
		return "NewsRequest [query=" + query + ", country=" + country + ", category=" + category + ", sources="
				+ sources + ", pageSize=" + pageSize + ", page=" + page + "]";
	}
	
	public String toRequestParam(){
		StringBuilder str = new StringBuilder();
		if(query != null && !"".equals(query))
			str.append("&q="+getQuery());
		if(country != null && !"".equals(country))
			str.append("&country="+getCountry());
		if(category != null && !"".equals(category))
			str.append("&category="+getCategory());
		if(sources != null && !"".equals(sources))
			str.append("&sources="+getSources());
		str.append("&pageSize="+getPageSize());
		str.append("&page="+getPage());
		return str.toString();
	}

}
