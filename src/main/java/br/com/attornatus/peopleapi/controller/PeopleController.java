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
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/peoples")
@Slf4j
public class PeopleController {

	private final PeopleService peopleService;
	
	@PostMapping
	public ResponseEntity<PeopleResponse> create(@RequestBody CreatePeopleRequest request) {
		
		log.info(request.toString());
		
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
	
	@PutMapping
	public ResponseEntity<People> update(@PathVariable Long peopleId, @RequestBody People people) {
		People updatedPerson = peopleService.findById(peopleId);
		
		if(updatedPerson != null) {
			updatedPerson = peopleService.update(people, peopleId);
			
			return ResponseEntity.ok(updatedPerson);
		}
		
		return ResponseEntity.notFound().build();
	}
}
