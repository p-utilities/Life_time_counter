package model.personsLifeCounter;

import java.util.Date;
import java.util.Map;

import model.personsLifeCounter.components.ErrorException;
import model.personsLifeCounter.components.TimeConstants;

/**
 * Through this factory objects of abstract class PersonsLifeToCount are
 * created. Using {@code inputData} it chooses which subclass object of abstract
 * class PersonsLifeToCount will be created.
 * 
 * @see {@link #PersonLifeTimeCounterFactory(Map<String, Integer)} constructor
 * @see {@link #choosePersonsCounter()} method for choosing object of abstract
 *      class PersonsLifeToCount
 * @see {@link #getPersonsLifeCounter()} returns object of abstract class
 *      PersonsLifeToCount
 * @see {@link PersonsLifeToCount} return object
 * @author Igor Stojanovic
 *
 */
public class PersonLifeTimeCounterFactory implements TimeConstants {
	private Map<String, Integer> inputData;
	private PersonsLifeToCount personsLifeToCount;

	/**
	 * Constructor for class PersonsLifeTimeCounterFactory. Sets {@code inputData}.
	 * To get subclass object of abstract class PersonsLifeToCount call
	 * {@code #getPersonsLifeCounter()} method.
	 * 
	 * @param inputData Map<String, Integer>
	 */
	public PersonLifeTimeCounterFactory(Map<String, Integer> inputData) {
		this.inputData = inputData;
	}

	/**
	 * Using {@code #inputData} chooses which subclass object of abstract class
	 * PersonsLifeToCount will be created.
	 * 
	 * @see {@link PersonsLifeToCount} abstract class
	 * @see {@link AlivePerson} creation object
	 * @see {@link DeadPerson} creation object
	 * @see {@link NewbornPerson} creation object
	 * @throws ErrorException error is from {@code inputCheck} in PersonsLifeToCount
	 *                        object
	 * @see {@link model.personsLifeCounter.components.InputCheck} this class throws
	 *      ErrorException
	 */
	@SuppressWarnings("deprecation")
	private void choosePersonsCounter() throws ErrorException {
		if (inputData.get(DYEAR) == null) {
			if (inputData.get(BYEAR) == new Date().getYear() + 1900) {
				personsLifeToCount = new NewbornPerson(inputData);
			} else {
				personsLifeToCount = new AlivePerson(inputData);
			}
		} else {
			personsLifeToCount = new DeadPerson(inputData);
		}
	}

	/**
	 * First uses {@link #choosePersonsCounter()} method to create subclass object
	 * of abstract class PersonsLifeToCount and then returns it.
	 * 
	 * @see {@link PersonsLifeToCount} abstract class
	 * @see {@link AlivePerson} creation object
	 * @see {@link DeadPerson} creation object
	 * @see {@link NewbornPerson} creation object
	 * @return subclass object of abstract class PersonsLifeToCount.
	 * @throws ErrorException
	 */
	public PersonsLifeToCount getPersonsLifeCounter() throws ErrorException {
		choosePersonsCounter();
		return personsLifeToCount;
	}
}
