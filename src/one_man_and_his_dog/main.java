package one_man_and_his_dog;

public class main
{
	public static void main(String[] args) {

        HighScoreManager hm = new HighScoreManager();
//        hm.addScore("Bart",240);
//        hm.addScore("Marge",300);
//        hm.addScore("Maggie",220);
//        hm.addScore("Homer",100);
//        hm.addScore("Lisa",270);

        hm.loadScoreFile();
        
        System.out.print(hm.getHighScoreString());
	}
}
