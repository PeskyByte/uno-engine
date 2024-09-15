package com.engine;

import com.engine.game.Deck;
import com.engine.game.ICardDealer;
import com.engine.player.Player;

import java.util.List;

public class CustomDealer implements ICardDealer {
    @Override
    public void deal(List<Player> players, Deck pile) {
        for(Player player: players){
            for (int i = 0; i < 3; i++) {
                player.addCardToHand(pile.drawCardFromTop());
            }
        }
    }
}
