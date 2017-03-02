package org.giordano.mockito;

public interface IPersonDAO {
	Person fetchPerson(Integer personID);

	void update(Person person);
}