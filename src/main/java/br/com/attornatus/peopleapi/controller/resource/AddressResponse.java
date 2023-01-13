package br.com.attornatus.peopleapi.controller.resource;

import lombok.Data;

@Data
public class AddressResponse {

	private final String streetName;
	private final int number;
	private final String zipCode;
	private final String city;
	private final boolean main;
}
