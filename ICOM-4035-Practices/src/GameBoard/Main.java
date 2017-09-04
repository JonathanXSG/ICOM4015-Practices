package GameBoard;

import java.util.Scanner;

import com.sun.org.apache.bcel.internal.generic.GOTO;

public class Main {

	static Scanner input = new Scanner(System.in);
	static ScoreBoard scoreBoard;
	
	public static void main(String[] args) {
		System.out.println("Welcome to the ScoreBoard program.\n");
		System.out.println("How many Runners would you like the ScoreBoard to be able to hold?");
		
		scoreBoard = new ScoreBoard(getNumberAnswer());
		System.out.println();
		while(true){
			showMenu();
			menuSelector();
			
		}
	}
	
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
	
	private static void showMenu(){
		System.out.println();
		System.out.println("What would you like to do?");
		System.out.println("1) Show ScoreBoard");
		System.out.println("2) Add runner");
		System.out.println("3) Remove runner");
		System.out.println("4) Edit runner score");
		System.out.println("5) Get runner's rank");
		System.out.println("6) Get runner in rank");
	}
	
	private static void addGameEntry(){
		System.out.println("Provide runner's name: ");
		String name = input.nextLine();
		String answer;
		int score = 0;
		do {
			System.out.println("Would you like to add a score?  yes / no");
			answer =String.valueOf(input.nextLine().toLowerCase());
			
		} while (!answer.equals("yes") && !answer.equals("no"));
		
		if(answer.equals("yes")){
			System.out.println("Provide runner's score: ");
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
	
	private static void removeRunner(){
		System.out.println("Provide runner's name to kick out: ");
		String name = input.nextLine();
		if(scoreBoard.lookUpEntry(name)==-1){
			try {
				throw new Exception("Invalid runner. No such runner in ScoreBoard.");
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
	
	private static void changeRunnerScore(){
		System.out.println("Provide runner's name: ");
		String name = input.nextLine();
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
	
	private static void getRunnerRank(){
		System.out.println("Provide runner's name: ");
		String name = input.nextLine();
		try {
			System.out.println();
			System.out.println("Rank of runner " +name+ " is: "+ scoreBoard.getRankOfRunner(name));
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	private static void getRunnerInRank(){
		System.out.println("Provide rank to search: ");
		try {
			GameEntry ge = scoreBoard.getRunnerInRank(getNumberAnswer());
			System.out.println();
			System.out.println("Player "+ ge.getName() + " is in rank requested: "+ "with " + ge.getScore() + " points");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
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
	
	private static int getNumberAnswer(){
		int answer=0;
		Boolean isNumber = false ;
		do {
			try{
				answer = Integer.parseInt(input.nextLine());
				isNumber =true;
			}
			catch(NumberFormatException e){
				System.out.println("Nope, that's not a number.");
				System.out.println("Provide a number answer.");
				System.out.println();
				isNumber = false;
			}
		} while (!isNumber);
		return answer;
	}

}
