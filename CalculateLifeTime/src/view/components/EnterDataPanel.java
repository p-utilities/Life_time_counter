package view.components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * JPanel with input birth date JLabels and JTextFields. Contains
 * {@link EnterDeadDataExtension} if needed
 * 
 * @see {@link #EnterDataPanel(int, int, int, int)}
 * @see {@link #addExtentionButton()}
 * @see {@link #clearTextInTextFields()}
 * @see {@link #getEntryData()}
 * @see {@link #setStartButtonListener(StartButtonListener)}
 * @see {@link #setDeadExtensionButtonListener(DeadExtensionButtonListener)tensionButtonListener}
 * @see {@link #arrowButtonPerformed()}
 * @author Igor Stojanovic
 *
 */
public class EnterDataPanel extends JPanel {

	private static final long serialVersionUID = 14L;
	private JLabel birthDayLabel;
	private JLabel birthMonthLabel;
	private JLabel birthYearLabel;

	private JTextField birthDayTextField;
	private JTextField birthMonthTextField;
	private JTextField birthYearTextField;

	private EnterDeadDataExtension enterDeadDataExtension;
	private JButton extentionButton;
	private boolean isDeadExtensionVisible = false;
	private ImageIcon arrowUp = new ImageIcon(EnterDataPanel.class.getResource("/Images/ArrowUp .png"));
	private ImageIcon arrowDown = new ImageIcon(EnterDataPanel.class.getResource("/Images/ArrowDown.png"));

	private JButton callculateButton;

	private DeadExtensionButtonListener deadExtensionButtonListener;
	private StartButtonListener startButtonListener;
	private Map<String, Integer> entryData;

	/**
	 * Sets bounds an layout of this panel and calls methods
	 * {@link #addBirthLabels()}, {@link #addBirthTextFields()},
	 * {@link #addStartButton()} and {@link #addExtentionButton()}
	 * 
	 * @param x      position of the panel
	 * @param y      position of the panel
	 * @param width  of the panel
	 * @param height of the panel
	 */
	public EnterDataPanel(int x, int y, int width, int height) {
		super();

		this.setBounds(x, y, width, height);
		this.setLayout(null);

		addBirthLabels();
		addBirthTextFields();
		addStartButton();
		addExtentionButton();
	}

	/**
	 * Creates JLabels for birth day, birth month and bith year.
	 */
	private void addBirthLabels() {
		birthDayLabel = new JLabel("Enter birth day");
		birthDayLabel.setHorizontalAlignment(SwingConstants.LEFT);
		birthDayLabel.setBounds(15, 10, 100, 20);
		this.add(birthDayLabel);

		birthMonthLabel = new JLabel("Enter birth month");
		birthMonthLabel.setHorizontalAlignment(SwingConstants.LEFT);
		birthMonthLabel.setBounds(15, 40, 100, 20);
		this.add(birthMonthLabel);

		birthYearLabel = new JLabel("Enter birth year");
		birthYearLabel.setHorizontalAlignment(SwingConstants.LEFT);
		birthYearLabel.setBounds(15, 70, 100, 20);
		this.add(birthYearLabel);
	}

	/**
	 * Creates JTextFields for birth day, birth month and bith year.
	 */
	private void addBirthTextFields() {
		birthDayTextField = new JTextField("");
		birthDayTextField.setBounds(135, 10, 100, 20);
		birthDayTextField.setColumns(10);
		this.add(birthDayTextField);

		birthMonthTextField = new JTextField();
		birthMonthTextField.setBounds(135, 40, 100, 20);
		birthMonthTextField.setColumns(10);
		this.add(birthMonthTextField);

		birthYearTextField = new JTextField();
		birthYearTextField.setBounds(135, 70, 100, 20);
		birthYearTextField.setColumns(10);
		this.add(birthYearTextField);
	}

	/**
	 * Creates {@link EnterDeadDataExtension} and adds it to this panel.
	 */
	private void addDeadExtension() {
		if (enterDeadDataExtension == null) {
			enterDeadDataExtension = new EnterDeadDataExtension();
			this.add(enterDeadDataExtension);
		} else {
			enterDeadDataExtension.setVisible(true);
		}
	}

	/**
	 * Adds start button to this panel.
	 */
	private void addStartButton() {
		callculateButton = new JButton("Callculate life time");
		callculateButton.setBounds(35, 110, 150, 25);
		this.add(callculateButton);
		callculateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isBirthInputOk()) {
					if (isDeadExtensionVisible) {
						if (isDeathInputOk()) {
							fireStartButtonPerformed();
						}
					} else {
						fireStartButtonPerformed();
					}
				}
			}
		});
	}

	/**
	 * Adds extention button to this panel.
	 */
	public void addExtentionButton() {
		extentionButton = new JButton();
		extentionButton.setBounds(190, 110, 25, 25);
		extentionButton.setIcon(new ImageIcon(EnterDataPanel.class.getResource("/Images/ArrowDown.png")));
		this.add(extentionButton);
		extentionButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				arrowButtonPerformed();
			}
		});
	}

	/**
	 * Checks whether birth date text fields are not empty.
	 * 
	 * @return true if birth date text fields are not empty. If false, shows message
	 *         dialog with message : "Please enter data".
	 */
	private boolean isBirthInputOk() {
		if (birthDayTextField.getText().isEmpty() || birthMonthTextField.getText().isEmpty()
				|| birthYearTextField.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Please enter data", "", JOptionPane.ERROR_MESSAGE);
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Checks whether death date text fields are not empty.
	 * 
	 * @return true if death date text fields are not empty. If false, shows message
	 *         dialog with message : "Please enter data".
	 */
	private boolean isDeathInputOk() {
		if (enterDeadDataExtension.getDeathDay().getText().isEmpty()
				|| enterDeadDataExtension.getDeathMonth().getText().isEmpty()
				|| enterDeadDataExtension.getDeathYear().getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Please enter data", "", JOptionPane.ERROR_MESSAGE);
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Clear text in birth date text fields and if enterDeadDataExtension is not
	 * null, clear dead date text fields.
	 */
	public void clearTextFields() {
		birthDayTextField.setText("");
		birthMonthTextField.setText("");
		birthYearTextField.setText("");
		if (enterDeadDataExtension != null) {
			enterDeadDataExtension.clearTextFields();
		}
	}

	/**
	 * @return Map of variables from birth date text fields, and if if
	 *         enterDeadDataExtension is not null, includes variables from dead date
	 *         text fields.
	 */
	public Map<String, Integer> getEntryData() {
		entryData = new LinkedHashMap<String, Integer>();
		entryData.put("birth year", Integer.parseInt(birthYearTextField.getText()));
		entryData.put("birth month", Integer.parseInt(birthMonthTextField.getText()));
		entryData.put("birth day", Integer.parseInt(birthDayTextField.getText()));
		if (isDeadExtensionVisible) {
			entryData.put("death year", Integer.parseInt(enterDeadDataExtension.getDeathYear().getText()));
			entryData.put("death month", Integer.parseInt(enterDeadDataExtension.getDeathMonth().getText()));
			entryData.put("death day", Integer.parseInt(enterDeadDataExtension.getDeathDay().getText()));
		}
		return entryData;
	}

	/**
	 * Sets this class start button listener to parameter object
	 * startButtonListener.
	 * 
	 * @param startButtonListener
	 */
	public void setStartButtonListener(StartButtonListener startButtonListener) {
		this.startButtonListener = startButtonListener;
	}

	/**
	 * Calls method {@link StartButtonListener#startButtonPerformed()}
	 */
	private void fireStartButtonPerformed() {
		if (startButtonListener != null) {
			startButtonListener.startButtonPerformed();
		}
	}

	/**
	 * Sets this class dead extension button listener to parameter object
	 * deadExtensionButtonListener.
	 * 
	 * @param deadExtensionButtonListener
	 */
	public void setDeadExtensionButtonListener(DeadExtensionButtonListener deadExtensionButtonListener) {
		this.deadExtensionButtonListener = deadExtensionButtonListener;
	}

	/**
	 * Calls method
	 * {@link DeadExtensionButtonListener#deadExtensionButtonPerformed(boolean)}
	 */
	private void fireDeadExtensionButtonPerformed(boolean upOrDown) {
		if (deadExtensionButtonListener != null) {
			deadExtensionButtonListener.deadExtensionButtonPerformed(upOrDown);
		}
	}

	/**
	 * This method is called when extension button is performed. If
	 * enterDeadDataExtension is equal to null, then extension is added to this
	 * panel and other components are shifted down, if not, extension is set to not
	 * visible and other components are shifted up.
	 */
	protected void arrowButtonPerformed() {
		if (isDeadExtensionVisible) {
			enterDeadDataExtension.setVisible(false);
			isDeadExtensionVisible = false;
			callculateButton.setBounds(35, 110, 150, 25);
			extentionButton.setBounds(190, 110, 25, 25);
			extentionButton.setIcon(arrowDown);
			fireDeadExtensionButtonPerformed(isDeadExtensionVisible);
		} else {
			addDeadExtension();
			isDeadExtensionVisible = true;
			callculateButton.setBounds(35, 200, 150, 25);
			extentionButton.setBounds(190, 200, 25, 25);
			extentionButton.setIcon(arrowUp);
			fireDeadExtensionButtonPerformed(isDeadExtensionVisible);
		}
	}
}