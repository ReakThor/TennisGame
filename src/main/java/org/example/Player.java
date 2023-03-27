package org.example;

public class Player
{
    private final String name;
    private int score;

    public Player(String name)
    {
        this.name = name;
        this.score = 0;
    }

    public String getName()
    {
        return name;
    }

    public String printScore()
    {
        switch (score)
        {
            case 0:
                return "love";
            case 1:
                return "fifteen";
            case 2:
                return "thirty";
            case 3:
                return "forty";
        }
        return "";
    }

    public int getScore()
    {
        return score;
    }

    public void winBall()
    {
        score++;
    }
}