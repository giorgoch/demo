package com.giorgo.demoboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.giorgo.demoboot.dao.PersonDao;
import com.giorgo.demoboot.model.Person;

@Service("serviceDao")
public class PersonServiceImpl implements PersonService {

	@Autowired
	PersonDao personDao;

	@Override
	public List<Person> getAll() {

		return personDao.getAll();
	}

	@Override
	public Person create(Person person) {
		return personDao.create(person);
	}

	@Override
	public Person getOne(Long id) {
		return personDao.getOne(id);
	}

	@Override
	public void delete(Person person) {
		personDao.delete(person);

	}

}
