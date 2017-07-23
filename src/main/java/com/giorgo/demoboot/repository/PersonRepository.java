package com.giorgo.demoboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.giorgo.demoboot.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{

}
