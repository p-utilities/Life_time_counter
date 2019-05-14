package model.personsLifeCounter.LifeTimeCounter;

import model.personsLifeCounter.components.LeapYear;

/**
 * Object of this class count the time between {@code birthYear} and {@code currentOrDeathYear}.
 * Use {@link #getMapOfVars()} to get counted data.
 * 
 * @see {@link #WholeYearsCounter(int birthYear, int currentOrDeathYear)}
 * @see {@link #setNumOfYears()}
 * @see {@link #setNumOfMonths()}
 * @see {@link #setNumOfDays()}
 * @see {@link #setNumOfHours()}
 * @see {@link #setNumOfMinutes()}
 * @see {@link #setNumOfSecundes()}
 * @author Igor Stojanovic
 *
 */
public class WholeYearsCounter extends LifeTimeCounter {
	private int birthYear;
	private int currentOrDeathYear;

	/**
	 * Constructs object of WholeYearsCounter, and count the time for whole year.
	 * Use {@link #getMapOfVars()} to get counted data.
	 * 
	 * @see {@link #setNumOfYears()}
	 * @see {@link #setNumOfMonths()}
	 * @see {@link #setNumOfDays()}
	 * @see {@link #setNumOfHours()}
	 * @see {@link #setNumOfMinutes()}
	 * @see {@link #setNumOfSecundes()}
	 * @param birthDay
	 * @param currentOrDeathYear
	 */
	public WholeYearsCounter(int birthYear, int currentOrDeathYear) {
		this.birthYear = birthYear;
		this.currentOrDeathYear = currentOrDeathYear;
		setNumOfMonths();
		setNumOfYears();
		setNumOfDays();
		setNumOfHours();
		setNumOfMinutes();
		setNumOfSeconds();
	}

	/**
	 * {@inheritDoc}
	 */
	protected void setNumOfYears() {
		int years = allVarsMap.get("months") / 12;
		allVarsMap.put(Y, years);
	}

	/**
	 * {@inheritDoc}
	 */
	protected void setNumOfMonths() {
		int months = 0;
		for (int i = birthYear + 1; i < currentOrDeathYear; i++) {
			months += 12;
		}
		allVarsMap.put(MM, months);
	}

	/**
	 * {@inheritDoc}
	 */
	protected void setNumOfDays() {
		int days = 0;
		for (int i = birthYear + 1; i < currentOrDeathYear; i++) {
			days += 365;
			if (LeapYear.isLeapYear(i)) {
				days++;
			}
		}
		allVarsMap.put(DD, days);
	}

	/**
	 * {@inheritDoc}
	 */
	protected void setNumOfHours() {
		int hours = allVarsMap.get("days") * 24;
		allVarsMap.put(H, hours);
	}

	/**
	 * {@inheritDoc}
	 */
	protected void setNumOfMinutes() {
		int minutes = allVarsMap.get("hours") * 60;
		allVarsMap.put(MIN, minutes);
	}

	/**
	 * {@inheritDoc}
	 */
	protected void setNumOfSeconds() {
		int seconds = allVarsMap.get("minutes") * 60;
		allVarsMap.put(SEC, seconds);
	}
}
