package doublyLinkedList;

import java.util.Scanner;

public class DLLMain <E> {

	static XLinkedList<Integer> dlList = new XDoublyLinkedList<Integer>();
	static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		//Test values for ease of testing
		dlList.addFirst(10);
		dlList.addFirst(10);
		dlList.addFirst(10);
		dlList.addFirst(10);
		dlList.addFirst(50);
		dlList.addFirst(60);
		dlList.addFirst(70);
		dlList.addFirst(80);
		dlList.addFirst(90);
		
		while(true){
			showMenu();
			menuSelector();
		}
		
	}

	/**
	 * Displays the Menu for the user
	 */
	private static void showMenu(){
		System.out.println();
		System.out.println("What would you like to do?");
		System.out.println("1) Show List elements");
		System.out.println("2) Add element");
		System.out.println("3) Remove element");
		System.out.println("4) Edit element");
		System.out.println("5) Get element");
	}
	
	/**
	 * Method is used for selecting an option provided in the menu. 
	 */
	private static void menuSelector(){
		int answer= getNumberAnswer();
		switch (answer) {
		case 1:
			printList();
			break;
		case 2:
			addElement();
			break;
		case 3:
			removeElement();
			break;
		case 4:
			editElement();
			break;
		case 5:
			getElement();
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
	
	private static <E> void printList(){
		System.out.println();
		System.out.println("---------- List elements ----------");
		for(int i=0 ; i < dlList.size(); i++){
			try {
				System.out.println(dlList.getNode(i));
			} catch (Exception e) {
				System.out.println(i);
			}
		}
		System.out.println("---------- List elements ----------");
	}
	
	private static void addElement(){
		System.out.println("Where would you like to add the element?");
		System.out.println("At head= [-2]    at tail[-1]    at index location [0...]");
		Integer position = getNumberAnswer();
		System.out.println("Provide integer number for element: ");
		Integer integer = getNumberAnswer();
		
		if(position==-2) dlList.addFirst(integer);
		
		else if(position == -1) dlList.addLast(integer);
		
		else if(position >=0 && position <=dlList.size())
			try {
				dlList.addAtPosition(position, integer);
			} catch (Exception e) {
				System.out.println(e);
			}
		
		else System.out.println("That's not an option");
	}
	
	private static void removeElement(){
		System.out.println("Where would you like to remove an element?");
		System.out.println("At head= [0]    at tail[1]");
		Integer position = getNumberAnswer();
		
		if(position==0) dlList.removeFirst();
		
		else if(position == 1) dlList.removeLast();

		else System.out.println("That's not an option");
	}

	private static void editElement(){
		System.out.println("How would you like to edit an element?");
		System.out.println("replaceFirstByVal [0]    replaceLastByVal [1]    replaceAllByVal [2]    replaceAtIndex [3]");
		Integer answer = getNumberAnswer();		
		try {
			if(answer>=0 && answer <3){
				System.out.println("Provide integer number for element to look for: ");
				Integer oldVal = getNumberAnswer();
				System.out.println("Provide new integer number for element: ");
				Integer newVal = getNumberAnswer();

				switch (answer) {
				case 0:
					dlList.replaceFirstByVal(oldVal, newVal);
					break;
				case 1:
					dlList.replaceLastByVal(oldVal, newVal);
					break;
				case 2:
					dlList.replaceAllByVal(oldVal, newVal);
					break;
				}

			}
			else if (answer ==3){
				System.out.println("Provide index to replace.");
				Integer position = getNumberAnswer();
				System.out.println("Provide new integer number for element: ");
				Integer newVal = getNumberAnswer();
				dlList.replaceAtIndex(position, newVal);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private static void getElement(){
		System.out.println("Provide index location [0...]");
		Integer position = getNumberAnswer();
		try {
			System.out.println(dlList.getNode(position));
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		
	}

}
