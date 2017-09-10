package GameBoard;

import java.util.Scanner;

public class GameBoardMain {

	static Scanner input = new Scanner(System.in);
	static ScoreBoard scoreBoard;
	
	public static void main(String[] args) {
		System.out.println("Welcome to the ScoreBoard program.\n");
		System.out.println("How many players would you like the ScoreBoard to be able to hold?");
		
		scoreBoard = new ScoreBoard(getNumberAnswer());
		System.out.println();
		while(true){
			showMenu();
			menuSelector();
			
		}
	}
	
	/**
	 * Method displays the ScoreBoard to the user
	 */
	private static void printScoreBoard(){
		GameEntry[] gameEntries = scoreBoard.getScoreBoardEntries();
		System.out.println();
		System.out.println("----------ScoreBoard----------");
		if(gameEntries == null){
			System.out.printf("%18s %n","EMPTY");
		}
		else{
			int count =1;
			for(GameEntry ge : gameEntries){
				if(ge!=null){
					System.out.printf("%d %s %-20s %d %n",count,"-",ge.getName(),ge.getScore());
					count++;
				}
			}
		}
		System.out.println("----------ScoreBoard----------");
		System.out.println();
	}
	
	/**
	 * Displays the Menu for the user
	 */
	private static void showMenu(){
		System.out.println();
		System.out.println("What would you like to do?");
		System.out.println("1) Show ScoreBoard");
		System.out.println("2) Add player");
		System.out.println("3) Remove player");
		System.out.println("4) Edit player score");
		System.out.println("5) Get player's rank");
		System.out.println("6) Get player in rank");
	}
	
	/**
	 * Method is used for adding a new GameEntry to the ScoreBoard
	 * It also handles the exceptions this might cause.
	 */
	private static void addGameEntry(){
		System.out.println("Provide player's name: ");
		String name = input.nextLine();
		String answer;
		int score = 0;
		do {
			System.out.println("Would you like to add a score?  yes / no");
			answer =String.valueOf(input.nextLine().toLowerCase());
			
		} while (!answer.equals("yes") && !answer.equals("no"));
		
		if(answer.equals("yes")){
			System.out.println("Provide player's score: ");
			score = getNumberAnswer();
		}
		try {
			scoreBoard.addGameEntry(new GameEntry(name, score));
			System.out.println();
			System.out.println("Added player " + name+" with "+score+" points");
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}
	
	/**
	 * Method is used for removing a GameEntry to the ScoreBoard
	 * It also handles the exceptions this might cause.
	 */
	private static void removeRunner(){
		System.out.println("Provide player's name to kick out: ");
		String name = input.nextLine();
		if(scoreBoard.lookUpEntry(name)==-1){
			try {
				throw new Exception("Invalid Player. No such player in ScoreBoard.");
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		else{
			try {
				scoreBoard.removeGameEntry(name);
				System.out.println();
				System.out.println("Removed player " + name);
			} catch (Exception e) {
				System.out.println(e);
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Method is used for changing a GameEntry's score.
	 * It also handles the exceptions this might cause.
	 */
	private static void changeRunnerScore(){
		System.out.println("Provide player's name: ");
		String name = input.nextLine();
		
		//Checks if the ScoreBoard has the given player in it. If not, it shows an exception.
		if(scoreBoard.lookUpEntry(name)==-1){
			try {
				throw new Exception("Invalid runner. No such runner in ScoreBoard.");
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		else{
			String answer;
			int score = 0;
			do {
				System.out.println("Would you like to change or add to the score?  change / add");
				answer =String.valueOf(input.nextLine().toLowerCase());
			} while (!answer.equals("add") && !answer.equals("change"));
			
			if(answer.equals("change")){
				System.out.println("Provide new runner's score: ");
				score = getNumberAnswer();
				try {
					scoreBoard.addGameEntry(new GameEntry(name, score));
					System.out.println();
					System.out.println("Changed player " + name+"'s score to "+score);
				} catch (Exception e) {
					System.out.println(e);
				}
			}
			else{
				System.out.println("Provide ammount to increment runner's score by: ");
				score = getNumberAnswer();
				try {
					scoreBoard.incrementGameEntryScore(name, score);
					System.out.println();
					System.out.println("Incremented player " + name+"'s score by "+score);
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		}
	}
	
	/**
	 * Method is used for finding out the rank of a player.
	 * It also handles the exceptions this might cause.
	 */
	private static void getRunnerRank(){
		System.out.println("Provide player's name: ");
		String name = input.nextLine();
		try {
			System.out.println();
			System.out.println("Rank of player " +name+ " is: "+ scoreBoard.getRankOfRunner(name));
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	/**
	 * Method is used for finding out the player in the specified rank. 
	 * It also handles the exceptions this might cause.
	 */
	private static void getRunnerInRank(){
		System.out.println("Provide rank to search: ");
		try {
			GameEntry ge = scoreBoard.getRunnerInRank(getNumberAnswer());
			System.out.println();
			System.out.println("Player "+ ge.getName() + " is in rank requested with " + ge.getScore() + " points");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	/**
	 * Method is used for selecting an option provided in the menu. 
	 */
	private static void menuSelector(){
		int answer= getNumberAnswer();
		switch (answer) {
		case 1:
			printScoreBoard();
			break;
		case 2:
			addGameEntry();
			break;
		case 3:
			removeRunner();
			break;
		case 4:
			changeRunnerScore();
			break;
		case 5:
			getRunnerRank();
			break;
		case 6:
			getRunnerInRank();
			break;
		default:
			System.out.println("That's not actually an option.");
			break;
		}
	}
	
	/**
	 * Method is used for receiving an integer answer from the user.
	 * @return answer of user
	 */
	private static int getNumberAnswer(){
		int answer=0;
		Boolean isNumber = false ;
		do {
			try{
				answer = Integer.parseInt(input.nextLine());
				isNumber =true;
			}
			catch(NumberFormatException e){
				System.out.println("Nope, that's not a number/integer.");
				System.out.println("Provide an integer answer.");
				System.out.println();
				isNumber = false;
			}
		} while (!isNumber);
		return answer;
	}

}
