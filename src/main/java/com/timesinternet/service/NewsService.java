package com.timesinternet.service;

import java.net.SocketException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
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
		return new RestTemplate();
	}

	@Autowired
	private RestTemplate restTemplate;
	
	/**
	 * This service is used to fetch top headlines.
	 * @param req
	 * @return Top News Headlines
	 * @throws HttpClientErrorException throws exception in case of bad request.
	 * @throws Exception
	 */
	public Headlines getTopHeadlines(NewsRequest req) throws Exception{
		
		String url = this.headlinesURL+"apiKey="+apiKey+req.toRequestParam();
		System.out.println(url);
		Headlines resp = null;
		try{
			resp = restTemplate.getForObject(url, Headlines.class);
		}catch(HttpClientErrorException exp){
			throw new Exception(exp.getMessage());
		}catch(Exception exp){
			throw new Exception(exp.getMessage());
		}
		 return resp;
	}
	
	/**
	 * This service is used to fetch everything.
	 * @param req
	 * @return News 
	 * @throws Exception
	 */
	public Headlines getEverything(NewsRequest req) throws Exception{
		String url = this.everythingURL+"apiKey="+apiKey+req.toRequestParam();
		System.out.println(url);
		Headlines resp = null;
		try{
			resp = restTemplate.getForObject(url, Headlines.class);
		}catch(HttpClientErrorException exp){
			throw new Exception(exp.getMessage());
		}catch(Exception exp){
			throw new Exception(exp.getMessage());
		}
		 return resp;
	}
}
