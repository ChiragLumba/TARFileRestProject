package com.file.project.tar.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.file.project.tar.file.application.App;
import com.file.project.tar.file.controller.FileController;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = App.class)
@SpringBootTest
public class FileControllerTest extends ConfigurationTest {
	
	@Autowired
	WebApplicationContext webApplicationContext;
	
	@InjectMocks
	private FileController fileController;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	
	/**
	 * Test Case to check for the Bad Request. Here in this case we have not provided 
	 * correct request that's why getting 400 Bad Request Status code in response.
	 * @throws Exception
	 */
	@Test
	public void badRequestImportFileTest() throws Exception{
		
		
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/file/import").content("");
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		int status = 400;
		assertEquals(status,result.getResponse().getStatus());
	}
	
	/**
	 * Test Case to check for the No Url Found. Here in this case we have not provided 
	 * correct request URL that's why getting 404 Status code in response.
	 * @throws Exception
	 */
	@Test
	public void urlNotFoundImportFileTest() throws Exception{
		
		
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/file/").content("");
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		int status = 404;
		assertEquals(status,result.getResponse().getStatus());
	}
	
	/**
	 * Test Case to check for the Bad Request. Here in this case we have not provided 
	 * correct request that's why getting 400 Bad Request Status code in response.
	 * @throws Exception
	 */
	@Test
	public void badRequestPullFileTest() throws Exception{
		
		
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/file/pull").content("");
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		int status = 400;
		assertEquals(status,result.getResponse().getStatus());
	}
	
	/**
	 * Test Case to check for the No Url Found. Here in this case we have not provided 
	 * correct request URL that's why getting 404 Status code in response.
	 * @throws Exception
	 */
	@Test
	public void urlNotFoundPullFileTest() throws Exception{
		
		
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/file/").content("");
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		int status = 404;
		assertEquals(status,result.getResponse().getStatus());
	}
	
	/**
	 * Test Case to check for the No Url Found. Here in this case we have not provided 
	 * correct request URL that's why getting 404 Status code in response.
	 * @throws Exception
	 */
	@Test
	public void urlNotFoundListOfFileFileTest() throws Exception{
		
		
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/file/").content("");
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		int status = 404;
		assertEquals(status,result.getResponse().getStatus());
	}
	
	/**
	 * Test Case to check for the Bad Request. Here in this case we have not provided 
	 * correct request that's why getting 400 Bad Request Status code in response.
	 * @throws Exception
	 */
	@Test
	public void badRequestListOfFileTest() throws Exception{
		
		
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/file/pull").content("");
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		int status = 400;
		assertEquals(status,result.getResponse().getStatus());
	}


}
