package br.com.attornatus.peopleapi.controller;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.attornatus.peopleapi.controller.mapper.PeopleMapper;
import br.com.attornatus.peopleapi.controller.resource.PeopleResponse;
import br.com.attornatus.peopleapi.entity.People;
import br.com.attornatus.peopleapi.service.PeopleService;

@WebMvcTest(PeopleController.class)
public class PeopleControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;

	@MockBean
	private PeopleService peopleService;
	
	@Test
	public void findByIdTest() throws Exception {
		final People people = new People("Name", LocalDate.now());
		when(peopleService.findById(anyLong())).thenReturn(people);
		
		final PeopleResponse expectedResponse = PeopleMapper.toResponse(people);
		
		mockMvc.perform(get("/v1/peoples/1").contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().json(objectMapper.writeValueAsString(expectedResponse)));
	}
	
	@Test
	public void findAllTest() throws Exception {
		when(peopleService.findAll()).thenReturn(List.of());
		
		mockMvc.perform(get("/v1/peoples").contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().json("[]"));
	}
}
