package model.personsLifeCounter.components;

/**
 * Can count days and months in whole year, days and months from January to
 * {@code endingMonth}, and days and months from {@code endingMonth} to
 * {@code endingMonth}
 * 
 * @see {@link #countDaysOfMonths(int year)}
 * @see {@link #countDaysOfMonths(int endingMonth, int year)}
 * @see {@link #countDaysOfMonths(int beginingMonth, int endingMonth, int year)}
 * @see {@link #getNumOfMonths()}
 * @author Igor Stojanovic
 *
 */
public class CountDaysOfMonths {
	private int days;
	private int months;

	/**
	 * Counts days and months from {@code beginingMonth} to {@code endingMonth}.
	 * 
	 * @see {@link LeapYear#getFebruaryDays()} uses this class method to get February
	 *      days.
	 * @param beginingMonth where counting of {@code year} will begin
	 * @param endingMonth   where counting of {@code year} will stop
	 * @param               {@code year} to count
	 * @return number of days from {@code beginingMonth} to {@code endingMonth}
	 */
	public int countDaysOfMonths(int beginingMonth, int endingMonth, int year) {
		for (int i = beginingMonth + 1; i < endingMonth; i++) {
			if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12) {
				days += 31;
			} else if (i == 2) {
				days += LeapYear.getFebruaryDays(year);
			} else {
				days += 30;
			}
			months++;
		}
		return days;
	}

	/**
	 * Calls method {@code #countDaysOfMonths(int beginingMonth, int endingMonth, int year)} where {@code beginingMonth} is 0.
	 * Counts days and months from January to {@code endingMonth}.
	 * 
	 * @param endingMonth where counting of {@code year} will stop
	 * @param             {@code year} to count
	 * @return number of days from January to {@code endingMonth}
	 */
	public int countDaysOfMonths(int endingMonth, int year) {
		return countDaysOfMonths(0, endingMonth, year);
	}

	/**
	 * Returns 366 if {@code year} is leap, and 365 if {@code year} is not leap.
	 * 
	 * @see {@link LeapYear#isLeapYear(int year)} uses this class method to check if
	 *      {@code year} is leap or not
	 * @param year to count
	 * @return days number of days in {@code year}
	 */
	public int countDaysOfMonths(int year) {
		if (LeapYear.isLeapYear(year)) {
			days = 366;
		} else {
			days = 365;
		}
		months = 12;
		return days;
	}

	/**
	 * @return number of months
	 */
	public int getNumOfMonths() {
		return months;
	}
}
