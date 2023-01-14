package br.com.attornatus.peopleapi.controller.mapper;

import java.util.List;
import java.util.stream.Collectors;

import br.com.attornatus.peopleapi.controller.resource.AddressResponse;
import br.com.attornatus.peopleapi.controller.resource.CreateAddressRequest;
import br.com.attornatus.peopleapi.entity.Address;

public class AddressMapper {

	public static Address toEntity(final CreateAddressRequest request) {
		
		final Address address = new Address(
					request.getStreetName(), 
					request.getNumber(), 
					request.getZipCode(), 
					request.getCity()
				);
		
		return address;
	}
	
	public static List<AddressResponse> toResponse(final List<Address> addresses) {
		
		final List<AddressResponse> responses = addresses.stream()
			.map(address -> toResponse(address))
			.collect(Collectors.toList());
		
		return responses;
	}
	
	public static AddressResponse toResponse(final Address address) {
		
		final AddressResponse response = new AddressResponse(
					address.getStreetName(),
					address.getNumber(),
					address.getZipCode(),
					address.getCity(),
					address.isMain()
				);
		
		return response;
	}
}
