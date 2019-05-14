package view;

import java.util.Map;

import view.components.FooterButtonsListeners;
import view.components.StartButtonListener;

/**
 * This is extension of class {@link CountLifeTimeMainFrame} containing public
 * classes.
 * 
 * @see {@link #clearTextInTextFields()}
 * @see {@link #getEntryData()}
 * @see {@link #setCountedSeconds(int)}
 * @see {@link #setCountedMinutes(int)}
 * @see {@link #setCountedHours(int)}
 * @see {@link #setCountedDays(int)}
 * @see {@link #setCountedMonths(int)}
 * @see {@link #setCountedYears(int)}
 * @see {@link #setComponentNotVisible()}
 * @see {@link #setClearButtonVisible()}
 * @see {@link #setClearButtonNotVisible()}
 * @see {@link #setFooterPanelListener(FooterButtonsListeners)}
 * @see {@link #setStartButtonListener(StartButtonListener)}
 * @author Igor Stojanovic
 * 
 */
public class CountLifeTimePublic extends CountLifeTimeMainFrame {

	private static final long serialVersionUID = 1111L;

	/**
	 * Clears text in all text fields in EnterDataPanel.
	 * 
	 * @see {@link view.components.EnterDataPanel}
	 */
	public void clearTextFields() {
		enterDataPanel.clearTextFields();
	}

	/**
	 * @return Map<String,Integer> with entered data.
	 */
	public Map<String, Integer> getEntryData() {
		return enterDataPanel.getEntryData();
	}

	/**
	 * Sets counted seconds to be outputted.
	 * @param countedSeconds to be outputted
	 */
	public void setCountedSeconds(int countedSeconds) {
		lifeTimePanel.setCountedSeconds(countedSeconds);
	}

	/**
	 * Sets counted minutes to be outputted.
	 * @param countedMinutes to be outputted
	 */
	public void setCountedMinutes(int countedMinutes) {
		lifeTimePanel.setCountedMinutes(countedMinutes);
	}

	/**
	 * Sets counted hours to be outputted.
	 * @param countedHours to be outputted
	 */
	public void setCountedHours(int countedHours) {
		lifeTimePanel.setCountedHours(countedHours);
	}

	/**
	 * Sets counted days to be outputted.
	 * @param countedDays to be outputted
	 */
	public void setCountedDays(int countedDays) {
		lifeTimePanel.setCountedDays(countedDays);
	}

	/**
	 * Sets counted months to be outputted.
	 * @param countedMonths to be outputted
	 */
	public void setCountedMonths(int countedMonths) {
		lifeTimePanel.setCountedMonths(countedMonths);
	}

	/**
	 * Sets counted years to be outputted.
	 * @param countedYears to be outputted
	 */
	public void setCountedYears(int countedYears) {
		lifeTimePanel.setCountedYears(countedYears);
	}

	/**
	 * Sets LifeTimePanel not visible.
	 * 
	 *  @see {@link view.components.LifeTimePanel}
	 */
	public void setLifeTimePanelNotVisible() {
		lifeTimePanel.setComponentNotVisible();
	}

	/**
	 * Sets clear button visible in FooterPanel.
	 * 
	 * @see {@link view.components.FooterPanel}
	 */
	public void setClearButtonVisible() {
		footerPanel.setClearButtonVisible();
	}

	/**
	 * Sets clear button not visible in FooterPanel.
	 * 
	 * @see {@link view.components.FooterPanel}
	 */
	public void setClearButtonNotVisible() {
		footerPanel.setClearButtonNotVisible();
	}

	/**
	 * Sets FooterButtonsListeners in FooterPanel.
	 * 
	 * @see {@link view.components.FooterPanel}
	 * @see {@link view.components.FooterButtonsListeners}
	 * @param footerButtonsListeners
	 */
	public void setFooterPanelListener(FooterButtonsListeners footerButtonsListeners) {
		footerPanel.setFooterButtonsListeners(footerButtonsListeners);
	}

	/**
	 * Sets StartButtonListener in EnterDataPanel.
	 * 
	 * @see {@link view.components.EnterDataPanel}
	 * @see {@link view.components.StartButtonListener}
	 * @param startButtonListener
	 */
	public void setStartButtonListener(StartButtonListener startButtonListener) {
		enterDataPanel.setStartButtonListener(startButtonListener);
	}
}
