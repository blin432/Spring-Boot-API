package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import model.Person;


//telling spring that this class needs to be instantiated.
//fakeDao allows you to have multiple implementations
@Repository("fakeDao")
public class FakePersonDataAccessService implements PersonDao {
	
	//creates a list of "persons"
	//List is and interface that is implemented by the class of arraylist
	//arraylist is and object that produces dynamic arrays
	private static List<Person> DB = new ArrayList<>();

	//uses the interface
	@Override
	public int insertPerson(UUID id, Person person) {
		//to insert a person
		DB.add(new Person(id, person.getName()));
		return 1;
	}

	
	
}
