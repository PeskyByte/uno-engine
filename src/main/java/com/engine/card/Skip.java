package com.engine.card;

import com.engine.game.Game;

public class Skip extends ActionCard {

    public Skip(String color) {
        super(color);
    }

    @Override
    public void play(Game game) {
        System.out.println("Played " + toString());
        game.switchToNextPlayer();
    }

    @Override
    public String toString() {
        return color + " Skip";
    }
}
