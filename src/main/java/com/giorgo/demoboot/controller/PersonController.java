package com.giorgo.demoboot.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.giorgo.demoboot.model.Person;
import com.giorgo.demoboot.repository.PersonRepository;
import com.giorgo.demoboot.service.PersonService;

@RestController
@RequestMapping("api/v2")
public class PersonController {

	@Autowired
	PersonService personService;

	@GetMapping("persons")
	public List<Person> list() {

		return personService.getAll(); /// personRepository.findAll();
	}

	@PostMapping("person/{id}")
	public Person create(@RequestBody Person person) {
		return personService.create(person);// personRepository.saveAndFlush(person);
	}

	@GetMapping("persons/{id}")
	public Person get(@PathVariable Long id) {
		return personService.getOne(id); // personRepository.findOne(id);
	}

	@PutMapping("person/{id}")
	public Person update(@PathVariable Long id, @RequestBody Person person) {

		Person p = personService.getOne(id);/// personRepository.findOne(id);

		BeanUtils.copyProperties(person, p);

		return personService.create(p);// personRepository.saveAndFlush(p);
	}

	public Person delete(@PathVariable Long id) {

		Person person = personService.getOne(id); // personRepository.findOne(id);

		personService.delete(person);
		// personRepository.delete(person);

		return person;
	}

}
