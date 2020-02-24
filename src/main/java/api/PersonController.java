package api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.Person;
import service.PersonService;

//used to define endpoint
@RequestMapping("/")
//to expose endpoints and use http methods
@RestController
public class PersonController {

	// reference to the service
	private final PersonService personService;

	//injecting actual service into this constructor
	//called dependencies injections
	@Autowired
	public PersonController(PersonService personService) {
		super();
		this.personService = personService;
	}

	// method to add a person
	//postmapping is post request
	//requestbody is taking the request body and shoveling it in to "person "aka turning json property into a person
	@PostMapping
	public void addPerson(@RequestBody Person person) {
		personService.addPerson(person);
	}
}
