/**
 * 
 * Class used for arithmetic calculations involving main five operators. Works by converting
 * infix equation into postfix and then solving.
 * 
 * @author Tejas Agrawal
 * 
 */

package homework;

import java.util.List;
import java.util.Scanner;

public class PostfixCalculator {
	static Scanner keyboard = new Scanner(System.in);
	static String postfix;
	static double answer;
	
	public static void main (String[] args) {
		System.out.println("type your infix expression: ");
		Converter c = new Converter(keyboard.nextLine());	//take user equation
															//instantiate converter object
		
		postfix = c.toPostFix();							//convert user equation to postfix
		System.out.println("converted to postfix: " + postfix);
		
		answer = calc(postfix);								//complete calculation of postfix
		System.out.println("answer is " + answer);
	}

	public static double calc(String equation) {	//completes pfix calculation
		List<String> tokens = ParserHelper.parse(equation.toCharArray());
													//list of pfix tokens
		String tkn;									//indiv. token being evaluated each time
		Stack<Double> operands = new ArrayStack<Double>(100);
													//stack of operands
		double num1, num2;							//nums to be evaluated
		
		for (int i = 0; i < tokens.size(); i++) {	//traverse through postfix equation tokens
			tkn = tokens.get(i);
			
			if (isNum(tkn))		//if number, push to stack
				operands.push(Double.parseDouble(tkn));
			
			else if (isOperator(tkn)) {				//if operator, need to make calculation
				num2 = operands.pop();				//2nd number is popped first
				num1 = operands.pop();				//order is important
				
				operands.push(arithmetic(num1, num2, tkn));	//arithmetic calculation
			}
			
		}
		
		return operands.pop();						//should be one number left in stack, answer
	}	
	
	private static boolean isNum(String s) {		//checks if token is a number
		String n = s.substring(0, 1);
		
		return ( n.equals("0") || n.equals("1") || n.equals("2") || n.equals("3") 
							   || n.equals("4") || n.equals("5") || n.equals("6") 
							   || n.equals("7") || n.equals("8") || n.equals("9") );
	}
	
	private static boolean isOperator(String n) {	//checks if token is an operator
		return ( n.equals("+") || n.equals("-") || n.equals("*") 
				  			   || n.equals("/") || n.equals("^") );
	}

	public static double arithmetic (double arg1, double arg2, String operator) {
		double ans;							//figures out operation based on operator token
											//then completes calculation, returns ans

		if (operator.equals("^"))
			ans = Math.pow(arg1, arg2);
		else if (operator.equals("*"))
			ans = arg1 * arg2;
		else if (operator.equals("/"))
			ans = arg1 / arg2;
		else if (operator.equals("+"))
			ans = arg1 + arg2;
		else if (operator.equals("-"))
			ans = arg1 - arg2;
		else
			ans = 0;
		
		return ans;
	}
	
}