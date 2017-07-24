package com.giorgo.demoboot.service;

import java.util.List;

import com.giorgo.demoboot.model.Person;

public interface PersonService {

	List<Person> getAll();

	Person create(Person person);

	Person getOne(Long id);

	void delete(Person person);

}
