package model.personsLifeCounter;

import java.util.LinkedHashMap;
import java.util.Map;

import model.personsLifeCounter.LifeTimeCounter.LifeTimeCounter;
import model.personsLifeCounter.components.InputCheck;
import model.personsLifeCounter.components.TimeConstants;

/**
 * This class is abstract class. Her subclasses are {@link AlivePerson},
 * {@link DeadPerson}, {@link NewbornPerson}. This class implements interface
 * {@link TimeConstants} for keys in LinkedHashMap<String, Integer>.
 * 
 * @see {@link java.util.LinkedHashMap}
 * @author Igor Stojanovic
 *
 */
public abstract class PersonsLifeToCount implements TimeConstants {
	private int numOfYears;
	private int numOfMonths;
	private int numOfDays;
	private int numOfHours;
	private int numOfMinutes;
	private int numOfSecundes;
	private Map<String, Integer> allVars = new LinkedHashMap<String, Integer>();

	protected boolean yearOlder = false;

	protected InputCheck inputCheck = new InputCheck();
	protected LifeTimeCounter lifeTimeCounter;

	/**
	 * Uses objects of a class {@link PersonsLifeToCount} to count life time of
	 * person. After every constructed object of mentioned class, calls method
	 * {@link #setParameters(Map<String, Integer)} to add them to this class
	 * parameters.
	 * 
	 * @see {@link AlivePerson}
	 * @see {@link NewbornPerson}
	 * @see {@link DeadPerson}
	 */
	public abstract void count();

	/**
	 * Takes Map<String, Integer> from {@link LifeTimeCounter} and adds values to
	 * this class variables.
	 * 
	 * @see {@link TimeConstants} used for key variable.
	 * @param allVars Map<String, Integer>.
	 */
	protected void setParameters(Map<String, Integer> allVars) {
		numOfYears += allVars.get(Y);
		numOfMonths += allVars.get(MM);
		numOfDays += allVars.get(DD);
		numOfHours += allVars.get(H);
		numOfMinutes += allVars.get(MIN);
		numOfSecundes += allVars.get(SEC);
	}

	/**
	 * Puts all integer variables to LinkedHashMap<String,Integer>.
	 * 
	 * @see {@link TimeConstants} used for key variable.
	 */
	private void putAll() {
		allVars.put(Y, numOfYears);
		allVars.put(MM, numOfMonths);
		allVars.put(DD, numOfDays);
		allVars.put(H, numOfHours);
		allVars.put(MIN, numOfMinutes);
		allVars.put(SEC, numOfSecundes);
	}

	/**
	 * Sets all variables to starting point
	 */
	private void clearVars() {
		numOfYears = 0;
		numOfMonths = 0;
		numOfDays = 0;
		numOfHours = 0;
		numOfMinutes = 0;
		numOfSecundes = 0;
	}

	/**
	 * This method should be used after {@link #count()}, if used before, return Map
	 * will contain all 0.
	 * 
	 * @return Map<String, Integer> - [numOfYears, numOfMonths, nomOfDays,
	 *         numOfHours, numOfMinutes, numOfSecundes]
	 */
	public Map<String, Integer> getAllVars() {
		yearOlder();
		putAll();
		clearVars();
		return allVars;
	}

	/**
	 * Checks if boolean variable year older, if true increment variable numOfYears
	 * by 1.
	 */
	private void yearOlder() {
		if (yearOlder) {
			numOfYears++;
			yearOlder = false;
		}
	}
}
