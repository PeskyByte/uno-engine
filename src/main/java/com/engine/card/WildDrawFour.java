package com.engine.card;

import com.engine.game.*;
import com.engine.player.Player;

public class WildDrawFour extends WildCard {

    public WildDrawFour() {
        super();
    }

    @Override
    public void play(Game game) {
        System.out.println("Played " + toString());
        Player player = game.getNextPlayer();
        Deck deck = game.getDrawPile();
        for (int i = 0; i < 4; i++) {
            player.addCardToHand(deck.drawCardFromTop());
        }
    }

    @Override
    public String toString() {
        return "Wild Draw Four";
    }
}
