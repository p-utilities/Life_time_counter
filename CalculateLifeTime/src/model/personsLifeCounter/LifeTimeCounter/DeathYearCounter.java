package model.personsLifeCounter.LifeTimeCounter;

import model.personsLifeCounter.components.LeapYear;

/**
 * Object of this class count the time from
 * {@code deathYear.} to the {@code deathDay.deathMonth.deathYear.}
 * Use {@link #getMapOfVars()} to get counted data.
 * 
 * @see {@link #DeathYearCounter(int deathDay, int deathMonth, int deathYear)}
 * @see {@link #setNumOfYears()}
 * @see {@link #setNumOfMonths()}
 * @see {@link #setNumOfDays()}
 * @see {@link #setNumOfHours()}
 * @see {@link #setNumOfMinutes()}
 * @see {@link #setNumOfSecundes()}
 * @author Igor Stojanovic
 *
 */
public class DeathYearCounter extends LifeTimeCounter {
	private int deathDay;
	private int deathMonth;
	private int deathYear;
	
	/**
	 * Constructs object of DeathYearCounter, and count the time from
	 * {@code deathYear.} to the {@code deathDay.deathMonth.deathYear.}
	 * Use {@link #getMapOfVars()} to get counted data.
	 * 
	 * @see {@link #setNumOfYears()}
	 * @see {@link #setNumOfMonths()}
	 * @see {@link #setNumOfDays()}
	 * @see {@link #setNumOfHours()}
	 * @see {@link #setNumOfMinutes()}
	 * @see {@link #setNumOfSecundes()}
	 * @param deathDay
	 * @param deathMonth
	 * @param deathYear
	 */
	public DeathYearCounter(int deathDay, int deathMonth, int deathYear) {
		this.deathDay = deathDay;
		this.deathMonth = deathMonth;
		this.deathYear = deathYear;
		
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
		allVarsMap.put(MM, deathMonth);
	}

	/**
	 * {@inheritDoc}
	 */
	protected void setNumOfDays() {
		int days = countDaysOfMonths.countDaysOfMonths(deathMonth - 1, deathYear) + deathDay - 1;
		if (LeapYear.isLeapYear(deathYear)) {
			days ++;
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
