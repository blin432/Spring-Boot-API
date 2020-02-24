package dao;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;
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

	@Override
	public List<Person> selectAllPeople() {
		// TODO Auto-generated method stub
		return DB;
	}

	@Override
	public Optional<Person> selectPersonById(UUID id) {
		// TODO Auto-generated method stub
		return DB.stream()
			.filter(person -> person.getId().equals(id))
			.findFirst();
	}

	@Override
	public int deletePersonById(UUID id) {
		// TODO Auto-generated method stub
		Optional<Person> personMaybe = selectPersonById(id);
		if (personMaybe.isPresent()) {
			return 0; 
		}
		DB.remove(personMaybe.get());
		return 1;
	}

	@Override
	public int updatePersonById(UUID id, Person update) {
		// TODO Auto-generated method stub
		return selectPersonById(id)
				.map(p -> {
					int indexOfPersonToUpdate = DB.indexOf(p);
					if (indexOfPersonToUpdate >=0) {
						DB.set(indexOfPersonToUpdate, new Person(id, update.getName()));
						return 1;
					}
					return 0;
				}).orElse(0);

	}
}
