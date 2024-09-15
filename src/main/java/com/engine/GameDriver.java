package com.engine;
import com.engine.game.Game;

public class GameDriver {
    public static void main(String[] args) {
        Game game = CustomGame.getInstance();
        game.play();
    }
}