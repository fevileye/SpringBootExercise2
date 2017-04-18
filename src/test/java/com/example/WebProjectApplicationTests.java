package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

import javax.validation.constraints.AssertTrue;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WebProjectApplicationTests {

	private MockMvc mockMvc;
	
	@Before
	public void setup(){
		this.mockMvc=MockMvcBuilders
				.standaloneSetup(new HelloController())
				.build();
	}
	
	
	@Test
	public void getMessage() throws Exception {
		this.mockMvc.perform(get("/hello")).andExpect(status().isOk());
	}
	
	@Test
	public void getEmployeeNew() throws Exception{
		String expectedResult="[{\"name\":\"Budi\",\"gender\":\"Male\"}]";
		
		this.mockMvc.perform(get("/employees?gender=Male")).andExpect(status().isOk()).andExpect(content().json(expectedResult));
		
	}
	
	@Test
	public void getAddedEmployee() throws Exception{
		String result="";
		
		this.mockMvc.perform(post("/employees").content("{\"name\":\"andy\",\"gender\":\"female\"}")
				.contentType("application/json"))
		.andExpect(content().json("{\"name\":\"andy\",\"gender\":\"female\"}"))
		.andExpect(status().isOk());
	}

}
