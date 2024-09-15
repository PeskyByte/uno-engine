package com.engine;

import com.engine.game.DefaultDealer;
import com.engine.game.DefaultGenerator;
import com.engine.game.Game;

public class CustomGame extends Game {

    private static Game gameSingleton = new CustomGame();

    private CustomGame(){

    }

    public static Game getInstance(){
        return gameSingleton;
    }

    @Override
    public void initialize() {
        createPlayers();
        generateDeck(new DefaultGenerator());
        drawPile.shuffle();
        dealCards(new CustomDealer());
    }
}
