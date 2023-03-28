package org.example;

public class Player {
    private String name;
    private int score = 0;

    public Player(String name) {
        this.name = name;
    }

    public void winBall() {
        score++;
    }
    public String printScore(){
        String scoreAsString = "";
        if (score == 0) {
            scoreAsString = "love";
        } else if (score == 1) {
            scoreAsString = "fifteen";
        } else if (score == 2) {
            scoreAsString = "thirty";
        } else if (score == 3) {
            scoreAsString = "forty";
        }
        return scoreAsString;
    }
    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }
}
