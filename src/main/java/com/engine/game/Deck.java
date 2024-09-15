package com.engine.game;

import com.engine.card.Card;

import java.util.*;

public class Deck {
    private List<Card> deck;

    public Deck() {
        deck = new ArrayList<Card>();
    }

    public void shuffle() {
        Collections.shuffle(deck);
    }

    public Card drawCard(int index) {
        return deck.remove(index);
    }

    public Card drawCardFromTop() {
        return drawCard(0);
    }

    public void addCard(Card card) {
        if (card == null) throw new IllegalArgumentException();
        deck.add(card);
    }

    public int getDeckSize() {
        return deck.size();
    }

    public List<Card> getDeck() {
        return deck;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        int index = 1;
        for(Card card: deck){
            s.append(index).append("- ").append(card.toString()).append('\n');
            index++;
        }
        return s.toString();
    }
}
