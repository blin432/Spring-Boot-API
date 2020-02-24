package dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import model.Person;

//We are going to define the operations allowed for any one who wishes to use this interface.
public interface PersonDao {

	int insertPerson (UUID id, Person person);
	
	default int insertPerson(Person person) {
		UUID id = UUID.randomUUID();
		return insertPerson (id,person);
	}
	
	List<Person>selectAllPeople();
	
	Optional<Person> selectPersonById(UUID id);
	
	
	int deletePersonById(UUID id);
	
	int updatePersonById(UUID id, Person person);
	
}
