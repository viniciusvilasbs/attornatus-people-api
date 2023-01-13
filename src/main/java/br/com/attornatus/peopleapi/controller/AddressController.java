package br.com.attornatus.peopleapi.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.attornatus.peopleapi.controller.mapper.AddressMapper;
import br.com.attornatus.peopleapi.controller.resource.AddressResponse;
import br.com.attornatus.peopleapi.controller.resource.CreateAddressRequest;
import br.com.attornatus.peopleapi.entity.Address;
import br.com.attornatus.peopleapi.service.AddressService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/peoples/{peopleId}/addresses")
public class AddressController {

	private final AddressService addressService;
	
	@PostMapping
	public ResponseEntity<AddressResponse> create(@PathVariable Long peopleId, @RequestBody CreateAddressRequest request) {
		
		final Address newAddress = addressService.create(peopleId, AddressMapper.toEntity(request));
		
		final AddressResponse response = AddressMapper.toResponse(newAddress);
		
		return ResponseEntity.ok(response);
	}
	
	@GetMapping
	public List<AddressResponse> findByPeopleId(@PathVariable Long peopleId) {
		
		final List<Address> addresses = addressService.findAllByPeopleId(peopleId);
		
		final List<AddressResponse> responses =  AddressMapper.toResponse(addresses);
		
		return responses;
	}
}
