package model.personsLifeCounter.LifeTimeCounter;

import model.personsLifeCounter.components.LeapYear;

/**
 * Object of this class count the time from
 * {@code birthDay.birthMonth.birthYear.} to the end of {@code birthYear}.
 * Use {@link #getMapOfVars()} to get counted data.
 * 
 * @see {@link #BirthYearCounter(int birthDay, int birthMonth, int birthYear)}
 * @see {@link #setNumOfYears()}
 * @see {@link #setNumOfMonths()}
 * @see {@link #setNumOfDays()}
 * @see {@link #setNumOfHours()}
 * @see {@link #setNumOfMinutes()}
 * @see {@link #setNumOfSecundes()}
 * @author Igor Stojanovic
 *
 */
public class BirthYearCounter extends LifeTimeCounter {

	private int birthDay;
	private int birthMonth;
	private int birthYear;

	/**
	 * Constructs object of BirthYearCounter, and count the time from
	 * {@code birthDay.birthMonth.birthYear.} to the end of {@code birthYear}.
	 * Use {@link #getMapOfVars()} to get counted data.
	 * 
	 * @see {@link #setNumOfYears()}
	 * @see {@link #setNumOfMonths()}
	 * @see {@link #setNumOfDays()}
	 * @see {@link #setNumOfHours()}
	 * @see {@link #setNumOfMinutes()}
	 * @see {@link #setNumOfSecundes()}
	 * @param birthDay
	 * @param birthMonth
	 * @param birthYear
	 */
	public BirthYearCounter(int birthDay, int birthMonth, int birthYear) {
		this.birthDay = birthDay;
		this.birthMonth = birthMonth;
		this.birthYear = birthYear;

		setNumOfDays();
		setNumOfMonths();
		setNumOfYears();
		setNumOfHours();
		setNumOfMinutes();
		setNumOfSeconds();
	}

	/**
	 * {@inheritDoc}
	 */
	protected void setNumOfYears() {
		allVarsMap.put(Y, 0);
	}

	/**
	 * {@inheritDoc}
	 */
	protected void setNumOfMonths() {
		int months = 12 - countDaysOfMonths.getNumOfMonths() - 1;
		allVarsMap.put(MM, months);
	}

	/**
	 * {@inheritDoc}
	 */
	protected void setNumOfDays() {
		int days = 365 - countDaysOfMonths.countDaysOfMonths(birthMonth, birthYear) - birthDay + 1;
		if (LeapYear.isLeapYear(birthYear)) {
			days++;
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
