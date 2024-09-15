package com.engine.card;

import com.engine.game.Game;

public abstract class Card {
    protected String color;
    protected String type;

    public String getType() {
        return type;
    }

    public String getColor() {
        return color;
    }

    public abstract void play(Game game);

    @Override
    public abstract String toString();
}
