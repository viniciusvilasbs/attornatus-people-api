package br.com.attornatus.peopleapi.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.attornatus.peopleapi.entity.Address;
import br.com.attornatus.peopleapi.entity.People;
import br.com.attornatus.peopleapi.repository.AddressRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AddressService {

	private final AddressRepository addressRepository;
	
	private final PeopleService peopleService;
	
	@Transactional
	public Address create(final Long peopleId, Address address) {
		People people = peopleService.findById(peopleId);
		
		address.setPeople(people);
		
		return addressRepository.save(address);
	}
	
	public List<Address> findAllByPeopleId(final Long peopleId) {
		return addressRepository.findAllByPeopleId(peopleId);
	}
}
