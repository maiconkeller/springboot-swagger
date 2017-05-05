package com.mobwink.springboot.swagger.repository;

import com.mobwink.springboot.swagger.bean.Person;

public interface PersonRepository {

	Person findOne(int id);

	Person save(Person person);

}
