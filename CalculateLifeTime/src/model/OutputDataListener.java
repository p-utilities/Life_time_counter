package model;

import java.util.Map;

/**
 * Listener between {@link controller.ModelViewController} and {@link OutputThread}
 * 
 * @see {@link #outputDataChanged(Map)}
 * @see {@link #ErrorExceptionThrown(String)}
 * @author Igor Stojanovic
 *
 */
public interface OutputDataListener {
	/**
	 * When this method is called, outputData is sent from caller to the owner.
	 * 
	 * @see {@link OutputThread} caller
	 * @see {@link controller.ModelViewController} owner
	 * @param timeData to be transfered
	 */
	public void outputDataChanged(Map<String, Integer> outputData);
	
	/**
	 * When this method is called, message is sent from caller to the owner
	 * 
	 * @see {@link OutputThread} caller
	 * @see {@link controller.ModelViewController} owner
	 * @param message to be transfered
	 */
	public void ErrorExceptionThrown(String message);
}
