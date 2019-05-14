package model;

import java.util.Map;

import model.personsLifeCounter.PersonLifeTimeCounterFactory;
import model.personsLifeCounter.PersonsLifeToCount;
import model.personsLifeCounter.components.ErrorException;

/**
 * Thread used for all calculations for life time. For every input by the user,
 * one thread is created.
 * 
 * @see {@link #OutputThread(OutputDataListener, Map)} constructor
 * @see {@link java.lang.Thread}
 * @see {@link #run()}
 * @author Igor Stojanovic
 *
 */
public class OutputThread extends Thread {
	private OutputDataListener outputDataListener;
	private PersonLifeTimeCounterFactory personFactory;
	private PersonsLifeToCount personsLifeToCount;

	/**
	 * Constructor sets {@link OutputDataListener} and constructs
	 * {@code PersonLifeTimeCounterFactory}
	 * 
	 * @see {@link OutputDataListener}
	 * @see {@link model.personsLifeCounter.PersonLifeTimeCounterFactory}
	 * @param outputDataListener - ModelViewController
	 * @param entryData          is used for calculations
	 */
	public OutputThread(OutputDataListener outputDataListener, Map<String, Integer> entryData) {
		personFactory = new PersonLifeTimeCounterFactory(entryData);
		this.outputDataListener = outputDataListener;
	}

	/**
	 * Run method for this thread. Uses private method {@code setOutput}
	 * 
	 * @see {@link #setOutput()}
	 */
	public void run() {
		setOutput();
	}

	/**
	 * Sets object {@code PersonsLifeToCount} and sends time data from that object
	 * to {@code OutputDataListener} ie {@code ModelViewController}. If error occur 
	 * in {@code PersonsLifeToCount} object or in  {@link java.lang.Thread#sleep(long)}
	 * this method catches that error and sends it to the {@code ModelViewController}.
	 * 
	 * @see {@link controller.ModelViewController} is where time data and errors goes
	 * @see {@link model.personsLifeCounter.PersonsLifeToCount}
	 * @see {@link model.personsLifeCounter.PersonLifeTimeCounterFactory#getPersonsLifeCounter()}
	 * @see {@link OutputDataListener#outputDataChanged(Map)}
	 * @see {@link OutputDataListener#ErrorExceptionThrown(String)}
	 */
	private void setOutput() {
		try {
			personsLifeToCount = personFactory.getPersonsLifeCounter();
			while (true) {
				personsLifeToCount.count();
				outputDataListener.outputDataChanged(personsLifeToCount.getAllVars());
				sleep(1000);
			}
		} catch (ErrorException e) {
			outputDataListener.ErrorExceptionThrown(e.toString());
		} catch (InterruptedException e) {
			System.out.println("OutputThread interupted | line : 29");
		}
	}
}
