package view.components;

/**
 * Listener between {@link view.components.EnterDataPanel} and {@link view.CountLifeTimeMainFrame}
 * 
 * @see {@link deadExtensionButtonPerformed(boolean)}
 * @author Igor Stojanovic
 *
 */
public interface DeadExtensionButtonListener {
	/**
	 * When this method is called, DeadExtensionButtonListener owner is notified.
	 * 
	 * @see {@link view.components.EnterDataPanel} caller
	 * @see {@link controller.ModelViewController} owner
	 */
	public void deadExtensionButtonPerformed(boolean upOrDown);
}
