package one_man_and_his_dog;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

public class HighScoreController extends JPanel
{
	HighScoreManager hcm = new HighScoreManager();
	
	HighScoreController()
	{
		
	}
	
	void init()
	{
		hcm.loadScoreFile();
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		this.setLayout(layout);
		
		// setup layout
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;

		c.gridx = 0;
		c.gridy = 0;
		this.add(new JLabel("High Scores"), c);
		
		String[] columns = new String[] {
		            "Id", "Name", "Score"
		        };
		JTable table = new JTable(hcm.getScores(), columns);
		
		c.gridx = 0;
		c.gridy = 1;
		this.add(new JScrollPane(table));
		
	}
	
}
