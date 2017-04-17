package one_man_and_his_dog;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class View extends JFrame
{
	View()
	{
		super("Toolbar");
		init(mainMenu);
	}
	
	
	JPanel mainMenu = new MainMenuController();
	//JPanel highScores = new MainMenuController();
	
	void init(JPanel panel)
	{
		this.setVisible(true);
		this.setResizable(false);
		this.setSize(new Dimension(720, 1280));
		this.setLocation(300,300);
		
		this.setContentPane(panel);
		
		this.revalidate();
	}
	
	void goToMainMenu()
	{
		init(mainMenu);
	}
	
	/*void goToHighscores()
	{
		init(highScores);
	}*/
}
