/**
 * 
 * Class responsible for conversion of infix equation string into postfix equation string.
 * 
 * @author Tejas Agrawal
 * 
 */

package homework;

import java.util.List;
import java.util.Scanner;

public class Converter {
	String infixStr;									//variable to store input in infix
	static Scanner s = new Scanner(System.in);
	
	public Converter(String input) {
		infixStr = input;								//constructor stores infix parameter
	}
	public String toPostFix() {							//converts infix to postfix
		char[] infixChar = infixStr.toCharArray();		//String to char[] in order to parse
		List<String> infixList = ParserHelper.parse(infixChar);	
														//List holds parsed String values
		
		Stack<String> data = new ArrayStack<String>(100);//Stack to hold operators
		String postfix = "";							 //Output postfix string
		
		for (int i=0; i < infixList.size(); i++) {		//iterates through every character
			String tkn = infixList.get(i);				//character stored in n
			
			//tkn is an operand case
			if ( isDigit(tkn.substring(0, 1)) ) {
				postfix += tkn + " ";					//operand onto output string
			}
			
			//n is an operator case
			else if ( tkn.equals("+") || tkn.equals("-") || tkn.equals("*") 
									  || tkn.equals("/") || tkn.equals("^") ) {
				
				int tknPrec = getPrec(tkn);		//figure out which operator has precedence
				int topPrec;
				
				if (data.isEmpty())
					topPrec = -1;
				else
					topPrec = getPrec(data.top());
				
				while (tknPrec <= topPrec) {	//keep popping top while it has higher prec.
					postfix += data.pop() + " ";
					
					if (data.isEmpty())			//if empty, we want to stop the loop
						topPrec = -1;
					else
						topPrec = getPrec(data.top());
				}
				data.push(tkn);			//once token has higher precedence, push onto stack
			}
			
			else if (tkn.equals("(") )	//push open parenthesis onto stack
				data.push(tkn);
			
			else if (tkn.equals(")")) { //keep popping operators till we find other paranth.
				while (!data.top().equals("("))
					postfix += data.pop() + " ";
				data.pop();								//do nothing with the parenthesis
			}
			
		}
		
		while (!data.isEmpty())
			postfix += data.pop() + " "; //pop remaining items off the stack
			
		return postfix;
	}

	
	private static boolean isDigit(String n) { 	//check if string is digit
		return ( n.equals("0") || n.equals("1") || n.equals("2") || n.equals("3") 
							   || n.equals("4") || n.equals("5") || n.equals("6") 
							   || n.equals("7") || n.equals("8") || n.equals("9") );
	}
	
	private static int getPrec(String o) { 		//assigns token operator precedence
		int prec = -1;
		
		if (o.equals("^"))					
			prec = 2;
		else if (o.equals("*") || o.equals("/"))
			prec = 1;
		else if (o.equals("+") || o.equals("-"))
			prec = 0;
		
		return prec;
	}
	
}
