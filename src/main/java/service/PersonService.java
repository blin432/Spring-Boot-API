package service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import api.PersonController;
import dao.PersonDao;
import model.Person;

@ComponentScan(basePackageClasses = PersonDao.class)
@Service
public class PersonService {
	//getting a reference of person DAO
	private final PersonDao personDao; //need to add constructor like below
	
	//injecting into the actual constructor
	//autowiring into the interface
	//qualifier makes it able to be distinguished
	//to use postgres change "fakeDao" to "postgres"
	@Autowired
	public PersonService(@Qualifier("fakeDao") PersonDao personDao) {
		this.personDao = personDao;
	}
	//to insert a new person
	public int addPerson (Person person) {
		return personDao.insertPerson(person);
	}
	
	public List<Person>getAllPeople(){
		return personDao.selectAllPeople();
	}
	
	public Optional<Person> getPersonById(UUID id){
		return personDao.selectPersonById(id);
	}
	
	public int deletePerson(UUID id) {
		return personDao.deletePersonById(id);
	}
	
	public int updatePerson(UUID id, Person newPerson) {
		return personDao.updatePersonById(id, newPerson);
	}
}
