package one_man_and_his_dog;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

public class MainMenuController extends JPanel
{	
	JButton btnPlay = new JButton("Play");
	JButton btnHighScores = new JButton("High Scores");
	JButton btnSettings = new JButton("Settings");
	
	JLabel title = new JLabel("One Man And His Dog");
	
	MainMenuController()
	{
		init();
	}
	
	void init()
	{
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		this.setLayout(layout);
		
		// setup layout
		//c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1;

		c.gridx = 0;
		c.gridy = 0;
		this.add(title, c);
		c.gridx = 0;
		c.gridy = 1;
		this.add(btnPlay, c);
		c.gridx = 0;
		c.gridy = 2;
		this.add(btnHighScores, c);
		c.gridx = 0;
		c.gridy = 3;
		this.add(btnSettings, c);
		
		
		btnPlay.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				
			}
			
		});

		
		
	}
	
}
