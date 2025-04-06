package com.example.crapsgame.models;

public class Dice {

    int value;

    String IMAGES_PATH = "/com/example/crapsgame/imeges/dices/dice";

    public void setValue(int value) {
        this.value = value;
    }

    public String getDiceImagePath() {
        return IMAGES_PATH + Integer.toString(this.value) + ".png";
    }
}
