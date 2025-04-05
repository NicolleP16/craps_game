package com.example.crapsgame.controllers;

import com.example.crapsgame.models.AlertBox;
import com.example.crapsgame.models.Dice;
import com.example.crapsgame.models.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class GameController {

    @FXML
    private Button helpButton;

    @FXML
    private Label nicknameLabel;

    @FXML
    private Label rollScoreLabel;

    @FXML
    private ImageView diceImageView1;

    @FXML
    private ImageView diceImageView2;

    private Player player;

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void showNicknameLabel() {
        nicknameLabel.setText(player.getNickname());
    }

    @FXML
    void onActionPlayButton(ActionEvent event) {
        Dice dice1 = new Dice();
        Dice dice2 = new Dice();

        int rollScore = dice1.roll() + dice2.roll();

        this.diceImageView1.setImage(new Image(getClass().getResourceAsStream(
                dice1.getDiceImagePath()
        )));
        this.diceImageView2.setImage(new Image(getClass().getResourceAsStream(
                dice2.getDiceImagePath()
        )));
        this.rollScoreLabel.setText(String.valueOf(rollScore));
    }

    @FXML
    private void showHelp(ActionEvent event) {
        String instructions = """
            REGLAS DEL CRAPS:
            
            1. Primer tiro:
               - 7 u 11: ¡Ganas automáticamente!
               - 2, 3 o 12: ¡Craps! Pierdes.
               - Otro número (4,5,6,8,9,10): Establece el "punto".
            
            2. Tiros posteriores:
               - Si sacas el punto antes que un 7: ¡Ganas!
               - Si sacas un 7 antes que el punto: Pierdes.
            """;

        new AlertBox().showAlertBox(
                "Instrucciones del Juego",
                "Cómo jugar Craps",
                instructions
        );
    }
}