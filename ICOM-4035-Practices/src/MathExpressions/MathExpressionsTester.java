package MathExpressions;

import java.util.Scanner;
import arrayBasedStack.ArrayBasedStack;

public class MathExpressionsTester {

	private static ArrayBasedStack<String> string;
	private static Scanner input = new Scanner(System.in);
	
	public static void main (String[] args) {
		while (true) {
			System.out.println("Please input whole Math Expression:   include only integers, +, -, / and *");
			System.out.println("Ohter simbols/letters will be invalid, divisions will be rounded to the previous Integer.");
			string = new ArrayBasedStack<>();
			String result = null;
			try {
				result = solve(input.nextLine());
				if(result == null) {
					System.out.println("There was an error in your input.");
				}
				else {
					System.out.println("Result: "+ result);
				}
			} catch (Exception e) {
				System.out.println(e);
			}
			System.out.println();
		}
	}

	
	public static String solve(String s) throws Exception {
		Integer number;
		char[] c = s.toCharArray();
		for(int i=0; i<s.length() ; i++) {
			if(Character.isDigit(c[i])) {
				if(!string.isEmpty() && Character.isDigit(c[i-1]) || string.size()==1 && isOperator(string.peek().charAt(0))==2){
					String tempString = string.peek()+c[i];
					string.pop();
					string.push(tempString);
				}
				else {
					string.push(c[i]+"");
				}
			}
			else if(isOperator(c[i])>2) {
				if(!string.isEmpty()) {
					number=Integer.valueOf(string.peek());
					string.pop();
					string.push(doOperation(number,c[i],Character.getNumericValue(c[i+1]))+"");
					i++;
				}
				else throw new Exception("Invalid Math Expression");
			}
			else if(isOperator(c[i])>0 && isOperator(c[i])<3) {
				if(!string.isEmpty()) {
					solvePrevious();
					string.push(c[i]+"");
				}
				else if(isOperator(c[i])==2) {
					string.push(c[i]+"");
				}
				else throw new Exception("Invalid Math Expression");
			}
			else throw new Exception("Invalid Math Expression");
		}
		if(string.size()>2) {
			solvePrevious();
		}
		else if(string.size()>1) {
			throw new Exception("Not enough operands in expression");
		}
		return string.peek();
	}
	
	public static void solvePrevious() {
		Integer number, number2;
		while(string.size()>1) {
			number2=Integer.valueOf(string.peek());
			string.pop();
			Character operator =string.peek().toCharArray()[0];
			string.pop();
			number=Integer.valueOf(string.peek());
			string.pop();
			string.push(doOperation(number,operator,number2)+"");
		}
	}
	
	public static Integer doOperation(Integer num1, char operator, Integer num2) {
		switch(operator){
		case('+'): return num1+num2;
		case('-'): return num1-num2;
		case('/'): return Math.floorDiv(num1, num2);
		case('*'): return num1*num2;
		default: return null;
		}
	}
	
	public static int isOperator(Character c) {
		switch(c){
		case('+'): return 1;
		case('-'): return 2;
		case('/'): return 3;
		case('*'): return 4;
		default: return 0;
		}
	}
}
