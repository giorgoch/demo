package com.giorgo.demoboot.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.giorgo.demoboot.repository.PersonRepository;

@Repository
public class PersonDaoImpl {
	
	
	@Autowired
	PersonRepository personRepository;

}
