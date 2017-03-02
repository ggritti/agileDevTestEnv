package org.giordano.mockito;

public interface IPersonDAO {
	public Person fetchPerson(Integer personID);

	public void update(Person person);
}