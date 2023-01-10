package br.com.attornatus.peopleapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.attornatus.peopleapi.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

	List<Address> findAllByPeopleId(Long peopleId);
	
}
