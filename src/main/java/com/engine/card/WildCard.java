package com.engine.card;

import java.util.Objects;

public abstract class WildCard extends Card {

    WildCard() {
        this.color = "BLACK";
        this.type = "wild";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;

        ActionCard tmp = (ActionCard) obj;
        return Objects.equals(this.color, tmp.color);
    }
}