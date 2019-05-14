package view.components;

/**
 * Listener between {@link controller.ModelViewController} and {@link view.CountLifeTimeMainFrame}
 * 
 * @see {@link startButtonPerformed()}
 * @author Igor Stojanovic
 *
 */
public interface StartButtonListener {
	/**
	 * When this method is called, StartButtonListener owner is notified.
	 * 
	 * @see {@link view.CountLifeTimeMainFrame} caller
	 * @see {@link controller.ModelViewController} owner
	 */
	public void startButtonPerformed();
}
