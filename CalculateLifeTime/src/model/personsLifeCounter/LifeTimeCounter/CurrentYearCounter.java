package model.personsLifeCounter.LifeTimeCounter;

import java.util.Date;

import model.personsLifeCounter.components.LeapYear;

/**
 * Object of this class count the time for this year.
 * Use {@link #getMapOfVars()} to get counted data.
 * 
 * @see {@link #CurrentYearCounter()}
 * @see {@link #setNumOfYears()}
 * @see {@link #setNumOfMonths()}
 * @see {@link #setNumOfDays()}
 * @see {@link #setNumOfHours()}
 * @see {@link #setNumOfMinutes()}
 * @see {@link #setNumOfSecundes()}
 * @see {@link #setCurrentTime()}
 * @author Igor Stojanovic
 *
 */
public class CurrentYearCounter extends LifeTimeCounter {
	private int currentYear;
	private int currentMonth;
	private int currentDay;
	private int currentHours;
	private int currentMinutes;
	private int currentSeconds;

	/**
	 * Constructs object of CurrentYearCounter, set current time and count the time
	 * past for this year. Use {@link #getMapOfVars()} to get counted data.
	 * 
	 * @see {@link #setCurrentTime()}
	 * @see {@link #setNumOfYears()}
	 * @see {@link #setNumOfMonths()}
	 * @see {@link #setNumOfDays()}
	 * @see {@link #setNumOfHours()}
	 * @see {@link #setNumOfMinutes()}
	 * @see {@link #setNumOfSecundes()}
	 */
	public CurrentYearCounter() {
		setCurrentTime();
		setNumOfYears();
		setNumOfMonths();
		setNumOfDays();
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
		allVarsMap.put(MM, currentMonth - 1);
	}

	/**
	 * {@inheritDoc}
	 */
	protected void setNumOfDays() {
		int days = countDaysOfMonths.countDaysOfMonths(currentMonth, currentYear) + currentDay;
		if (LeapYear.isLeapYear(currentYear)) {
			days++;
		}
		allVarsMap.put(DD, days);
	}

	/**
	 * {@inheritDoc}
	 */
	protected void setNumOfHours() {
		int hours = allVarsMap.get("days") * 24 + currentHours;
		allVarsMap.put(H, hours);
	}

	/**
	 * {@inheritDoc}
	 */
	protected void setNumOfMinutes() {
		int minutes = allVarsMap.get("hours") * 60 + currentMinutes;
		allVarsMap.put(MIN, minutes);
	}

	/**
	 * {@inheritDoc}
	 */
	protected void setNumOfSeconds() {
		int seconds = allVarsMap.get("hours") * 60 + currentSeconds;
		allVarsMap.put(SEC, seconds);
	}

	/**
	 * Sets current time and date using {@link java.util.Date}
	 */
	@SuppressWarnings("deprecation")
	private void setCurrentTime() {
		Date date = new Date();

		currentYear = date.getYear() + 1900;
		currentMonth = date.getMonth() + 1;
		currentDay = date.getDate();
		currentHours = date.getHours();
		currentMinutes = date.getMinutes();
		currentSeconds = date.getSeconds();
	}
}
