package com.engine.card;

import com.engine.game.Game;

public class Reverse extends ActionCard {

    public Reverse(String color) {
        super(color);
    }

    @Override
    public void play(Game game) {
        System.out.println("Played " + toString());
        game.setTurnDirection(!game.isCounterClockWiseTurn());
    }

    @Override
    public String toString() {
        return color + " Reverse";
    }
}
