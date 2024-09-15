package com.engine.gamemanager;
import com.engine.card.Card;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    List<Card> deck;

    public Deck(){
        deck = new ArrayList<Card>();
    }

    public void shuffle(){
        Collections.shuffle(deck);
    }

    public Card drawCard(int index){
        return deck.remove(index);
    }

    public Card drawCardFromTop(){
        return drawCard(0);
    }

    public Card drawCardFromBottom(){
        return drawCard(deck.size()-1);
    }

    public Card drawCardFromMiddle(){
        return drawCard(deck.size()/2);
    }
}
