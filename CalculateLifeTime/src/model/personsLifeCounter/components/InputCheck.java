package model.personsLifeCounter.components;

import java.util.Date;

/**
 * Methods of this class check if input data is correct. If not ErrorException is thrown.
 * 
 * @see {@link ErrorException}
 * @see {@link #isWrongInputAlive(int birthYear, int birthMonth, int birthDay)}
 * @see {@link #isWrongInputDead(int birthYear, int birthMonth, int birthDay, int deathYear, int deathMonth,
			int deathDay)} 
 * @author Igor Stojanovic
 *
 */
public class InputCheck {

	private Date date = new Date();

	/**
	 * Use this method to check whether input for dead person is OK. If
	 * birth month or death month equals to February, then method
	 * {@link #isFebruaryInputWrong(int daysOfMonth, int year)} is called.
	 * {@code isFebruaryInputWrong} throws an ErrorException.
	 * 
	 * @param birthYear  input birth year
	 * @param birthMonth input birth month
	 * @param birthDay   input birth day
	 * @param deathYear  input death year
	 * @param deathMonth input death month
	 * @param deathDay   input death day
	 * @throws ErrorException if birth year>=death year ErrorException is thrown.
	 */
	public void isWrongInputDead(int birthYear, int birthMonth, int birthDay, int deathYear, int deathMonth,
			int deathDay) throws ErrorException {

		if (birthYear >= deathYear) {
			throw new ErrorException("Wrong year input");
		}

		isMonthInputWrong(birthDay, birthMonth, birthYear);
		isMonthInputWrong(deathDay, deathMonth, deathYear);
	}

	/**
	 * Use this method to check whether input for alive and newborn person is OK.
	 * 
	 * @param birthYear  input birth year
	 * @param birthMonth input birth month
	 * @param birthDay   input birth day
	 * @throws ErrorException if birth year>current year ErrorException is thrown,
	 *                        if birth year=current year and birth month>current
	 *                        month ErrorException is thrown, and if birth
	 *                        year=current year and birth month=current month and
	 *                        birth day>current day ErrorException is thrown.
	 */
	@SuppressWarnings("deprecation")
	public void isWrongInputAlive(int birthYear, int birthMonth, int birthDay) throws ErrorException {

		if (birthYear > date.getYear() + 1900) {
			throw new ErrorException("Wrong input!");
		} else if (birthYear == date.getYear() + 1900) {
			if (birthMonth > date.getMonth() + 1) {
				throw new ErrorException("Wrong input!");
			} else if (birthMonth == date.getMonth() + 1) {
				if (birthDay > date.getDate()) {
					throw new ErrorException("Wrong input!");
				}
			}
		}

		isMonthInputWrong(birthDay, birthMonth, birthYear);
	}
	
	/**
	 * Checks if month input is OK, if not, the exception is thrown.
	 * 
	 * @param daysOfMonth to check
	 * @param month to check
	 * @param year to check
	 * @throws ErrorException if input days of month are higher then they should be
	 */
	private void isMonthInputWrong(int daysOfMonth, int month, int year) throws ErrorException {
		switch (month) {
		case 1:
			if(daysOfMonth>31) throw new ErrorException("Wrong input!");
			break;
		case 2:
			isFebruaryInputWrong(daysOfMonth, year);
			break;
		case 3:
			if(daysOfMonth>31) throw new ErrorException("Wrong input!");
			break;
		case 4:
			if(daysOfMonth>30) throw new ErrorException("Wrong input!");
			break;
		case 5:
			if(daysOfMonth>31) throw new ErrorException("Wrong input!");
			break;
		case 6:
			if(daysOfMonth>30) throw new ErrorException("Wrong input!");
			break;
		case 7:
			if(daysOfMonth>31) throw new ErrorException("Wrong input!");
			break;
		case 8:
			if(daysOfMonth>31) throw new ErrorException("Wrong input!");
			break;
		case 9:
			if(daysOfMonth>30) throw new ErrorException("Wrong input!");
			break;
		case 10:
			if(daysOfMonth>31) throw new ErrorException("Wrong input!");
			break;
		case 11:
			if(daysOfMonth>30) throw new ErrorException("Wrong input!");
			break;
		case 12:
			if(daysOfMonth>31) throw new ErrorException("Wrong input!");
			break;
		default:
			break;
		}
	}

	/**
	 * Checks whether input days for February are correct.
	 * 
	 * @param daysOfMonth input days
	 * @param year        input year
	 * @throws ErrorException if February input days exceeds the max number of days
	 *                        in month February.
	 */
	private void isFebruaryInputWrong(int daysOfMonth, int year) throws ErrorException {
		if (daysOfMonth > LeapYear.getFebruaryDays(year)) {
			throw new ErrorException(
					"February can have 29 days if the year is leap, or 28 days if year is not a leap year");
		}
	}
}
