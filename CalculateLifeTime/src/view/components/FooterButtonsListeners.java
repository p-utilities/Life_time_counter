package view.components;

/**
 * Listener between {@link controller.ModelViewController} and {@link view.CountLifeTimeMainFrame}
 * 
 * @see {@link exitButtonPerformed()}
 * @see {@link clearButtonPerformed()}
 * @author Igor Stojanovic
 *
 */
public interface FooterButtonsListeners {
	/**
	 * When this method is called, FooterButtonsListeners owner is notified.
	 * 
	 * @see {@link view.CountLifeTimeMainFrame} caller
	 * @see {@link controller.ModelViewController} owner
	 */
	public void exitButtonPerformed();
	/**
	 * When this method is called, FooterButtonsListeners owner is notified.
	 * 
	 * @see {@link view.CountLifeTimeMainFrame} caller
	 * @see {@link controller.ModelViewController} owner
	 */
	public void clearButtonPerformed();
}
