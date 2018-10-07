package com.timesinternet.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.timesinternet.exception.BadRequestException;
import com.timesinternet.model.request.NewsRequest;
import com.timesinternet.model.response.ErrorResponse;
import com.timesinternet.model.response.Headlines;
import com.timesinternet.service.NewsService;

@RestController()
public class NewsController {

	@Autowired
	public NewsService service;
	
	/**
	 * Service is used to fetch Top Headlines.
	 * @param req
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/timesinternet/topheadlines")
	public Headlines fetchHeadlines(@Valid NewsRequest req) throws Exception {

		return service.getTopHeadlines(req);

	}

	/**
	 * Service is used to fetch everything
	 * @param req
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/timesinternet/everything")
	public Headlines fetchEverything(@Valid NewsRequest req) throws Exception {

		return service.getEverything(req);

	}
	
	/**
	 * This method is used to handle all the bad requests. Like wrong params.
	 * @param e
	 * @return
	 */
	@ExceptionHandler(value = BadRequestException.class)
	public ResponseEntity<ErrorResponse> handleBadRequestException(BadRequestException e){
		return new ResponseEntity<ErrorResponse>(new ErrorResponse(404, e.getMessage()),
				HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<ErrorResponse> handleException(Exception e) {
		return new ResponseEntity<ErrorResponse>(new ErrorResponse(400, e.getMessage()),
				HttpStatus.INTERNAL_SERVER_ERROR);

	}
	

}
