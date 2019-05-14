package mainApp;

import java.awt.EventQueue;

import controller.ModelViewController;
import view.CountLifeTimePublic;

public class MainApp{
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CountLifeTimePublic countLifeTimeMainFrame = new CountLifeTimePublic();
					countLifeTimeMainFrame.setVisible(true);
					new ModelViewController(countLifeTimeMainFrame);
				} catch (Exception e) {
					e.printStackTrace();
				} 
			}
		});
	}
}
