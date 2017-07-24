package com.giorgo.demoboot.dao;

import java.util.List;

import com.giorgo.demoboot.model.Person;

public interface PersonDao {

	List<Person> getAll();

	Person create(Person person);

	Person getOne(Long id);

	void delete(Person person);

}
