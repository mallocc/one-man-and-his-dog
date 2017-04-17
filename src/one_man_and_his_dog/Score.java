package one_man_and_his_dog;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Score  implements Serializable {
    /**
	 * 
	 */
	private Integer score;
    private String name;

    public Integer getScore() {
        return score;
    }
    public String getName() {
        return name;
    }

    public Score(String name, Integer score) {
        this.score = score;
        this.name = name;
    }
}

