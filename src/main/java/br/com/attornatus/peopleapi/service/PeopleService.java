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
	public void update(final Long id, final People people) {
		
		if(exist(id)) {
			People storedPeople = findById(id);
			storedPeople.setName(people.getName());
			storedPeople.setBirthDate(people.getBirthDate());
			
			peopleRepository.save(storedPeople);
		}
	}
	
	public boolean exist(final Long id) {
		return peopleRepository.existsById(id);
	}
}
