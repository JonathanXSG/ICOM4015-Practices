package sLLBasedStack;

import java.util.Scanner;

public class StackTester {

	private static Scanner input = new Scanner(System.in);
	private static SLLBasedStack<Integer> sllStack;
	
	public static void main(String[] args) {
		sllStack = new SLLBasedStack<>();
		while(true){
			showMenu();
			menuSelector();
		}
	}
	
	/**
	 * Displays the Menu for the user
	 */
	private static void showMenu(){
		System.out.println("There are "+ sllStack.size() + " elements in the stack.");
		System.out.println("What would you like to do?");
		System.out.println("1) Show List elements");
		System.out.println("2) Push element");
		System.out.println("3) Pop element");
		System.out.println("4) Peek element");
	}
	
	/**
	 * Method is used for selecting an option provided in the menu. 
	 */
	private static void menuSelector(){
		int answer= getNumberAnswer();
		switch (answer) {
		case 1:
			printStack();
			break;
		case 2:
			Push();
			break;
		case 3:
			Pop();
			break;
		case 4:
			Peek();
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

	public static <E> void printStack() {
		System.out.println("---------- SLLBasedStack ----------");
		E[] elements = (E[]) sllStack.getElements();
		for (int i=0; i <sllStack.size(); i++) {
			System.out.println("- " + elements[i].toString());
		}
		System.out.println("---------- SLLBasedStack ----------");
		System.out.println();
	}
	
	
	private static void Push(){
		System.out.println("Provide integer number for element: ");
		Integer integer = getNumberAnswer();
		sllStack.push(integer);
		System.out.println("Integer " + integer + " pushed to stack.");
		System.out.println();

	}
	
	private static void Pop(){
		sllStack.pop();
	}
	
	private static void Peek() {
		System.out.println("The element at the top of the stack is: " + sllStack.peek());
		System.out.println();
	}
}
