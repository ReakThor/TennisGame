package org.example;

public class Game {
    Player player1;
    Player player2;

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }
    public String getScores(){
        if (!isDeuce()) {
            if (scoreSum(player1, player2) > 3) {
                return standings(player1, player2);
            } else if (scoreSum(player1, player2) <= 3){
                return player1.printScore() + " - " + player2.printScore();
            } else return "";
        } else {
            return "deuce";
        }

    }

    public String standings(Player a, Player b) {
        String finalStanding = "";
        if (scoreSum(a, b) >= 3 && !isThereAWinner(a, b)) {
            if (a.getScore() == b.getScore()) {
                finalStanding = "deuce";
            } else if (a.getScore() > b.getScore()) {
                finalStanding = "advantage " + player1.getName();
            } else {
                finalStanding = "advantage " + player2.getName();
            }
        } else if (scoreSum(a, b) >= 4 && isThereAWinner(a, b)) {
            if (a.getScore() > b.getScore()){
                finalStanding = player1.getName() + " won";
            } else if (a.getScore() < b.getScore()) {
                finalStanding = player2.getName() + " won";
            }
        }
        return finalStanding;
    }
    private boolean isDeuce(){
            return player1.getScore() == player2.getScore() && scoreSum(player1, player2) > 3;
    }
    private boolean isThereAWinner(Player a, Player b){
        return Math.abs(a.getScore() - b.getScore()) > 1;
    }
    private int scoreSum(Player a, Player b){
        return a.getScore() + b.getScore();
    }
}
