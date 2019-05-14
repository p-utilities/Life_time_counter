package view.components;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

/**
 * 
 * JPanel with output time labels.
 * 
 * @see {@link #LifeTimePanel(int, int, int, int)}
 * @see {@link #setCountedSeconds(int)}
 * @see {@link #setCountedMinutes(int)}
 * @see {@link #setCountedHours(int)}
 * @see {@link #setCountedDays(int)}
 * @see {@link #setCountedMonths(int)}
 * @see {@link #setCountedYears(int)}
 * @see {@link #setComponentNotVisible()}
 * @author Igor Stojanovic
 *
 */
public class LifeTimePanel extends JPanel {

	private static final long serialVersionUID = 12L;
	private JLabel yearsLabel;
	private JLabel monthsLabel;
	private JLabel daysLabel;
	private JLabel hoursLabel;
	private JLabel minutesLabel;
	private JLabel secondsLabel;

	private JLabel countedYearsLabel;
	private JLabel countedMonthsLabel;
	private JLabel countedDaysLabel;
	private JLabel countedHoursLabel;
	private JLabel countedMinutesLabel;
	private JLabel countedSecondsLabel;

	/**
	 * Sets bounds an layout of this panel and calls methods
	 * {@link #addTimeLabels()} and {@link #addCountedTimeLabels()}
	 * 
	 * @param x      position of the panel
	 * @param y      position of the panel
	 * @param width  of panel
	 * @param height of panel
	 */
	public LifeTimePanel(int x, int y, int width, int height) {
		super();
		setBounds(x, y, width, height);
		setLayout(null);

		addTimeLabels();
		addCountedTimeLabels();
	}

	/**
	 * Creates JLabels for seconds, minutes, hours, days, months and years. Sets
	 * their parameters and adds them to to parent Panel.
	 */
	private void addTimeLabels() {
		yearsLabel = new JLabel("Counted years");
		yearsLabel.setHorizontalAlignment(SwingConstants.LEFT);
		yearsLabel.setBounds(15, 10, 100, 20);
		this.add(yearsLabel);

		monthsLabel = new JLabel("Counted months");
		monthsLabel.setHorizontalAlignment(SwingConstants.LEFT);
		monthsLabel.setBounds(15, 40, 100, 20);
		this.add(monthsLabel);

		daysLabel = new JLabel("Counted days");
		daysLabel.setHorizontalAlignment(SwingConstants.LEFT);
		daysLabel.setBounds(15, 70, 100, 20);
		this.add(daysLabel);

		hoursLabel = new JLabel("Counted hours");
		hoursLabel.setHorizontalAlignment(SwingConstants.LEFT);
		hoursLabel.setBounds(15, 100, 100, 20);
		this.add(hoursLabel);

		minutesLabel = new JLabel("Counted minutes");
		minutesLabel.setHorizontalAlignment(SwingConstants.LEFT);
		minutesLabel.setBounds(15, 130, 100, 20);
		this.add(minutesLabel);

		secondsLabel = new JLabel("Counted secundes");
		secondsLabel.setHorizontalAlignment(SwingConstants.LEFT);
		secondsLabel.setBounds(15, 160, 110, 20);
		this.add(secondsLabel);
	}

	/**
	 * Creates JLabels for counted seconds, counted minutes, counted hours, counted
	 * days, counted months and counted years. Sets their parameters and adds them
	 * to to parent Panel.
	 */
	private void addCountedTimeLabels() {
		countedYearsLabel = new JLabel();
		countedYearsLabel.setHorizontalAlignment(SwingConstants.LEFT);
		countedYearsLabel.setBounds(135, 10, 100, 20);
		countedYearsLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		this.add(countedYearsLabel);

		countedMonthsLabel = new JLabel();
		countedMonthsLabel.setHorizontalAlignment(SwingConstants.LEFT);
		countedMonthsLabel.setBounds(135, 40, 100, 20);
		countedMonthsLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		this.add(countedMonthsLabel);

		countedDaysLabel = new JLabel();
		countedDaysLabel.setHorizontalAlignment(SwingConstants.LEFT);
		countedDaysLabel.setBounds(135, 70, 100, 20);
		countedDaysLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		this.add(countedDaysLabel);

		countedHoursLabel = new JLabel();
		countedHoursLabel.setHorizontalAlignment(SwingConstants.LEFT);
		countedHoursLabel.setBounds(135, 100, 100, 20);
		countedHoursLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		this.add(countedHoursLabel);

		countedMinutesLabel = new JLabel();
		countedMinutesLabel.setHorizontalAlignment(SwingConstants.LEFT);
		countedMinutesLabel.setBounds(135, 130, 100, 20);
		countedMinutesLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		this.add(countedMinutesLabel);

		countedSecondsLabel = new JLabel();
		countedSecondsLabel.setHorizontalAlignment(SwingConstants.LEFT);
		countedSecondsLabel.setBounds(135, 160, 100, 20);
		countedSecondsLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		this.add(countedSecondsLabel);
	}

	/**
	 * Sets {@code countedSeconds} to the {@code countedSecondsLabel} text and visibility to this component.
	 * @param countedSeconds
	 */
	public void setCountedSeconds(int countedSeconds) {
		countedSecondsLabel.setText(countedSeconds + "");
		countedSecondsLabel.setVisible(true);
		secondsLabel.setVisible(true);
	}

	/**
	 * Sets {@code countedMinutes} to the {@code countedMinutesLabel} text and visibility to this component.
	 * @param countedSeconds
	 */
	public void setCountedMinutes(int countedMinutes) {
		countedMinutesLabel.setText(countedMinutes + "");
		countedMinutesLabel.setVisible(true);
		minutesLabel.setVisible(true);
	}

	/**
	 * Sets {@code countedHours} to the {@code countedHoursLabel} text and visibility to this component.
	 * @param countedSeconds
	 */
	public void setCountedHours(int countedHours) {
		countedHoursLabel.setText(countedHours + "");
		countedHoursLabel.setVisible(true);
		hoursLabel.setVisible(true);
	}

	/**
	 * Sets {@code countedDays} to the {@code countedDaysLabel} text and visibility to this component.
	 * @param countedSeconds
	 */
	public void setCountedDays(int countedDays) {
		countedDaysLabel.setText(countedDays + "");
		countedDaysLabel.setVisible(true);
		daysLabel.setVisible(true);
	}

	/**
	 * Sets {@code countedMonths} to the {@code countedMonthsLabel} text and visibility to this component.
	 * @param countedSeconds
	 */
	public void setCountedMonths(int countedMonths) {
		countedMonthsLabel.setText(countedMonths + "");
		countedMonthsLabel.setVisible(true);
		monthsLabel.setVisible(true);
	}

	/**
	 * Sets {@code countedYears} to the {@code countedYearsLabel} text and visibility to this component.
	 * @param countedSeconds
	 */
	public void setCountedYears(int countedYears) {
		countedYearsLabel.setText(countedYears + "");
		countedYearsLabel.setVisible(true);
		yearsLabel.setVisible(true);
	}

	/**
	 * Sets components of this panel not visible.
	 */
	public void setComponentNotVisible() {
		countedSecondsLabel.setVisible(false);
		secondsLabel.setVisible(false);

		countedMinutesLabel.setVisible(false);
		minutesLabel.setVisible(false);

		countedHoursLabel.setVisible(false);
		hoursLabel.setVisible(false);

		countedDaysLabel.setVisible(false);
		daysLabel.setVisible(false);

		countedMonthsLabel.setVisible(false);
		monthsLabel.setVisible(false);

		countedYearsLabel.setVisible(false);
		yearsLabel.setVisible(false);
	}
}
