package br.com.attornatus.peopleapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.attornatus.peopleapi.entity.People;

public interface PeopleRepository extends JpaRepository<People, Long> {

}
