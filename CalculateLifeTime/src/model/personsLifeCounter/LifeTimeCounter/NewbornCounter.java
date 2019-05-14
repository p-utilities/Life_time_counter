package model.personsLifeCounter.LifeTimeCounter;

import java.util.Date;

import model.personsLifeCounter.components.LeapYear;

/**
 * Object of this class count the time from
 * {@code birthDay.birthMonth.birthYear.} to the end of
 * {@code currentDay.currentMonth.currentYear.} This class uses class
 * {@code BirthYearCounter} and class {@code CurrentYearCounter} to count time
 * of life of newborn. Use object of this class only when {@code birthYear.} is
 * equal to {@code currentYear.} Use {@link #getMapOfVars()} to get counted data.
 * 
 * @see {@link BirthYearCounter}
 * @see {@link CurrentYearCounter}
 * @author Irina Stojanovic
 *
 */
public class NewbornCounter extends LifeTimeCounter {
	private BirthYearCounter birthYearCounter;
	private CurrentYearCounter currentYearCounter;

	private Date date;
	private int currentMonth;
	private int currentHours;
	private int currentMinutes;
	private int currentSeconds;

	private int birthYear;
	private int birthMonth;

	/**
	 * Constructs object of NewbornCounter, and count the time from {@code
	 * birthDay.birthMonth.birthYear.} to the end of {@code
	 * currentDay.currentMonth.currentYear.} This object is used only when
	 * {@code birthYear.} is equal to {@code currentYear.} Object uses class
	 * {@code BirthYearCounter} and class {@code CurrentYearCounter} to count time
	 * of life of newborn. Use {@link #getMapOfVars()} to get counted data.
	 * 
	 * @see {@link BirthYearCounter}
	 * @see {@link CurrentYearCounter}
	 * @param birthDay
	 * @param birthMonth
	 * @param birthYear
	 */
	public NewbornCounter(int birthDay, int birthMonth, int birthYear) {
		this.birthYear = birthYear;
		this.birthMonth = birthMonth;
		birthYearCounter = new BirthYearCounter(birthDay, birthMonth, birthYear);
		currentYearCounter = new CurrentYearCounter();

		setCurrentTime();
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
		int months = currentMonth - birthMonth - 1;
		if (months < 0) {
			months = 0;
		}
		allVarsMap.put(MM, months);
	}

	/**
	 * {@inheritDoc}
	 */
	protected void setNumOfDays() {
		int year = 365;
		if (LeapYear.isLeapYear(birthYear)) {
			year++;
		}
		int days = currentYearCounter.getMapOfVars().get("days") - (year - birthYearCounter.getMapOfVars().get("days"))
				- 1;
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
		int Seconds = allVarsMap.get("minutes") * 60 + currentSeconds;
		allVarsMap.put(SEC, Seconds);
	}

	/**
	 * Sets current time and date using {@link java.util.Date}
	 */
	@SuppressWarnings("deprecation")
	private void setCurrentTime() {
		date = new Date();
		this.currentMonth = date.getMonth() + 1;
		this.currentHours = date.getHours();
		this.currentMinutes = date.getMinutes();
		this.currentSeconds = date.getSeconds();
	}
}
