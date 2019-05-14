package view.components;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * JPanel with and input death date JLabels and JTextFields for extending JPanel
 * {@link EnterDataPanel}.
 * 
 * @see {@link #EnterDeadDataExtension()}
 * @see {@link #clearTextFields()}
 * @see {@link #getDeathYear()}
 * @see {@link #getDeathMonth()}
 * @see {@link #getDeathDay()}
 * @author Igor Stojanovic
 *
 */
public class EnterDeadDataExtension extends JPanel {

	private static final long serialVersionUID = 16L;

	private JLabel deathDayLabel;
	private JLabel deathMonthLabel;
	private JLabel deathYearLabel;

	private JTextField deathDayTextField;
	private JTextField deathMonthTextField;
	private JTextField deathYearTextField;

	/**
	 * Sets bounds an layout of this panel and calls methods
	 * {@link #addDeathLabels()} and {@link #addDeathTextFields()}
	 */
	public EnterDeadDataExtension() {
		super();
		setBounds(0, 100, 250, 90);
		setLayout(null);
		addDeathLabels();
		addDeathTextFields();
	}

	/**
	 * Adds death labels to this panel.
	 */
	private void addDeathLabels() {
		deathDayLabel = new JLabel("Enter death day");
		deathDayLabel.setHorizontalAlignment(SwingConstants.LEFT);
		deathDayLabel.setBounds(15, 10, 100, 20);
		this.add(deathDayLabel);

		deathMonthLabel = new JLabel("Enter death month");
		deathMonthLabel.setHorizontalAlignment(SwingConstants.LEFT);
		deathMonthLabel.setBounds(15, 40, 100, 20);
		this.add(deathMonthLabel);

		deathYearLabel = new JLabel("Enter death year");
		deathYearLabel.setHorizontalAlignment(SwingConstants.LEFT);
		deathYearLabel.setBounds(15, 70, 100, 20);
		this.add(deathYearLabel);
	}

	/**
	 * adds death text fields to this panel.
	 */
	private void addDeathTextFields() {
		deathDayTextField = new JTextField("");
		deathDayTextField.setBounds(135, 10, 100, 20);
		deathDayTextField.setColumns(10);
		this.add(deathDayTextField);

		deathMonthTextField = new JTextField();
		deathMonthTextField.setBounds(135, 40, 100, 20);
		deathMonthTextField.setColumns(10);
		this.add(deathMonthTextField);

		deathYearTextField = new JTextField();
		deathYearTextField.setBounds(135, 70, 100, 20);
		deathYearTextField.setColumns(10);
		this.add(deathYearTextField);
	}

	/**
	 * Clears text in death text fields.
	 */
	public void clearTextFields() {
		deathDayTextField.setText("");
		deathMonthTextField.setText("");
		deathYearTextField.setText("");
	}

	/**
	 * @return reference to JTextField {@code deathYearTextField}
	 */
	public JTextField getDeathYear() {
		return deathYearTextField;
	}

	/**
	 * @return reference to JTextField {@code deathMonthTextField}
	 */
	public JTextField getDeathMonth() {
		return deathMonthTextField;
	}

	/**
	 * @return reference to JTextField {@code deathDayTextField}
	 */
	public JTextField getDeathDay() {
		return deathDayTextField;
	}
}