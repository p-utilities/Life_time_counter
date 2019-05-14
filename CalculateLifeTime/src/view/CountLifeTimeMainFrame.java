package view;

import javax.swing.JFrame;

import view.components.DeadExtensionButtonListener;
import view.components.EnterDataPanel;
import view.components.FooterPanel;
import view.components.LifeTimePanel;
import view.components.TitlePanel;

/**
 * This class is main frame for application CalculateLifeTime. It extends JFrame
 * and implements DeadExtensionButtonListener.
 * 
 * @see {@link view.components.DeadExtensionButtonListener}
 * @see {@link javax.swing.JFrame}
 * @see {@link #CountLifeTimeMainFrame()}
 * @author Igor Stojanovic
 *
 */
public class CountLifeTimeMainFrame extends JFrame implements DeadExtensionButtonListener {

	private static final long serialVersionUID = 111L;
	protected LifeTimePanel lifeTimePanel;
	protected TitlePanel titlePanel;
	protected EnterDataPanel enterDataPanel;
	protected FooterPanel footerPanel;

	/**
	 * Constructs an object of class CountLifeTimeMainFrame and calls method
	 * {@code #initialize()}
	 * 
	 * @see {@link #initialize()}
	 */
	public CountLifeTimeMainFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame. Calls constructors for this frame
	 * components.
	 * 
	 * @see {@link view.components.TitlePanel}
	 * @see {@link view.components.EnterDataPanel}
	 * @see {@link view.components.LifeTimePanel}
	 * @see {@link view.components.FooterPanel}
	 */
	private void initialize() {
		setBounds(100, 100, 260, 500);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		titlePanel = new TitlePanel(0, 10, 250, 50);
		getContentPane().add(titlePanel);

		enterDataPanel = new EnterDataPanel(0, 60, 250, 135);
		enterDataPanel.setDeadExtensionButtonListener(this);
		getContentPane().add(enterDataPanel);

		lifeTimePanel = new LifeTimePanel(0, 220, 250, 200);
		lifeTimePanel.setComponentNotVisible();
		getContentPane().add(lifeTimePanel);

		footerPanel = new FooterPanel(0, 420, 250, 35);
		getContentPane().add(footerPanel);
	}

	/**
	 * When {@code deadExtensionButton} is performed, {@code EnterDataPanel} is
	 * resized, {@code LifeTimePanel} and {@code FooterPanel} are shifted up or down
	 * depending on boolean value {@code upOrDown}.
	 * 
	 * @see {@link view.components.EnterDataPanel.addExtentionButton()} button to be
	 *      performed
	 * @see {@link view.components.EnterDataPanel}
	 * @see {@link view.components.LifeTimePanel}
	 * @see {@link view.components.FooterPanel}
	 */
	@Override
	public void deadExtensionButtonPerformed(boolean upOrDown) {
		if (upOrDown) {
			this.setBounds(100, 100, 260, 590);
			enterDataPanel.setBounds(0, 60, 250, 225);
			lifeTimePanel.setBounds(0, 310, 250, 200);
			footerPanel.setBounds(0, 510, 250, 35);
		} else {
			this.setBounds(100, 100, 260, 500);
			enterDataPanel.setBounds(0, 60, 250, 135);
			lifeTimePanel.setBounds(0, 220, 250, 200);
			footerPanel.setBounds(0, 420, 250, 35);
		}
	}
}
