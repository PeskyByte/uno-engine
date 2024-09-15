package com.engine;

import com.engine.gamemanager.Deck;
import com.engine.player.Player;
import java.util.ArrayList;
import java.util.List;

public abstract class Game {

    protected List<Player> players;
    protected Deck drawPile;
    protected Deck discardPile;
    protected int currentPlayerIndex;

    public Game() {
        this.players = new ArrayList<Player>();
        this.drawPile = new Deck();
        this.discardPile = new Deck();
        this.currentPlayerIndex = 0;
    }

    public void play() {
        generateDeck();
        dealCards();
        simulate();
    }

    public abstract void generateDeck();

    public abstract void dealCards();

    public void simulate(){

    }

    public abstract boolean isGameOver();

}
