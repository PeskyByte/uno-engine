package com.engine.game;

import com.engine.player.Player;

import java.util.List;

public class DefaultDealer implements ICardDealer {

    @Override
    public void deal(List<Player> players, Deck pile) {
        for(Player player: players){
            for (int i = 0; i < 7; i++) {
                player.addCardToHand(pile.drawCardFromTop());
            }
        }
    }
}
