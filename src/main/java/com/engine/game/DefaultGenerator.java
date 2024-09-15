package com.engine.game;

import com.engine.card.*;
import java.util.*;

public class DefaultGenerator implements IDeckGenerator {

    @Override
    public Deck generate() {
        Deck deck = new Deck();
        List<String> colors = new ArrayList<String>();
        colors.add("RED");
        colors.add("GREEN");
        colors.add("BLUE");
        colors.add("YELLOW");

        for (int i = 0; i <= 9; i++) {
            for (String color : colors) {
                deck.addCard(new NumberedCard(color, i));
            }
        }
        for (int i = 1; i <= 9; i++) {
            for (String color : colors) {
                deck.addCard(new NumberedCard(color, i));
            }
        }
        for (int i = 0; i < 2; i++) {
            for (String color : colors) {
                deck.addCard(new Skip(color));
                deck.addCard(new Reverse(color));
                deck.addCard(new DrawTwo(color));
            }
        }
        for (int i = 0; i < 4; i++) {
            deck.addCard(new Wild());
            deck.addCard(new WildDrawFour());
        }
        return deck;
    }
}
