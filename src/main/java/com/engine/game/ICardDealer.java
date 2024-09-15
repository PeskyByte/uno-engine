package com.engine.game;

import com.engine.player.Player;

import java.util.List;

public interface ICardDealer {
    public void deal(List<Player> players, Deck pile);
}
