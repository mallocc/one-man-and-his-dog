package one_man_and_his_dog;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

@SuppressWarnings({ "serial", "unused", "restriction" })
public class HighScoreController extends JPanel
{
	HighScoreManager hcm = new HighScoreManager();
	
	HighScoreController()
	{
		init();
	}
	
	void init()
	{
		hcm.loadScoreFile();
		
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		this.setLayout(layout);
		
		// setup layout
		c.fill = GridBagConstraints.VERTICAL;
		c.gridx = 0;
		c.gridy = 0;
		this.add(new JLabel("High Scores"), c);
		
		String[] columns = new String[] {
		            "Id", "Name", "Score"
		        };
		DefaultTableModel tableModel = new DefaultTableModel(columns,0);

		int i = 0;
		int x = hcm.scores.size();
		while (i < x) {
	    	Score s = hcm.scores.get(i);
//			System.out.print((i+1) + "; " + hcm.getHighScoreString(s));
			Object[] data = { i+1, s.getName(), s.getScore() };
			tableModel.addRow(data);
			i++;
		}
		
		JTable table = new JTable(tableModel);
		
		c.gridx = 0;
		c.gridy = 1;
		this.add(new JScrollPane(table));
		
		this.revalidate();
	}
	
}
