package model.personsLifeCounter;

import java.util.Date;
import java.util.Map;

import model.personsLifeCounter.LifeTimeCounter.BirthYearCounter;
import model.personsLifeCounter.LifeTimeCounter.CurrentYearCounter;
import model.personsLifeCounter.LifeTimeCounter.WholeYearsCounter;
import model.personsLifeCounter.components.ErrorException;

/**
 * This class is subclass of class {@link PersonsLifeToCount}. It should be
 * instantiated through it's superclass using
 * {@link PersonsLifeTimeCounterFactory}.
 * 
 * @see {@link #AlivePerson(Map)} constructor
 * @author Igor Stojanovic
 *
 */
public class AlivePerson extends PersonsLifeToCount {

	private int birthYear;
	private int birthMonth;
	private int birthDay;

	/**
	 * Construct an object which can count time of life of alive person which birth
	 * year is different then current year. To count time of life call method
	 * {@link #count()}. Uses method {@code inputCheck.isWrongInputAlive(int birthYear, int birthMonth, int birthDay)} to check
	 * input data.
	 * 
	 * @param inputData list with input data.
	 * @see {@link model.personsLifeCounter.components.InputCheck}
	 * @see {@link model.personsLifeCounter.components.InputCheck#isWrongInputAlive(int birthYear, int birthMonth, int birthDay)}
	 * 
	 * @throws ErrorException if input is incorrect.
	 */
	public AlivePerson(Map<String, Integer> inputData) throws ErrorException {
		this.birthDay = inputData.get(BDAY);
		this.birthMonth = inputData.get(BMONTH);
		this.birthYear = inputData.get(BYEAR);

		inputCheck.isWrongInputAlive(birthYear, birthMonth, birthDay);
	}

	/**
	 * Uses objects of a class {@link PersonsLifeToCount} to count life time of
	 * alive person. After every constructed object of mentioned class, calls method
	 * {@link #setParameters(Map<String, Integer>)} to add them to this class parameters.
	 * 
	 * @see {@link AlivePerson}
	 * @see {@link BirthYearCounter}
	 * @see {@link CurrentYearCounter}
	 * @see {@link WholeYearsCounter}
	 */
	@SuppressWarnings("deprecation")
	public void count() {
		int currentMonth = new Date().getMonth() + 1;
		int currentDay = new Date().getDate();
		if (currentMonth > birthMonth) {
			yearOlder = true;
		} else if (currentMonth == birthMonth) {
			if (currentDay > birthDay) {
				yearOlder = true;
			}
		}

		lifeTimeCounter = new BirthYearCounter(birthDay, birthMonth, birthYear);
		setParameters(lifeTimeCounter.getMapOfVars());

		lifeTimeCounter = new CurrentYearCounter();
		setParameters(lifeTimeCounter.getMapOfVars());

		lifeTimeCounter = new WholeYearsCounter(birthYear, new Date().getYear() + 1900);
		setParameters(lifeTimeCounter.getMapOfVars());
	}
}
