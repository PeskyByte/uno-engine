package com.engine;

import com.engine.game.Game;

public class DefaultGame extends Game {

    private static Game gameSingleton = new DefaultGame();

    private DefaultGame(){

    }

}
