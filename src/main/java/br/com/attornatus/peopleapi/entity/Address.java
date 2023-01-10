package br.com.attornatus.peopleapi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "address")
public class Address {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "street_name", nullable = false)
	private String streetName;
	
	@Column(nullable = false)
	private int number;
	
	@Column(name = "zip_code", nullable = false)
	private String zipCode;
	
	@Column(nullable = false)
	private String city;
	
	@Column
	private boolean main;
	
	@ManyToOne
	@JoinColumn(name = "people_id", nullable = false)
	private People people;
}
