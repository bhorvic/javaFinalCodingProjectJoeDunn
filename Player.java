package javaFinalCodingProject;

import java.util.ArrayList;
import java.util.List;

public class Player {

	String name;
	List<Card> hand = new ArrayList<Card>();
	int score;
	
	//Define the Player
	Player(String name, List<Card> hand, int score) {
		this.name = name;
		this.hand = hand;
		this.score = score;
	}
	
	//Getters and setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Card> getHand() {
		return hand;
	}
	public void setHand(List<Card> hand) {
		this.hand = hand;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	//Define methods
	public void describe() {
	    System.out.println(this.name + "'s hand is:");
	    for (Card card : hand) {
	        card.describe();
	    }
	    System.out.println("They currently have " + this.score + " points");
	}
	
	public Card flip() {
		Card flip = hand.remove(0);
		return flip;
	}
	
	public void draw(Deck deck) {
		Card drawnCard = deck.draw();
		hand.add(drawnCard);
	}
	
	public void incrementScore() {
		this.score++;
	}
	
}
