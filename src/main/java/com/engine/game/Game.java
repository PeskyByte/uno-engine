package com.engine.game;

import com.engine.card.Card;
import com.engine.player.Player;

import java.util.*;

public abstract class Game {

    protected List<Player> players;
    protected Deck drawPile;
    protected Deck discardPile;
    protected int currentPlayerIndex;
    protected boolean counterClockWiseTurn;
    protected String currentColor;
    private Scanner scanner = new Scanner(System.in);

    protected Game() {
        this.players = new ArrayList<Player>();
        this.drawPile = new Deck();
        this.discardPile = new Deck();
        this.currentPlayerIndex = 0;
        this.counterClockWiseTurn = true;
        this.currentColor = "BLACK";
    }

    public final void play() {
        initialize();
        while (!isGameOver()) {
            System.out.println("\nCurrent color is " + currentColor);
            System.out.print("Player " + (currentPlayerIndex + 1) + " Turn: ");
            Player currentPlayer = players.get(currentPlayerIndex);
            Deck currentCards = currentPlayer.getHand();
            System.out.println(currentPlayer.getName());
            playCard(currentCards);
            switchToNextPlayer();
        }
        declareWinner();
        scanner.close();
    }

    public void initialize() {
        createPlayers();
        generateDeck(new DefaultGenerator());
        drawPile.shuffle();
        dealCards(new DefaultDealer());
    }

    public void createPlayers() {
        System.out.print("Enter number of players: ");
        int choice = 0;
        choice = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < choice; i++) {
            System.out.print("Enter name of player " + (i + 1) + ": ");
            String name = scanner.nextLine();
            players.add(new Player(name));
        }
    }

    public void generateDeck(IDeckGenerator generator) {
        if (generator == null) throw new IllegalArgumentException();
        drawPile = generator.generate();
    }

    public void dealCards(ICardDealer dealer) {
        if (dealer == null) throw new IllegalArgumentException();
        dealer.deal(players, drawPile);
    }

    private boolean hasValidCard(Deck currentCards) {
        if (currentColor.equalsIgnoreCase("BLACK")) return true;

        for (Card card : currentCards.getDeck()) {
            if (card.getColor().equalsIgnoreCase(currentColor) ||
                    card.getColor().equalsIgnoreCase("BLACK")) {
                return true;
            }
        }
        return false;
    }

    public void playCard(Deck currentCards) {
        drawValidCardsToHand(currentCards);

        int choice;
        Card playedCard;
        while (true) {
            System.out.println(currentCards);
            System.out.print("Choose card number: ");
            choice = scanner.nextInt();
            System.out.println();
            playedCard = currentCards.drawCard(choice - 1);
            if (currentColor.equalsIgnoreCase("BLACK")) break;
            if (playedCard.getColor().equalsIgnoreCase("BLACK")) break;
            if (playedCard.getColor().equalsIgnoreCase(currentColor)) {
                break;
            }
            players.get(currentPlayerIndex).addCardToHand(playedCard);
            System.out.println("Can't play card with this color.");
        }

        playedCard.play(this);

        if (!playedCard.getType().equalsIgnoreCase("wild_card"))
            currentColor = playedCard.getColor();

        discardPile.addCard(playedCard);
    }

    public void drawValidCardsToHand(Deck currentCards) {
        while (!hasValidCard(currentCards)) {
            System.out.println("No valid Cards, Drawing from pile...");
            currentCards.addCard(drawPile.drawCardFromTop());
        }
    }

    public boolean isGameOver() {
        for (Player player : players)
            if (player.numberOfCardsLeft() == 0)
                return true;

        return false;
    }

    public void declareWinner(){
        for(Player player: players){
            if(player.numberOfCardsLeft() == 0){
                System.out.println("The winner is " + player.getName());
                break;
            }
        }
    }

    public int getNextPlayerIndex() {
        int index;
        if (counterClockWiseTurn) {
            index = currentPlayerIndex - 1;
            if (index < 0) index = players.size() - 1;
        } else {
            index = (currentPlayerIndex + 1) % players.size();
        }
        return index;
    }

    public Player getNextPlayer() {
        return players.get(getNextPlayerIndex());
    }

    public void switchToNextPlayer() {
        currentPlayerIndex = getNextPlayerIndex();
    }

    public Deck getDrawPile() {
        return drawPile;
    }

    public boolean isCounterClockWiseTurn() {
        return counterClockWiseTurn;
    }

    public void setCurrentColor(String currentColor) {
        this.currentColor = currentColor;
    }

    public void setTurnDirection(boolean counterClockWise) {
        this.counterClockWiseTurn = counterClockWise;
    }

}
