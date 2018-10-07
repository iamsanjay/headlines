package com.timesinternet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.timesinternet.model.request.NewsRequest;
import com.timesinternet.model.response.Headlines;

@Service("NewsService")
@PropertySource("classpath:config.properties")
public class NewsService {

	@Value("${apiKey}")
	private String apiKey;

	@Value("${headlinesURL}")
	private String headlinesURL;

	@Value("${everythingURL}")
	private String everythingURL;

	@Bean
	public RestTemplate restTemplate() {
		RestTemplate template = new RestTemplate();
		template.setErrorHandler(new RestResponseAccepter());
		return template;
	}

	@Autowired
	private RestTemplate restTemplate;

	/**
	 * This service is used to fetch top headlines.
	 * 
	 * @param req
	 * @return Top News Headlines
	 * @throws Exception
	 */
	public Headlines getTopHeadlines(NewsRequest req) throws Exception {

		String url = this.headlinesURL + "apiKey=" + apiKey + req.toRequestParam();
		Headlines resp = null;
		resp = restTemplate.getForObject(url, Headlines.class);
		return resp;
	}

	/**
	 * This service is used to fetch everything.
	 * 
	 * @param req
	 * @return News
	 * @throws Exception
	 */
	public Headlines getEverything(NewsRequest req) throws Exception {
		String url = this.everythingURL + "apiKey=" + apiKey + req.toRequestParam();
		Headlines resp = null;
		resp = restTemplate.getForObject(url, Headlines.class);
		return (Headlines) resp;
	}
}
