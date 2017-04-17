package one_man_and_his_dog;

import java.util.*;
import java.io.*;

public class HighScoreManager {
    // An array list of the type "score" we will use to work with the scores inside the class
    ArrayList<Score> scores;

    // The name of the file where the high scores will be saved
    private static final String HIGHSCORE_FILE = "scores.dat";

    //Initialising an in and outputStream for working with the file
    ObjectOutputStream outputStream = null;
    ObjectInputStream inputStream = null;

    public HighScoreManager() {
        //initialising the scores-array list
        scores = new ArrayList<Score>();
    }
    
	public ArrayList<Score> getScores() {
	    loadScoreFile();
	    sort();
	    return scores;
	}
	
	public void addScore(String name, Integer score) {
	    loadScoreFile();
	    scores.add(new Score(name, score));
	    updateScoreFile();
	}
	
	@SuppressWarnings("unchecked")
	public void loadScoreFile() {
	    try {
	        inputStream = new ObjectInputStream(new FileInputStream(HIGHSCORE_FILE));
	        scores = (ArrayList<Score>) inputStream.readObject();
	    } catch (FileNotFoundException e) {
	        System.out.println("[Load] FNF Error: " + e.getMessage());
	    } catch (IOException e) {
	        System.out.println("[Load] IO Error: " + e.getMessage());
	    } catch (ClassNotFoundException e) {
	        System.out.println("[Load] CNF Error: " + e.getMessage());
	    } finally {
	        try {
	            if (outputStream != null) {
	                outputStream.flush();
	                outputStream.close();
	            }
	        } catch (IOException e) {
	            System.out.println("[Load] IO Error: " + e.getMessage());
	        }
	    }
	}
	
	private void updateScoreFile() {
	    try {
	        outputStream = new ObjectOutputStream(new FileOutputStream(HIGHSCORE_FILE));
	        outputStream.writeObject(scores);
	    } catch (FileNotFoundException e) {
	        System.out.println("[Update] FNF Error: " + e.getMessage() + ",the program will try and make a new file");
	    } catch (IOException e) {
	        System.out.println("[Update] IO Error: " + e.getMessage());
	    } finally {
	        try {
	            if (outputStream != null) {
	                outputStream.flush();
	                outputStream.close();
	            }
	        } catch (IOException e) {
	            System.out.println("[Update] Error: " + e.getMessage());
	        }
	    }
	}
	
	public String getHighScoreStrings() {
	    String highScoreString = "";
	    int maxEntries = 10;
	
	    ArrayList<Score> scores;
	    scores = getScores();
	
	    int i = 0;
	    int x = scores.size();
	    if (x > maxEntries) {
	        x = maxEntries;
	    }
	    while (i < x) {
	        highScoreString += (i + 1) + ".\t" + getHighScoreString(scores.get(i));
	        i++;
	    }
	    return highScoreString;
	}

	public String getHighScoreString(Score score) {
	    String highScoreString = "";
	    highScoreString = score.getName() + "\t\t" + score.getScore() + "\n";
	    return highScoreString;
	}

	private void sort() {
	    ScoreComparator comparator = new ScoreComparator();
	    Collections.sort(scores, comparator);
	}
	
	private class ScoreComparator implements Comparator<Score> {
        public int compare(Score score1, Score score2) {

            int sc1 = score1.getScore();
            int sc2 = score2.getScore();

            if (sc1 > sc2){
                return -1;
            }else if (sc1 < sc2){
                return +1;
            }else{
                return 0;
            }
        }
	}
}

