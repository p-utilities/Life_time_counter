package model.personsLifeCounter.components;

/**
 * This class uses static methods to check if {@code year} is leap or return number of
 * days in February depending on year.
 * 
 * @see {@link #getFebruaryDays(int year)}
 * @see {@link #isLeapYear(int year)}
 * @author Igor Stojanovic
 *
 */
public class LeapYear {

	/**
	 * If {@code year} is leap, return number will be 29, and if not, return number
	 * will be 28.
	 * 
	 * @param year to check
	 * @return number of days in February depending on year
	 */
	public static int getFebruaryDays(int year) {
		if (year % 4 == 0) {
			return 29;
		} else
			return 28;
	}

	/**
	 * Checks whether {@code year} is leap or not.
	 * 
	 * @param year to check
	 * @return {@code true} if year is leap, {@code false} if not
	 */
	public static boolean isLeapYear(int year) {
		if (year % 4 == 0) {
			return true;
		} else
			return false;
	}
}
