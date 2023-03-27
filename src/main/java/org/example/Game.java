package org.example;

public class Game {
    private Player firstPlayer;
    private Player secondPlayer;

    public Game(Player firstPlayer, Player secondPlayer)
    {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
    }

    public String getScores()
    {
        if(gameOver())
            return whoHasAdvantage(firstPlayer, secondPlayer).getName() + " won";
        else if(whoHasAdvantage(firstPlayer, secondPlayer) != null)
            return "advantage " + whoHasAdvantage(firstPlayer, secondPlayer).getName();
        else if(isDeuce())
            return "deuce";
        return firstPlayer.printScore() + " - " + secondPlayer.printScore();
    }

    private Player whoHasAdvantage (Player firstPlayer, Player secondPlayer)
    {
        if (firstPlayer.getScore() > secondPlayer.getScore() && scoredAtLeast3Points(firstPlayer))
            return firstPlayer;
        else if (firstPlayer.getScore() < secondPlayer.getScore() && scoredAtLeast3Points(secondPlayer))
            return secondPlayer;

        return null;

    }

    private boolean gameOver()
    {
        return scoreDifference() >= 2 && (scoredAtLeast3Points(firstPlayer) || scoredAtLeast3Points(secondPlayer));
    }

    private boolean isDeuce()
    {
        return firstPlayer.getScore() == secondPlayer.getScore() && firstPlayer.getScore()>=3;
    }

    private boolean scoredAtLeast3Points(Player player)
    {
        return player.getScore() > 3;
    }

    private int scoreDifference()
    {
        return Math.abs(firstPlayer.getScore() - secondPlayer.getScore());
    }

}
