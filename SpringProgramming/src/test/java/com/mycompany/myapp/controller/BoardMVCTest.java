package com.mycompany.myapp.controller;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.web.context.WebApplicationContext;

import com.mycompany.myapp.ApplicationContextLoader;

public class BoardMVCTest extends ApplicationContextLoader{
	private static final Logger logger = 
			LoggerFactory.getLogger(BoardMVCTest.class);
	private MockMvc mockMvc; //테스트용mvc
	@Autowired
	private WebApplicationContext context;
	@Before
	public void setup(){
		logger.info("setup");
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	@Test
	public void test1() throws Exception{
		logger.info("test1");
		mockMvc.perform(get("/board/list"))
			.andExpect(model().attributeExists("list"))
			.andExpect(view().name("board/list"))
			.andExpect(status().isOk());//정상응답:200
	}

	@Test
	public void test2() throws Exception{
		logger.info("test2");
		mockMvc.perform(
				post("/board/write")
				.param("title", "테스트1")
				.param("conteshdguq nt", "내용1")
				.param("writer", "글쓴이1")
		)
		.andExpect(redirectedUrl("/board/list"));
	}
}
