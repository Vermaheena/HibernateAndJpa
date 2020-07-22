package com.learningJuly.Jpa;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.learningJuly.Jpa.entity.Person;
import com.learningJuly.Jpa.hiberante.PersonRepository;
import com.learningJuly.Jpa.jdbc.PersonJdbcDao;

@SpringBootApplication
public class JpaHibernateApplication implements CommandLineRunner{

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PersonRepository personRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(JpaHibernateApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
//		logger.info("All Users -> {}", personJdbcDao.findAll());
		logger.info("Find By ID -10001 -> {}", personRepository.findById(10001));
//		logger.info("Delete By Id -1001 -> {}", personJdbcDao.deleteById(10001));
//		even if i have mentioned the primary key, it won;t accept it..
		logger.info("Insert  -> {}",
				personRepository.insert(new Person(10007, "Amita", "Noida",new Date())));

	}

}
