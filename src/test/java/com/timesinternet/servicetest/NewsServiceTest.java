package com.timesinternet.servicetest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.timesinternet.model.request.NewsRequest;
import com.timesinternet.model.response.Headlines;
import com.timesinternet.service.NewsService;

@RunWith(SpringJUnit4ClassRunner.class)
public class NewsServiceTest {
	

	@InjectMocks
	private NewsService service;

	private NewsRequest req;

	@Before
	public void setUp() {
		req = new NewsRequest();
		req.setCountry("in");
	}

	@Test
	public void test() {
		Headlines top = null;
		try {
			top = service.getTopHeadlines(req);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//assert(top.getTotalResults()!=0);
	}

}
