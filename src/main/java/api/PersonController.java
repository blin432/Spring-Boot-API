package api;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.Person;
import service.PersonService;

//to expose endpoints and use http methods

//used to define endpoint

@ComponentScan(basePackageClasses = PersonService.class)
@RequestMapping("api/v1/person")
@RestController
public class PersonController {

	// reference to the service
	private final PersonService personService;

	//injecting actual service into this constructor
	//called dependencies injections
	@Autowired
	public PersonController(PersonService personService) {
		this.personService = personService;
	}

	// method to add a person
	//postmapping is post request
	//requestbody is taking the request body and shoveling it in to "person "aka turning json property into a person
	@PostMapping
	public void addPerson(@Valid @NonNull @RequestBody Person person) {
		personService.addPerson(person);
	}
	
	@GetMapping
	public List<Person> getAllPeople(){

		return personService.getAllPeople();
	}
	
	@GetMapping(path = "{id}")
	public Person getPersonById(@PathVariable("id") UUID id) {
		return personService.getPersonById(id)
				.orElse(null);
	}
	
	@DeleteMapping(path = "{id}" )
	public void deletePersonById(@PathVariable("id") UUID id) {
		personService.deletePerson(id);
	}
	
	@PutMapping (path = "{id}")
	public void updatePerson(@PathVariable("id") UUID id, @Valid  @NonNull @RequestBody Person personToUpdate) {
		personService.updatePerson(id, personToUpdate);
	}
	
}
