package com.self.learning.cntr;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.self.learning.service.DateTimeService;

@RunWith(SpringJUnit4ClassRunner.class)
public class DateTimeCntrTest {

	private MockMvc mockMvc;

	@Mock
	private DateTimeService dateTimeService;

	@InjectMocks
	private DateTimeCntr dateTimeCntr;

	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.standaloneSetup(dateTimeCntr).build();
	}
	
	@Test
	public void testIndianTime() throws Exception {

		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy hh:mm");

		Mockito.when(dateTimeService.convertTime("Asia/Kolkata")).thenReturn(now.format(formatter));
		
		mockMvc.perform(MockMvcRequestBuilders.get("/currentTime/IST"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string(now.format(formatter)));
		
		Mockito.verify(dateTimeService).convertTime("Asia/Kolkata");
	}
	
	@Test
	public void testGetJsonTime() throws Exception {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy hh:mm");
		
		Mockito.when(dateTimeService.convertTime("Asia/Kolkata")).thenReturn(now.format(formatter));
		
		mockMvc.perform(MockMvcRequestBuilders.get("/currentTimeJsonGet/IST")
				.accept(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.timeZone", Matchers.is("IST")))
				.andExpect(MockMvcResultMatchers.jsonPath("$.dateTime", Matchers.is(now.format(formatter))))
				.andExpect(MockMvcResultMatchers.jsonPath("$.*", Matchers.hasSize(2)));
		Mockito.verify(dateTimeService).convertTime("Asia/Kolkata");
	}
	
	@Test
	public void testPostJsonTime() throws Exception {
		
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy hh:mm");
		
		
		Mockito.when(dateTimeService.convertTime("Europe/Paris")).thenReturn(now.format(formatter));
		
		String postData = "{\"timeZone\": PST\"}";
		mockMvc.perform(MockMvcRequestBuilders.post("/currentTimeJsonPost/PST")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(postData)
				.accept(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.timeZone", Matchers.is("PST")))
				.andExpect(MockMvcResultMatchers.jsonPath("$.dateTime", Matchers.is(now.format(formatter))))
				.andExpect(MockMvcResultMatchers.jsonPath("$.*",Matchers.hasSize(2)));
		Mockito.verify(dateTimeService).convertTime("Europe/Paris");
		
	}
}