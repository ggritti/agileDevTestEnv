package org.giordano.mockito;

public class PersonService {
	private final IPersonDAO personDAO;

	public PersonService(IPersonDAO personDAO) {
		this.personDAO = personDAO;
	}

	public boolean update(Integer personId, String name) {
		Person person = personDAO.fetchPerson(personId);
		if (person != null) {
			Person updatedPerson = new Person(person.getPersonID(), name);
			personDAO.update(updatedPerson);
			return true;
		} else {
			return false;
		}
	}
}