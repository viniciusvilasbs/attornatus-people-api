package br.com.attornatus.peopleapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.attornatus.peopleapi.entity.People;
import br.com.attornatus.peopleapi.service.PeopleService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/peoples")
public class PeopleController {

	private final PeopleService peopleService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public People create(@RequestBody @Valid People people) { //melhorar o parametro para não usar a entidade!!!
		return peopleService.create(people);
	}
	
	@GetMapping(path = "/{peopleId}")
	public People findById(@PathVariable Long peopleId) {
		return peopleService.findById(peopleId);
	}
	
	@GetMapping
	public List<People> listAll() {
		return peopleService.findAll();
	}
	
	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<People> update(@PathVariable Long peopleId, @RequestBody People people) {
		People updatedPerson = peopleService.findById(peopleId);
		
		if(updatedPerson != null) {
			updatedPerson = peopleService.update(people, peopleId);
			
			return ResponseEntity.ok(updatedPerson);
		}
		
		return ResponseEntity.notFound().build();
	}
}
