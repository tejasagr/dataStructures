/**
 * A collection of objects inserted and removed according to LIFO principle.
 * 
 * Adapted from 'Data Structures and Algorithms' by Tejas Agrawal
 * 
 */

package homework;

public interface Stack<E> {
	
	int size();				//returns number of elements in stack
	
	boolean isEmpty();		//tests whether the stack is empty
	
	void push(E e);			//inserts an element at the top of the stack
	
	E top();				//returns, but doesn't remove, the element at the top of the stack

	E pop();				//removes and returns the top element from the stack
}
