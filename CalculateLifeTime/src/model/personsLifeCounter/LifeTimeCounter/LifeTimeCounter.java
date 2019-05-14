package model.personsLifeCounter.LifeTimeCounter;

import java.util.LinkedHashMap;
import java.util.Map;

import model.personsLifeCounter.components.CountDaysOfMonths;
import model.personsLifeCounter.components.TimeConstants;

/**
 * This is superclass of classes : {@code BirthYearCounter},
 * {@code CurrentYearCounter}, {@code DeathYearCounter}, {@code NewbornCounter},
 * {@code WholeYearsCounter}
 * 
 * @see {@link BirthYearCounter}
 * @see {@link CurrentYearCounter}
 * @see {@link DeathYearCounter}
 * @see {@link NewbornCounter}
 * @see {@link WholeYearsCounter}
 */
public abstract class LifeTimeCounter implements TimeConstants {
	protected Map<String, Integer> allVarsMap = new LinkedHashMap<>();
	protected CountDaysOfMonths countDaysOfMonths = new CountDaysOfMonths();

	/**
	 * Sets number of years in {@code Map<String, Integer} {@code allVarsMap}
	 */
	protected abstract void setNumOfYears();

	/**
	 * Sets number of months in {@code Map<String, Integer} {@code allVarsMap}
	 */
	protected abstract void setNumOfMonths();

	/**
	 * Sets number of days in {@code Map<String, Integer} {@code allVarsMap}
	 */
	protected abstract void setNumOfDays();

	/**
	 * Sets number of hours in {@code Map<String, Integer} {@code allVarsMap}
	 */
	protected abstract void setNumOfHours();

	/**
	 * Sets number of minutes in {@code Map<String, Integer} {@code allVarsMap}
	 */
	protected abstract void setNumOfMinutes();

	/**
	 * Sets number of seconds in {@code Map<String, Integer} {@code allVarsMap}
	 */
	protected abstract void setNumOfSeconds();

	/**
	 * @return Map<String, Integer> containing: years, months, days, hours, minutes,
	 *         seconds
	 */
	public Map<String, Integer> getMapOfVars() {
		return allVarsMap;
	}
}
