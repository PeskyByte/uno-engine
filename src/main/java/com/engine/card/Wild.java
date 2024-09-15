package com.engine.card;

import com.engine.game.Game;

import java.util.Scanner;

public class Wild extends WildCard {

    public Wild() {
        super();
        this.type = "wild_card";
    }

    @Override
    public void play(Game game) {
        System.out.println("Played " + toString());
        System.out.print("Enter new color: ");
        Scanner sc = new Scanner(System.in);
        String color = sc.next();
        game.setCurrentColor(color);
    }

    @Override
    public String toString() {
        return "Wild Card";
    }
}
