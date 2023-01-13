package br.com.attornatus.peopleapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.attornatus.peopleapi.entity.People;

@Repository
public interface PeopleRepository extends JpaRepository<People, Long> {

}
