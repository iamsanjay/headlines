package com.timesinternet.controllertest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.timesinternet.controller.Application;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class NewsControllerTest {
	@Autowired
	private MockMvc mvc;

	@Test
	public void accessTopHeadlines() throws Exception {
		MockHttpServletResponse resp = mvc.perform(
				MockMvcRequestBuilders.get("/timesinternet/topheadlines?country=in").accept(MediaType.APPLICATION_JSON).header("Authorization", "Basic dXNlcjpwYXNzd29yZA=="))
				.andReturn().getResponse();
		assert(resp.getStatus() == 200);
		assert(!resp.getContentAsString().equals(""));
	}
}
