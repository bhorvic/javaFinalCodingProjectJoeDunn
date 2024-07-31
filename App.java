package javaFinalCodingProject;

import java.util.ArrayList;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {

		//Scanner because reasons
		Scanner scanner = new Scanner(System.in);
		
		//Instantiate the deck and players
		Deck deck = new Deck();
		Player player1 = new Player("Billy", new ArrayList<>(), 0);
		Player player2 = new Player("Susie", new ArrayList<>(), 0);
		
		//Shuffle dem cards
		deck.shuffle();
		
		//Time for people to draw
		for (int i = 0; i < 26; i++) {
			player1.draw(deck);
			player2.draw(deck);
		}
		
		//Now it's time to play the game! What follows sets up the game logic
		for (int i = 0; i < 26; i++) {
			Card card1 = player1.flip();
			System.out.println(player1.getName() + " plays " + card1.describe());
			Card card2 = player2.flip();
			System.out.println(player2.getName() + " plays " + card2.describe());
			
			//Depending on which Player's card is higher, the score is adjusted
			if (card1.getValue() > card2.getValue()) {
				player1.incrementScore();
				System.out.println(player1.getName() + " wins this time!");
			} else if (card2.getValue() > card1.getValue()) {
				player2.incrementScore();
				System.out.println(player2.getName() + " wins this time!");
			} else {
				System.out.println("Tie! Wait, there are no ties in WAR!");
			}
			
			//These print statements update the user on the score of the game, and the scanner allows the user to advance the iteration one turn further
			System.out.println(player1.getName() + "'s score is: " + player1.getScore() + "\n" + player2.getName() + "'s score is: " + player2.getScore() + "\n");
			System.out.println("Press ENTER for next turn");
			scanner.nextLine();
		}

		//This is the logic that checks the win condition once the loop has completed and assigns a winner!
		if (player1.getScore() > player2.getScore()) {
			System.out.println(player1.getName() + " wins! Their final score is: " + player1.getScore());
		} else if (player2.getScore() > player1.getScore()) {
			System.out.println(player2.getName() + " wins! Their final score is: " + player2.getScore());
		} else {
			System.out.println("Stalemate!");
		}
		scanner.close();
	
	}

}
