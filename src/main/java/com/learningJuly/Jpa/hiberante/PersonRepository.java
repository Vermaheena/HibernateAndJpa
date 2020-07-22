package com.learningJuly.Jpa.hiberante;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.learningJuly.Jpa.entity.Person;

@Repository
@Transactional
public class PersonRepository {
	
	//connect to DataBase
	@PersistenceContext
	EntityManager entityManager;
	
	public Person findById(int id) {
		return entityManager.find(Person.class, id);
	}

	public Person insert(Person person) {
		return entityManager.merge(person);
	}
}
