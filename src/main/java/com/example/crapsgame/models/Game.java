package com.example.crapsgame.models;

import java.util.Random;

public class Game {
    private int point;
    private int winGames;
    private int lossGames;
    private int score;
    private Random random = new Random();
    private boolean pointEstablished;
    private int dice1;
    private int dice2;

    private int rollDices() {
        dice1 = random.nextInt(6) + 1;
        dice2 = random.nextInt(6) + 1;
        score = dice1 + dice2;
        return score;
    }

    public void playGame() {
        rollDices();

        if (!pointEstablished) {
            if (score == 7 || score == 11) {
                winGames++;
            } else if (score == 2 || score == 3 || score == 12) {
                lossGames++;
            } else {
                point = score;
                pointEstablished = true;
            }
        } else {
            if (score == point) {
                winGames++;
                pointEstablished = false;
            } else if (score == 7) {
                lossGames++;
                pointEstablished = false;
            }
        }
    }

    public int getWinGames() {
        return winGames;
    }

    public int getLossGames() {
        return lossGames;
    }

    public int getPoint() {
        return point;
    }

    public boolean isPointEstablished() {
        return pointEstablished;
    }

    public int getDice1() {
        return dice1;
    }

    public int getDice2() {
        return dice2;
    }
}