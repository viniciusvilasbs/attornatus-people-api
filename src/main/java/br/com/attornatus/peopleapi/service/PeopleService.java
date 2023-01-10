package br.com.attornatus.peopleapi.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.attornatus.peopleapi.entity.People;
import br.com.attornatus.peopleapi.repository.PeopleRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PeopleService {

	
	private final PeopleRepository peopleRepository;

	@Transactional
	public People create(final People people) {
		return peopleRepository.save(people);
	}
	
	public People findById(final Long id) {
		return peopleRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Error"));
	}
	
	public List<People> findAll() {
		return peopleRepository.findAll();
	}
	
	@Transactional
	public People update(final People people, final Long id) {
		peopleRepository.findById(id);
		
		return peopleRepository.save(people);
	}
}
