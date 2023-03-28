package org.example;

public class Game {
    private final Player firstPlayer;
    private final Player secondPlayer;

    public Game(Player firstPlayer, Player secondPlayer)
    {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
    }

    public String getScores()
    {
        if(gameOver())
            return whoHasAdvantage().getName() + " won";
        if(scoredAtLeast3Points(firstPlayer) && scoredAtLeast3Points(secondPlayer))
        {
            if(isDeuce())
            {
                return "deuce";
            }
            return "advantage " + whoHasAdvantage().getName();
        }

        return firstPlayer.printScore() + " - " + secondPlayer.printScore();
    }

    private Player whoHasAdvantage ()
    {
        if (firstPlayer.getScore() > secondPlayer.getScore())
            return firstPlayer;

        return secondPlayer;
    }

    private boolean gameOver()
    {
        return (scoreDifference() >= 2 && (firstPlayer.getScore() > 3 || secondPlayer.getScore() > 3));
    }

    private boolean isDeuce()
    {
        return firstPlayer.getScore() == secondPlayer.getScore();
    }

    private boolean scoredAtLeast3Points(Player player)
    {
        return player.getScore() >= 3;
    }

    private int scoreDifference()
    {
        return Math.abs(firstPlayer.getScore() - secondPlayer.getScore());
    }

}
