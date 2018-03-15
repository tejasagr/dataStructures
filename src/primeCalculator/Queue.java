/**
 * A collection of objects inserted and removed according to FIFO principle.
 * 
 * Adapted from 'Data Structures and Algorithms' by Tejas Agrawal
 * 
 */



package primeCalculator;

public interface Queue<E> {
	int size();				//returns number of elements in queue
	
	boolean isEmpty();		//tests whether queue is empty
	
	void enqueue(E e);		//inserts an element at the rear of the queue
	
	E first();				//returns, but doesn't remove, first element of queue
							//null if empty
	
	E dequeue();			//removes and returns the first element 
	
}
