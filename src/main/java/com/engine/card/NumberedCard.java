package com.engine.card;

import com.engine.game.Game;

import java.util.Objects;

public class NumberedCard extends Card implements Comparable<NumberedCard> {
    private final int value;

    public NumberedCard(String color, int value) {
        this.value = value;
        this.color = color;
        this.type = "numbered";
    }

    @Override
    public void play(Game game) {
        System.out.println("Played " + toString());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;

        NumberedCard tmp = (NumberedCard) obj;
        return this.value == tmp.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.value, this.color);
    }

    @Override
    public int compareTo(NumberedCard numberedCard) {
        if (numberedCard == null) throw new IllegalArgumentException();
        if (this.value == numberedCard.value) return 0;
        return this.value > numberedCard.value ? 1 : -1;
    }

    @Override
    public String toString() {
        return color + " " + value;
    }
}
