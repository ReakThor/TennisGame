package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


public class GameTest {

    Player victor;
    Player sarah;
    Game game;

    String expected;
    String result;

    @BeforeEach
    public void beforeGameTest() {
        victor = new Player("Victor");
        sarah = new Player("Sarah");
        game = new Game(victor, sarah);
        expected = "";
        result = "";
    }

    @Test
    public void loveShouldBeDescriptionForScore0() {
        Game game = new Game(victor, sarah);
        expected = "love - love";
        result = game.getScores();

        //assertThat(game, hasProperty("score", is("love, love")));
        assertEquals(expected, result);
    }

    @Test
    public void fifteenShouldBeDescriptionForScore1() {
        sarah.winBall();
        expected = "love - fifteen";
        result = game.getScores();

        //assertThat(game, hasProperty("score", is("love, fifteen")));
        assertEquals(expected, result);
    }

    @Test
    public void thirtyShouldBeDescriptionForScore2() {
        victor.winBall();
        victor.winBall();
        sarah.winBall();
        expected = "thirty - fifteen";
        result = game.getScores();

        //assertThat(game, hasProperty("score", is("thirty, fifteen")));
        assertEquals(expected, result);
    }

    @Test
    public void fortyShouldBeDescriptionForScore3() {
        IntStream.rangeClosed(1, 3).forEach((Integer) -> {
            victor.winBall();
        });
        expected = "forty - love";
        result = game.getScores();

        //assertThat(game, hasProperty("score", is("forty, love")));
        assertEquals(expected, result);
    }

    @Test
    public void advantageShouldBeDescriptionWhenLeastThreePointsHaveNeenScoredByEachSideAndPlayerHasOnePointMoreThanHisOpponent() {
        IntStream.rangeClosed(1, 3).forEach((Integer) -> {
            victor.winBall();
        });
        IntStream.rangeClosed(1, 4).forEach((Integer) -> {
            sarah.winBall();
        });
        expected = "advantage Sarah";
        result = game.getScores();

        //assertThat(game, hasProperty("score", is("advantage Sarah")));
        assertEquals(expected, result);
    }

    @Test
    public void deuceShouldBeDescriptionWhenAtLeastThreePointsHaveBeenScoredByEachPlayerAndTheScoresAreEqual() {
        for(int index = 1; index <= 3; index++) {
            victor.winBall();
        }
        for(int index = 1; index <= 3; index++) {
            sarah.winBall();
        }
        expected = "deuce";
        result = game.getScores();
        //assertThat(game, hasProperty("score", is("deuce")));
        assertEquals(expected, result);

        victor.winBall();
        result = game.getScores();
        //assertThat(game, hasProperty("score", is(not("deuce"))));
        assertNotEquals(expected, result);

        sarah.winBall();
        result = game.getScores();
        //assertThat(game, hasProperty("score", is("deuce")));
        assertEquals(expected, result);
    }

    @Test
    public void gameShouldBeWonByTheFirstPlayerToHaveWonAtLeastFourPointsInTotalAndWithAtLeastTwoPointsMoreThanTheOpponent() {
        for(int index = 1; index <= 4; index++) {
            victor.winBall();
        }
        for(int index = 1; index <= 3; index++) {
            sarah.winBall();
        }

        expected = "Sarah won";
        //assertThat(game, hasProperty("score", is(not("Sarah won"))));
        assertNotEquals(expected, result);

        expected = "Victor won";
        result = game.getScores();
        //assertThat(game, hasProperty("score", is(not("Victor won"))));
        assertNotEquals(expected, result);

        victor.winBall();
        result = game.getScores();
        //assertThat(game, hasProperty("score", is("Victor won")));
        assertEquals(expected, result);
    }

    @Test
    public void gameShouldBeWonByTheFirstPlayerWhenScoringFourPointsToLove() {
        victor.winBall();
        victor.winBall();
        victor.winBall();
        victor.winBall();
        expected = "Victor won";
        result = game.getScores();

        //assertThat(game, hasProperty("score", is("Victor won")));
        assertEquals(expected, result);
    }
}