package view.components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * 
 * JPanel with clear and exit buttons.
 * 
 * @see {@link #FooterPanel(int, int, int, int)}
 * @see {@link #setClearButtonNotVisible()}
 * @see {@link #setClearButtonVisible()}
 * @see {@link #setFooterButtonsListeners(FooterButtonsListeners)}
 * @author Igor Stojanovic
 *
 */
public class FooterPanel extends JPanel	{
	
	private static final long serialVersionUID = 13L;
	private JButton clearButton;
	private JButton exitButton;
	
	private FooterButtonsListeners footerButtonsListeners;
	
	/**
	 * Sets bounds an layout of this panel and calls method {@link #addFooterButtons()}
	 * @param x position of the panel
	 * @param y position of the panel
	 * @param width of panel
	 * @param height of panel
	 */
	public FooterPanel(int x, int y, int width, int height) {
		super();
		setBounds(x, y, width, height);
		setLayout(null);
		
		addFooterButtons();
	}
	
	/**
	 * Adds two buttons, one for clearing text fields and one for exiting from application.
	 */
	private void addFooterButtons() {
		clearButton = new JButton("Clear");
		clearButton.setBounds(25, 5, 90, 25);
		clearButton.setVisible(false);
		this.add(clearButton);
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fireClearButtonPerformed();
			}
		});
		
		exitButton = new JButton("Exit");
		exitButton.setBounds(125, 5, 90, 25);
		this.add(exitButton);
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fireExitButtonPerfored();				
			}
		});
	}
	
	/**
	 * Sets clear button visible.
	 */
	public void setClearButtonVisible() {
			clearButton.setVisible(true);
	}
	
	/**
	 * Sets clear button not visible.
	 */
	public void setClearButtonNotVisible() {
		clearButton.setVisible(false);
	}
	
	/**
	 * Sets object of {@link FooterButtonsListeners}
	 */
	public void setFooterButtonsListeners(FooterButtonsListeners footerButtonsListeners) {
		this.footerButtonsListeners = footerButtonsListeners;
	}
	
	/**
	 * Calls FooterButtonListeners method {@code clearButtonPerformed()}
	 * 
	 * @see {@link FooterButtonsListeners#clearButtonPerformed()}
	 */
	private void fireClearButtonPerformed() {
		if(footerButtonsListeners != null) {
			footerButtonsListeners.clearButtonPerformed();
		}
	}
	
	/**
	 * Calls FooterButtonListeners method {@code exitButtonPerformed()}
	 * 
	 * @see {@link FooterButtonsListeners#exitButtonPerformed()}
	 */
	private void fireExitButtonPerfored() {
		if(footerButtonsListeners != null) {
			footerButtonsListeners.exitButtonPerformed(); 
		}
	}
}
