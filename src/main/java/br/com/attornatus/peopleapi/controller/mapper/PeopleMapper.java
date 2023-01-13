package br.com.attornatus.peopleapi.controller.mapper;

import java.util.List;
import java.util.stream.Collectors;

import br.com.attornatus.peopleapi.controller.resource.CreatePeopleRequest;
import br.com.attornatus.peopleapi.controller.resource.PeopleResponse;
import br.com.attornatus.peopleapi.entity.People;

public class PeopleMapper {

	public static People toEntity(final CreatePeopleRequest request) {
		
		final People people = new People(request.getName(), request.getBirthDate());
		
		return people;
	}
	
	public static List<PeopleResponse> toResponse(final List<People> peoples) {
		
		final List<PeopleResponse> responses = peoples.stream()
				.map(people -> toResponse(people))
				.collect(Collectors.toList());
		
		return responses;
	}
		
	public static PeopleResponse toResponse(final People people) {
		
		final PeopleResponse response = new PeopleResponse(people.getName(), people.getBirthDate());
		
		return response;
	}
}
