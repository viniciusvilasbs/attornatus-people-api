package br.com.attornatus.peopleapi.controller.resource;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class CreatePeopleRequest {

	private final String name;
	
	@JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
	private final LocalDate birthDate;
}
