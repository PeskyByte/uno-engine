package com.engine.card;

import com.engine.game.*;
import com.engine.player.Player;

public class DrawTwo extends ActionCard {

    public DrawTwo(String color) {
        super(color);
    }

    @Override
    public void play(Game game) {
        System.out.println("Played " + toString());
        Player player = game.getNextPlayer();
        Deck pile = game.getDrawPile();
        for (int i = 0; i < 2; i++) {
            player.addCardToHand(pile.drawCardFromTop());
        }
    }

    @Override
    public String toString() {
        return color + " Draw Two";
    }

}
