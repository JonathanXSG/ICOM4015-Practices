package BalancedStrings;

import java.util.Scanner;
import sLLBasedStack.SLLBasedStack;

public class BalancedStringsTester {

	private static SLLBasedStack<Character> string;
	private static Scanner input = new Scanner(System.in);
	
	public static void main (String[] args) {
		while (true) {
			System.out.println(" Please input string to balance:   include only {}, <>, (), and []");
			boolean isBalanced = false;
			string = new SLLBasedStack<>();
			isBalanced=checkForCharacters(input.nextLine());
			
			if (isBalanced) System.out.println(" This string is balanced");
			else System.out.println(" This string is not balanced.");
		}
	}
	
	
	public static boolean checkForCharacters(String s) {
		for(char c : s.toCharArray()) {
			if(isOpeningSymbol(c)>0) {
				string.push(c);
			}
			else if(isClosingSymbol(c)>0) {
				if(!string.isEmpty()) {
					if (isClosingSymbol(c) == isOpeningSymbol(string.peek())) {
						string.pop();
					}
					else return false;
				}
				else return false;
			}
		}
		return string.isEmpty();
	}

	public static int isOpeningSymbol(Character c) {
		switch(c){
		case('['): return 1;
		case('{'): return 2;
		case('<'): return 3;
		case('('): return 4;
		default: return 0;
		}
	}
	public static int isClosingSymbol(Character c) {
		switch(c){
		case(']'): return 1;
		case('}'): return 2;
		case('>'): return 3;
		case(')'): return 4;
		default: return 0;
		}
	}

}
