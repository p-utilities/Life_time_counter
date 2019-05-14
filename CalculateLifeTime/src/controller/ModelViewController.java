package controller;

import java.util.Map;

import javax.swing.JOptionPane;

import model.OutputDataListener;
import model.OutputThread;
import model.personsLifeCounter.components.TimeConstants;
import view.CountLifeTimePublic;
import view.components.FooterButtonsListeners;
import view.components.StartButtonListener;

/**
 * This class controls interactions between Model and View. The model is thread
 * ({@code OutputThread}) in which all calculations are done.
 * 
 * @see {@link #ModelViewController(CountLifeTime)} constructor
 * @author Igor Stojanovic
 *
 */
public class ModelViewController
		implements FooterButtonsListeners, StartButtonListener, TimeConstants, OutputDataListener {

	private OutputThread outputThread;
	private CountLifeTimePublic mainFrame;

	/**
	 * Constructs object of {@code ModelViewController} and sets
	 * {@code FooterPanelListener} and {@code StartButtonListener}
	 * 
	 * @see {@link view.CountLifeTimePublic}
	 * @see {@link view.CountLifeTimePublic#setFooterPanelListener(FooterButtonListener)}
	 * @see {@link view.CountLifeTimePublic#setStartButtonListener(StartButtonListener)}
	 * @see {@link #exitButtonPerformed()}
	 * @see {@link #clearButtonPerformed()}
	 * @see {@link #startButtonPerformed()}
	 * @see {@link #outputDataChanged(Map)}
	 * @see {@link #ErrorExceptionThrown(String)}
	 * @see {@link #stopOutputThread()}
	 * @see {@link #startOutputThread()}
	 * @see {@link #getEntryData()}
	 * @param mainFrame to control
	 */
	public ModelViewController(CountLifeTimePublic mainFrame) {
		this.mainFrame = mainFrame;

		mainFrame.setFooterPanelListener(this);
		mainFrame.setStartButtonListener(this);
	}

	/**
	 * Uses {@code CountLifeTimePublic} methods to set output data
	 * 
	 * @see {@link view.CountLifeTimePublic}
	 */
	public void outputDataChanged(Map<String, Integer> outputData) {
		mainFrame.setCountedSeconds(outputData.get(SEC));
		mainFrame.setCountedMinutes(outputData.get(MIN));
		mainFrame.setCountedHours(outputData.get(H));
		mainFrame.setCountedDays(outputData.get(DD));
		mainFrame.setCountedMonths(outputData.get(MM));
		mainFrame.setCountedYears(outputData.get(Y));
	}

	/**
	 * If the {@code outputThread} is not null, it kills the thread.
	 */
	@SuppressWarnings("deprecation")
	private void stopOutputThread() {
		if (outputThread != null) {
			outputThread.stop();
			outputThread = null;
		}
	}

	/**
	 * If {@code outputThread} is not null, then kills the thread and then creates new
	 * thread and sends {@code entryData} to that thread.
	 */
	private void startOutputThread() {
		if (outputThread != null) {
			stopOutputThread();
		}
		outputThread = new OutputThread(this, getEntryData());
		outputThread.start();
	}

	/**
	 * @return entry data contained in Map<String,Integer)
	 */
	private Map<String, Integer> getEntryData() {
		return mainFrame.getEntryData();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void clearButtonPerformed() {
		mainFrame.setLifeTimePanelNotVisible();
		mainFrame.setClearButtonNotVisible();
		mainFrame.clearTextFields();
		stopOutputThread();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void exitButtonPerformed() {
		mainFrame.dispose();
		stopOutputThread();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void startButtonPerformed() {
		mainFrame.setClearButtonVisible();
		startOutputThread();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see {@link javax.swing.JOptionPane#showMessageDialog(java.awt.Component, Object, String, int, javax.swing.Icon)}
	 */
	@Override
	public void ErrorExceptionThrown(String message) {
		JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
	}

}
