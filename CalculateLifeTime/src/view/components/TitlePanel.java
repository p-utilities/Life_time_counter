package view.components;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * JPanel with title label.
 * 
 * @see {@link #TitlePanel(int, int, int, int)}
 * @see {@link #setTitleColor(Color)}
 * @author Igor Stojanovic
 *
 */
public class TitlePanel extends JPanel{

	private static final long serialVersionUID = 15L;
	private JLabel titleLabel;
	
	/**
	 * Sets bounds and layout to this panel, and calls {@code #addTitle(String)} method.
	 * 
	 * @see {@link #addTitle(String)}
	 * @param x position
	 * @param y position
	 * @param width of the panel
	 * @param height of the panel
	 */
	public TitlePanel(int x, int y, int width, int height) {
		super();
		setBounds(x, y, width, height);
		setLayout(null);
		
		addTitle("LET'S COUNT YOUR LIFE TIME");
	}
	
	/**
	 * Creates JLabel for the title and adds it to the parent JPanel.
	 * Color of this JLabel font can be changed with {@link #setTitleColor(Color)}.
	 * @param title
	 */
	private void addTitle(String title) {
		titleLabel = new JLabel(title);
		titleLabel.setBounds(0, 0, 250, 50);
		titleLabel.setFont(new Font("Stencil", Font.ITALIC, 15));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		this.add(titleLabel);
	}
	
	/**
	 * Sets Title color.
	 * @param color to be set
	 */
	public void setTitleColor(Color color) {
		titleLabel.setForeground(color);
	}
}
