package one_man_and_his_dog;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class View extends JFrame
{
        public static int WIDTH = 320;
        public static int HEIGHT = 480;
  
	View()
	{
		super("Toolbar");
		init(mainMenu);
	}

	Model model = new Model();

	JPanel mainMenu = new MainMenuController();
	JPanel game = new GameController();
	// JPanel highScores = new MainMenuController();

	void init(JPanel panel)
	{
		this.setVisible(true);
		this.setResizable(false);
		this.setSize(new Dimension(WIDTH, HEIGHT));
		this.setLocation(100, 100);

		this.setContentPane(panel);

		this.revalidate();
	}

	void goToMainMenu()
	{
		init(mainMenu);
	}

	void goToGame()
	{
		init(game);
	}

	/*
	 * void goToHighscores() { init(highScores); }
	 */

	/*
	 * public class HighScoreController extends JPanel { HighScoreManager hcm =
	 * new HighScoreManager();
	 * 
	 * HighScoreController() {
	 * 
	 * }
	 * 
	 * void init() { hcm.loadScoreFile(); GridBagLayout layout = new
	 * GridBagLayout(); GridBagConstraints c = new GridBagConstraints();
	 * this.setLayout(layout);
	 * 
	 * // setup layout c.fill = GridBagConstraints.HORIZONTAL; c.weightx = 0.5;
	 * 
	 * c.gridx = 0; c.gridy = 0; this.add(new JLabel("High Scores"), c);
	 * 
	 * String[] columns = new String[] { "Id", "Name", "Score" }; JTable table =
	 * new JTable(hcm.getScores(), columns);
	 * 
	 * c.gridx = 0; c.gridy = 1; this.add(new JScrollPane(table));
	 * 
	 * }
	 * 
	 * }
	 */

	private class GameController extends JPanel implements Runnable
	{
		GameController()
		{
			new Thread(this).start();
		}

		@Override
		public void run()
		{
			try
			{
				while (true)
				{
					
					model.updateAll();
					
					repaint();
					Thread.sleep(16);
				}
			} catch (InterruptedException ie)
			{
			}

		}

		public void paint(Graphics g)
		{

			Graphics2D g2 = (Graphics2D) g;
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

			g.setColor(Color.BLACK);
			g.fillRect(0, 0, View.WIDTH, View.HEIGHT);
			
			g.setColor(Color.WHITE);
			for (Sheep s : model.getSheep())
				g.fillOval((int) s.pos.x, (int) s.pos.y, Sheep.SIZE, Sheep.SIZE);

		}

	}

	private class MainMenuController extends JPanel
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
			// c.fill = GridBagConstraints.HORIZONTAL;
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

			btnPlay.addActionListener(new ActionListener()
			{

				@Override
				public void actionPerformed(ActionEvent arg0)
				{
					View.this.goToGame();
				}

			});

		}

	}

}
