package com.mobwink.springboot.swagger.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobwink.springboot.swagger.bean.Person;
import com.mobwink.springboot.swagger.repository.PersonRepository;
import com.mobwink.springboot.swagger.service.PersonService;

@Service
public class PersonServiceDefault implements PersonService {

	@Autowired
	private PersonRepository personRepository;

	@Override
	public Person getById(int id) {
		return personRepository.findOne(id);
	}

	@Override
	public Person create(Person person) {
		return personRepository.save(person);
	}

}
