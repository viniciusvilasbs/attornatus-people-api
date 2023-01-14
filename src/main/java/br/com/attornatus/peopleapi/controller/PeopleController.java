package br.com.attornatus.peopleapi.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.attornatus.peopleapi.controller.mapper.PeopleMapper;
import br.com.attornatus.peopleapi.controller.resource.CreatePeopleRequest;
import br.com.attornatus.peopleapi.controller.resource.PeopleResponse;
import br.com.attornatus.peopleapi.entity.People;
import br.com.attornatus.peopleapi.service.PeopleService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/peoples")
public class PeopleController {

	private final PeopleService peopleService;
	
	@PostMapping
	public ResponseEntity<PeopleResponse> create(@RequestBody CreatePeopleRequest request) {
		
		final People newPeople = peopleService.create(PeopleMapper.toEntity(request));
		
		final PeopleResponse response = PeopleMapper.toResponse(newPeople);
		
		return ResponseEntity.ok(response);
	}
	
	@GetMapping(path = "/{peopleId}")
	public ResponseEntity<PeopleResponse> findById(@PathVariable Long peopleId) {
		
		final People people = peopleService.findById(peopleId);
		
		final PeopleResponse response = PeopleMapper.toResponse(people);
		
		return ResponseEntity.ok(response);
	}
	
	@GetMapping
	public ResponseEntity<List<PeopleResponse>> findAll() {
		
		final List<People> peoples = peopleService.findAll();
		
		final List<PeopleResponse> responses = PeopleMapper.toResponse(peoples);
		
		return ResponseEntity.ok(responses);
	}
	
	@PutMapping(path = "/{peopleId}")
	public ResponseEntity<Void> update(@PathVariable Long peopleId, @RequestBody CreatePeopleRequest request) {
		
		final People people = PeopleMapper.toEntity(request);
		
		peopleService.update(peopleId, people);
		
		return ResponseEntity.ok().build();
	}
}
