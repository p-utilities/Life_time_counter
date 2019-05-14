package model.personsLifeCounter.LifeTimeCounter;

public class LifeCounterTestDrive {
	private static LifeTimeCounter counterCheck;

	private LifeCounterTestDrive() {
	}

	private static void testBirthYearCounter(int birthDay, int birthMonth, int birthYear) {
		counterCheck = new BirthYearCounter(birthDay, birthMonth, birthYear);
		System.out.println("BirthYearCounter test");
		System.out.println("years    : " + counterCheck.getMapOfVars().get("years"));
		System.out.println("months   : " + counterCheck.getMapOfVars().get("months"));
		System.out.println("days     : " + counterCheck.getMapOfVars().get("days"));
		System.out.println("hours    : " + counterCheck.getMapOfVars().get("hours"));
		System.out.println("minutes  : " + counterCheck.getMapOfVars().get("minutes"));
		System.out.println("secundes : " + counterCheck.getMapOfVars().get("secundes"));
		System.out.println("_________________________");
	}

	private static void testCurrentYearCounter() {
		counterCheck = new CurrentYearCounter();
		System.out.println("CurrentYearCounter test");
		System.out.println("years    : " + counterCheck.getMapOfVars().get("years"));
		System.out.println("months   : " + counterCheck.getMapOfVars().get("months"));
		System.out.println("days     : " + counterCheck.getMapOfVars().get("days"));
		System.out.println("hours    : " + counterCheck.getMapOfVars().get("hours"));
		System.out.println("minutes  : " + counterCheck.getMapOfVars().get("minutes"));
		System.out.println("secundes : " + counterCheck.getMapOfVars().get("secundes"));
		System.out.println("_________________________");
	}

	private static void testDeathYearCounter(int deathDay, int deathMonth, int deathYear) {
		counterCheck = new DeathYearCounter(deathDay, deathMonth, deathYear);
		System.out.println("DeathYearCounter test");
		System.out.println("years    : " + counterCheck.getMapOfVars().get("years"));
		System.out.println("months   : " + counterCheck.getMapOfVars().get("months"));
		System.out.println("days     : " + counterCheck.getMapOfVars().get("days"));
		System.out.println("hours    : " + counterCheck.getMapOfVars().get("hours"));
		System.out.println("minutes  : " + counterCheck.getMapOfVars().get("minutes"));
		System.out.println("secundes : " + counterCheck.getMapOfVars().get("secundes"));
		System.out.println("_________________________");
	}

	private static void testNewbornCounter(int birthDay, int birthMonth, int birthYear) {
		counterCheck = new NewbornCounter(birthDay, birthMonth, birthYear);
		System.out.println("NewbornCounter test");
		System.out.println("years    : " + counterCheck.getMapOfVars().get("years"));
		System.out.println("months   : " + counterCheck.getMapOfVars().get("months"));
		System.out.println("days     : " + counterCheck.getMapOfVars().get("days"));
		System.out.println("hours    : " + counterCheck.getMapOfVars().get("hours"));
		System.out.println("minutes  : " + counterCheck.getMapOfVars().get("minutes"));
		System.out.println("secundes : " + counterCheck.getMapOfVars().get("secundes"));
		System.out.println("_________________________");
	}

	private static void testWholeYearsCounter(int birthYear, int currentOrDeathYear) {
		counterCheck = new WholeYearsCounter(birthYear, currentOrDeathYear);
		System.out.println("WholeYears test");
		System.out.println("years    : " + counterCheck.getMapOfVars().get("years"));
		System.out.println("months   : " + counterCheck.getMapOfVars().get("months"));
		System.out.println("days     : " + counterCheck.getMapOfVars().get("days"));
		System.out.println("hours    : " + counterCheck.getMapOfVars().get("hours"));
		System.out.println("minutes  : " + counterCheck.getMapOfVars().get("minutes"));
		System.out.println("secundes : " + counterCheck.getMapOfVars().get("secundes"));
		System.out.println("_________________________");
	}

	public static void main(String[] args) {
		LifeCounterTestDrive.testBirthYearCounter(15, 3, 1999);
		LifeCounterTestDrive.testCurrentYearCounter();
		LifeCounterTestDrive.testDeathYearCounter(15, 3, 1999);
		LifeCounterTestDrive.testNewbornCounter(15, 3, 2019);
		LifeCounterTestDrive.testWholeYearsCounter(1990, 2019);
	}
}
