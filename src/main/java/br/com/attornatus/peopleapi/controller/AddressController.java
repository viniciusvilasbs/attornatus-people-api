package br.com.attornatus.peopleapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.attornatus.peopleapi.entity.Address;
import br.com.attornatus.peopleapi.service.AddressService;

@RestController
@RequestMapping("v1/addresses")
public class AddressController {

	@Autowired
	private AddressService addressService;
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Address> create(@RequestBody Address address, @RequestBody Long peopleId) {
		
		if(peopleId != null) {
			address.getPeople().getId();
			
			Address newAddress = addressService.create(address, peopleId);
			
			return ResponseEntity.status(HttpStatus.CREATED).body(newAddress);
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@GetMapping(path = "/{peopleId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Address> findByPeopleId(@PathVariable Long peopleId) {
		return addressService.findAllByPeopleId(peopleId);
	}
}
