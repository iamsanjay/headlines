package com.timesinternet.servicetest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import java.lang.reflect.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner; 
import org.springframework.web.client.RestTemplate;

import com.timesinternet.model.request.NewsRequest;
import com.timesinternet.model.response.Headlines;
import com.timesinternet.service.NewsService;

@RunWith(SpringJUnit4ClassRunner.class)
public class NewsServiceTest {
	

	@InjectMocks
	private NewsService service;
	
	@Mock
	private RestTemplate template;

	private NewsRequest req;
	
	private Headlines headlines;

	@Before
	public void setUp() throws Throwable {
		MockitoAnnotations.initMocks(this);
		Field field=NewsService.class.getDeclaredField("apiKey");
		field.setAccessible(true);
		field.set(service, "testApiKey");
		field=NewsService.class.getDeclaredField("headlinesURL");
		field.setAccessible(true);
		field.set(service, "testUrl");
		field=NewsService.class.getDeclaredField("everythingURL");
		field.setAccessible(true);
		field.set(service, "testEverthing");
		req = new NewsRequest();
		req.setCountry("in");
		
		headlines = new Headlines();
		headlines.setTotalResults(10);
	}

	@Test
	public void test() {
		Headlines top = null;
		try {
			Mockito.when(template.getForObject(Mockito.anyString(),  Mockito.any())).thenReturn(headlines);
			top = service.getTopHeadlines(req);
			assert(top.getTotalResults() == 10);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//assert(top.getTotalResults()!=0);
	}

}
