package service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import dao.PersonDao;
import model.Person;

@Service
public class PersonService {
	//getting a reference of person DAO
	private final PersonDao personDao; //need to add constructor like below
	
	//injecting into the actual constructor
	//autowiring into the interface
	//qualifier makes it able to be distinguished
	@Autowired
	public PersonService(@Qualifier("fakeDao") PersonDao personDao) {
		super();
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
