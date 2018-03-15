package recursion;

public class Fibonnaci {

	public static void main(String[] args) {
		System.out.println("Fibonnaci 0 is " + calc(0));
		System.out.println("Fibonacci 1 is " + calc(1));
		System.out.println("Fibonacci 2 is " + calc(2));
		System.out.println("Fibonacci 3 is " + calc(3));
		System.out.println("Fibonacci 4 is " + calc(4));
		System.out.println("Fibonacci 10 is " + calc(10));
		System.out.println("Fibonacci 25 is " + calc(25));
	}

	
	public static int calc (int inp) {
		int ans;

		if (inp == 0 || inp == 1) {
			ans = inp;
		}
		else {
			ans = calc(inp - 1) + calc(inp - 2);
		}
		
		return ans;
	}
	
}
