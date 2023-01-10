package br.com.attornatus.peopleapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.attornatus.peopleapi.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
