package com.giorgo.demoboot.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.giorgo.demoboot.model.Person;
import com.giorgo.demoboot.repository.PersonRepository;

@Repository
public class PersonDaoImpl implements PersonDao {

	@Autowired
	PersonRepository personRepository;

	@Override
	public List<Person> getAll() {
		return personRepository.findAll();
	}

	@Override
	public Person create(Person person) {
		return personRepository.saveAndFlush(person);
	}

	@Override
	public Person getOne(Long id) {
		return personRepository.findOne(id);
	}

	@Override
	public void delete(Person person) {
		personRepository.delete(person);

	}

}
