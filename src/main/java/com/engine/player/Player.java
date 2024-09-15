package com.engine.player;

import com.engine.card.Card;
import com.engine.game.Deck;

public class Player {
    private final String name;
    private int score;
    private final Deck hand;

    public Player(String name) {
        this.name = name;
        this.score = 0;
        hand = new Deck();
    }

    public Deck getHand() {
        return hand;
    }

    public void addCardToHand(Card card) {
        hand.addCard(card);
    }

    public int numberOfCardsLeft() {
        return hand.getDeckSize();
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + ", score: " + score;
    }

}
