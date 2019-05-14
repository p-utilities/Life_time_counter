package model.personsLifeCounter;

import java.util.Map;

import model.personsLifeCounter.LifeTimeCounter.BirthYearCounter;
import model.personsLifeCounter.LifeTimeCounter.DeathYearCounter;
import model.personsLifeCounter.LifeTimeCounter.WholeYearsCounter;
import model.personsLifeCounter.components.ErrorException;
import model.personsLifeCounter.components.InputCheck;

/**
 * This class is subclass of class {@link PersonsLifeToCount}. It should be
 * instantiated through it's superclass using
 * {@link PersonsLifeTimeCounterFactory}.
 * 
 * @see {@link #DeadPerson(Map)} constructor
 * @author Igor Stojanovic
 *
 */
public class DeadPerson extends PersonsLifeToCount {
	private int birthYear;
	private int birthMonth;
	private int birthDay;

	private int deathYear;
	private int deathMonth;
	private int deathDay;

	private InputCheck inputCheck = new InputCheck();

	/**
	 * Construct an object which can count time of life of dead person. It can not
	 * count time of life of dead person if the birth year and death year are equal.
	 * To count time of life call method {@link #count()}.
	 * 
	 * @param inputData
	 * @throws ErrorException
	 */
	public DeadPerson(Map<String, Integer> inputData) throws ErrorException {
		this.birthDay = inputData.get(BDAY);
		this.birthMonth = inputData.get(BMONTH);
		this.birthYear = inputData.get(BYEAR);

		this.deathDay = inputData.get(DDAY);
		this.deathMonth = inputData.get(DMONTH);
		this.deathYear = inputData.get(DYEAR);

		inputCheck.isWrongInputDead(birthYear, birthMonth, birthDay, deathYear, deathMonth, deathDay);
	}

	/**
	 * Uses objects of a class {@link PersonsLifeToCount} to count life time of
	 * dead person. After every constructed object of mentioned class, calls method
	 * {@link #setParameters(Map<String, Integer>)} to add them to this class parameters.
	 * 
	 * @see {@link DeadPerson}
	 * @see {@link BirthYearCounter}
	 * @see {@link DeathYearCounter}
	 * @see {@link WholeYearsCounter}
	 */
	public void count() {
		if (deathMonth > birthMonth) {
			yearOlder = true;
		} else if (deathMonth == birthMonth) {
			if (deathDay >= birthDay) {
				yearOlder = true;
			}
		}

		lifeTimeCounter = new BirthYearCounter(birthDay, birthMonth, birthYear);
		setParameters(lifeTimeCounter.getMapOfVars());

		lifeTimeCounter = new DeathYearCounter(deathDay, deathMonth, deathYear);
		setParameters(lifeTimeCounter.getMapOfVars());

		lifeTimeCounter = new WholeYearsCounter(birthYear, deathYear);
		setParameters(lifeTimeCounter.getMapOfVars());
	}
}
