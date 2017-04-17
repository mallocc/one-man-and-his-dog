package one_man_and_his_dog;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class View extends JFrame
{

	View () {
		super("window");
		this.setVisible(true);
		this.setSize(780, 1280);
		this.setContentPane(new HighScoreController());
		this.revalidate();
	}
	
}
