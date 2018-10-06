package com.timesinternet.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.timesinternet.model.request.NewsRequest;
import com.timesinternet.model.response.Headlines;
import com.timesinternet.service.NewsService;


@RestController()
public class NewsController {

	@Autowired
	public NewsService service;
	
	@RequestMapping("/timesinternet/topheadlines")
	public Headlines fetchHeadlines(@Valid NewsRequest req) throws Exception{
		try{
			return service.getTopHeadlines(req);
		}catch(Exception exp){
			throw exp;
		}
		
	}
	
	@RequestMapping("/timesinternet/everything")
	public Headlines fetchEverything(@Valid NewsRequest req) throws Exception{
		try{
			return service.getEverything(req);
		}catch(Exception exp){
			throw exp;
		}
		
	}
	
}
