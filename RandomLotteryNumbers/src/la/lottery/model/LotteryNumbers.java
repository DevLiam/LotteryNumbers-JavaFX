package la.lottery.model;

import java.util.Random;

public class LotteryNumbers {
	
	private int numberOfPicks;
	private int maxNumber;
	private int numberOfGames;
	private String numberSelectionString;
	
	private Random randomGenerator;
	
	public LotteryNumbers() {
		this.numberOfPicks = 6;
		this.numberOfGames = 8;
		this.maxNumber = 45;
		this.numberSelectionString = "";
		this.randomGenerator = new Random();
	}
	
	/**
	 * Constructor for a new Random Lottery Number generator. 
	 * Sets the output string as empty - ready for new numbers.
	 * 
	 * @param numberOfPicks
	 * @param maxNumber
	 * @param numberOfGames
	 */
	public LotteryNumbers(int numberOfPicks, int maxNumber, int numberOfGames) {
		
		this.numberOfPicks = numberOfPicks;
		this.maxNumber = maxNumber;
		this.numberOfGames = numberOfGames;
		this.numberSelectionString = "";
		this.randomGenerator = new Random();
	}
	
	// ==============================================================================
	// Accessors
	// ==============================================================================
	
	public void setNumberOfPicks(int numberOfPicks) {
		this.numberOfPicks = numberOfPicks;
	}
	
	public void setMaxNumber(int maxNumber) {
		this.maxNumber = maxNumber;
	}
	
	public void setNumberOfGames(int numberOfGames) {
		this.numberOfGames = numberOfGames;
	}
	
	public void setNumberSelectionString(String numberSelectionString) {
		this.numberSelectionString = numberSelectionString;
	}
	
	public int getNumberOfPicks() {
		return this.numberOfPicks;
	}
	
	public int getMaxNumber() {
		return this.maxNumber;
	}

	public int getNumberOfGames() {
		return this.numberOfGames;
	}
	
	public String getNumberSelectionString() {
		return this.numberSelectionString;
	}
	
	// ================================================================================
	// Output String Management
	// ================================================================================
	
	public void clearNumberSelectionString() {
		this.numberSelectionString = "";
	}
	
	private void appendToNumberSelectionString(String string) {
		this.numberSelectionString += string + "\n";
	}
	
	// ================================================================================
	// Random Draw Calculation
	// ================================================================================
	
	public void generateFullRandomTickets() {
		clearNumberSelectionString();
		for (int i = 1; i <= this.getNumberOfGames(); i++) 
			generateRandomDraw(i);
	}
	
	private void generateRandomDraw(int draw) {
		String ticketString = draw + ".    ";
		
		for (int i = 0; i < this.getNumberOfPicks(); i++) {
			int number = this.randomGenerator.nextInt(this.maxNumber) + 1;
			ticketString += number  + "  ";
		}
		
		appendToNumberSelectionString(ticketString);
	}
}
