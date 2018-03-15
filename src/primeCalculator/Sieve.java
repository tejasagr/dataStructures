/**
 * A calculator of prime numbers up until user given max. Utilizes algorithm
 * known as Sieve of Eratosthenes.
 * 
 * @author Tejas Agrawal
 * 
 */

package primeCalculator;

import java.util.Scanner;

public class Sieve {
	static Scanner keyboard;

	public static void main(String[] args) {
		keyboard = new Scanner(System.in);
		Sieve s = new Sieve();
		
		System.out.println("Please enter upper bound");
		int n = keyboard.nextInt();
		
		if (n >= 2)
			s.primesTo(n);						//find and print the prime numbers up till int n
		else
			System.out.println("Error: Input must be a number greater than 2.");
	}
	
	public void primesTo(int n) {
		Queue<Integer> numbers = fillNum(n);	//queue of numbers from 2 to n
		Queue<Integer> primes = new LinkedQueue<Integer>();
		
		int p = numbers.first();				//first prime no: 2
		
		while (p <= Math.sqrt(n)) {				//once p > n^(1/2), rem. numbers must be prime
			primes.enqueue(p);					//p is prime
			numbers = this.eliminateMultiplesOf(numbers, p);
			p = numbers.first();				//first num left in numbers is prime
			
		}
		
		while(!numbers.isEmpty())				//remaining numbers are primes, move them all
			primes.enqueue(numbers.dequeue());
	
		int size = primes.size(); 				//store this for the loop
												//size will change as we dequeue
		
		System.out.print("Primes up to " + n + " are: ");
		for (int i = 0; i < size-1; i++)		//print results
			System.out.print(primes.dequeue() + ", ");
		System.out.print(primes.dequeue());
		
	}
	
	public Queue<Integer> fillNum(int n) {		//fills and returns a Queue of ints 2 to n
		Queue<Integer> nums = new LinkedQueue<Integer>();
		for (int i = 2; i <= n; i++)			
			nums.enqueue(i);					//i is the numbers from 2 to n
		return nums;
	}
	
	public Queue<Integer> eliminateMultiplesOf(Queue<Integer> data, int factor) {
												//takes a Queue  of integers
												//returns another without multiples of n

		Queue<Integer> ans = new LinkedQueue<Integer>();
												//queue of non multiples
		
		int size = data.size();					//save size now as it will change later
		
		for (int i = 0; i < size; i++) {
			int arg = data.dequeue();			//remove and store first value
			if (arg % factor != 0)				//if not multiple of n
				ans.enqueue(arg);				//add to new Q of non-multiples
		}
												//once we have traversed through data completely
		return ans;								//replace data with queue 'ans' of non multiples
	}
	
}
