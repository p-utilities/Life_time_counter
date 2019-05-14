package model.personsLifeCounter;

import java.util.Map;

import model.personsLifeCounter.LifeTimeCounter.NewbornCounter;
import model.personsLifeCounter.components.ErrorException;

/**
 * This class is subclass of class {@link PersonsLifeToCount}. It should be
 * instantiated through it's superclass using
 * {@link PersonsLifeTimeCounterFactory}.
 * 
 * @see {@link #NewbornPerson(Map)} constructor
 * @author Igor Stojanovic
 *
 */
public class NewbornPerson extends PersonsLifeToCount {
	private int birthYear;
	private int birthMonth;
	private int birthDay;

	/**
	 * Construct an object which can count time of life of newborn person if birth
	 * year and current year are equal. To count time of life call method
	 * {@link #count()}.
	 * 
	 * @param inputData
	 * @throws ErrorException
	 */
	public NewbornPerson(Map<String, Integer> inputData) throws ErrorException {
		this.birthDay = inputData.get(BDAY);
		this.birthMonth = inputData.get(BMONTH);
		this.birthYear = inputData.get(BYEAR);

		inputCheck.isWrongInputAlive(birthYear, birthMonth, birthDay);
	}

	/**
	 * Uses objects of a class {@link PersonsLifeToCount} to count life time of
	 * newborn person. After every constructed object of mentioned class, calls
	 * method {@link #setParameters(Map)} to add them to this class parameters.
	 * 
	 * @see {@link NewBornPerson}
	 * @see {@link NewbornCounter}
	 */
	public void count() {
		lifeTimeCounter = new NewbornCounter(birthDay, birthMonth, birthYear);
		setParameters(lifeTimeCounter.getMapOfVars());
	}
}
