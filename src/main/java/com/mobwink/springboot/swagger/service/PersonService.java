package com.mobwink.springboot.swagger.service;

import com.mobwink.springboot.swagger.bean.Person;

public interface PersonService {

	public Person getById(int id);

	public Person create(Person person);
	
}
