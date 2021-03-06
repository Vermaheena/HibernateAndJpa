package com.learningJuly.Jpa;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.learningJuly.Jpa.entity.Person;
import com.learningJuly.Jpa.jdbc.PersonJdbcDao;

//@SpringBootApplication
public class JpaApplication implements CommandLineRunner{

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PersonJdbcDao personJdbcDao;
	
	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("All Users -> {}", personJdbcDao.findAll());
		logger.info("Find By ID -10001 -> {}", personJdbcDao.findById(10001));
		logger.info("Delete By Id -1001 -> {}", personJdbcDao.deleteById(10001));
		
		logger.info("Insert  -> {}",
				personJdbcDao.insert(new Person(10007, "Amita", "Noida",new Date())));

	}

}
