package expression​Tree​Converter;

import java.util.Scanner;
import homework.Converter;

public class ExpressionTree {
	char element;
	ExpressionTree leftChild;
	ExpressionTree rightChild;
	
	public ExpressionTree(char c) {
		element = c;
		leftChild = null;
		rightChild = null;
	}
	
	public ExpressionTree(char c, ExpressionTree l, ExpressionTree r) {
		element = c;
		leftChild = l;
		rightChild = r;
	}
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner keyboard = new Scanner(System.in);
		boolean carryOn = true;
		
		
		while (carryOn) {	
			System.out.println("Type your expression:");
			Converter conv = new Converter(keyboard.nextLine());
		
			ExpressionTree tree = convert(conv.toPostFix());
		
		
			System.out.print("Prefix: "  );
			tree.prefix();
			System.out.println();
		
			System.out.print("Infix: "   );
			tree.infix();
			System.out.println();
		
			System.out.print("Postfix: " );
			tree.postfix();
			System.out.println();
			
			System.out.println();
			System.out.print("Would you like to enter another expression? (y/n): ");
			if(keyboard.nextLine().equals("n")) {
				carryOn = false;
				System.out.println();
				System.out.println("Terminated.");
			}
			System.out.println("-----------");
			System.out.println("");
		}
		
		
	}
	
	static ExpressionTree convert(String pfExp) {
		Stack<ExpressionTree> stack = new ArrayStack<ExpressionTree>();
		
		for (int i = 0; i < pfExp.length(); i++) {
			char tkn = pfExp.charAt(i);
			
			if ( isNum(tkn) ) {
				stack.push(new ExpressionTree(tkn));
			}
			
			else if ( isOper(tkn) ) {
				ExpressionTree operator = new ExpressionTree(tkn);
				operator.rightChild = stack.pop();
				operator.leftChild = stack.pop();
				
				stack.push( operator );
			}		
		}
		
		return stack.pop();
	}
	
	void prefix() {
		System.out.print(this);
		
		if (leftChild != null)
			leftChild.prefix();
		
		if (rightChild != null)
			rightChild.prefix();
	}
	
	void infix() {
		if (leftChild != null) {
			System.out.print("(");
			leftChild.infix();
		}
		
		System.out.print(this);
		
		if (rightChild != null) {
			rightChild.infix();
			System.out.print(")");
		}
	}
	
	void postfix() {
		if (leftChild != null)
			leftChild.postfix();
		
		if (rightChild != null)
			rightChild.postfix();
		
		System.out.print(this);
	}
	
	private static boolean isNum(char c) {
		return ( c == '0' || c == '1' || c == '2' || c == '3' || c == '4' || 
				 c == '5' || c == '6' || c == '7' || c == '8' || c == '9' );
	}
	
	private static boolean isOper(char c) {
		return ( c == '+' || c == '-' || c == '*' || c == '/' );
	}
	
	public String toString() {
		return String.valueOf(element);
	}
	
}
