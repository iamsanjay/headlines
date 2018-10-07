package com.timesinternet.controllertest;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.timesinternet.controller.Application;
import com.timesinternet.model.request.NewsRequest;
import com.timesinternet.model.response.Articles;
import com.timesinternet.model.response.Headlines;
import com.timesinternet.service.NewsService;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class NewsControllerTest {
	@Autowired
	private MockMvc mvc;

	@Mock
	private NewsService service;
	
	private Headlines headlines;
	
	@Before
	public void setUp(){
		headlines = new Headlines();
		headlines.setTotalResults(20);
		
		Articles firstArticle = new Articles();
		List<Articles> listOfArticles = new ArrayList<>();
		listOfArticles.add(firstArticle);
		headlines.setArticles(listOfArticles);
	}
	
	@Test
	public void accessTopHeadlines() throws Exception {
		Mockito.when(service.getTopHeadlines(Mockito.any(NewsRequest.class))).thenReturn(headlines);
		MockHttpServletResponse resp = mvc.perform(
				MockMvcRequestBuilders.get("/timesinternet/topheadlines?country=in").accept(MediaType.APPLICATION_JSON).header("Authorization", "Basic dXNlcjpwYXNzd29yZA=="))
				.andReturn().getResponse();
		ObjectMapper mapper = new ObjectMapper();
		Headlines headResp =  mapper.readValue(resp.getContentAsString(), Headlines.class);
		
		assert(headResp.getTotalResults() == headlines.getTotalResults());
	}
}
