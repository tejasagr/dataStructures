/**
 * Realization of a FIFO queue as an adaption of a SinglyLinkedList.
 * 
 * Adapted from 'Data Structures and Algorithms' by Tejas Agrawal
 * 
 */

package primeCalculator;

public class LinkedQueue<E> implements Queue<E> {
	
	private SinglyLinkedList<E> list = new SinglyLinkedList<>(); //empty list
	
	public LinkedQueue() { }		//new queue relies on initially empty list

	public int size() {
		return list.size();
	}

	public boolean isEmpty() {
		return list.isEmpty();
	}

	public void enqueue(E e) {
		list.addLast(e);
	}

	public E first() {
		return list.first();
	}

	public E dequeue() {
		return list.removeFirst();
	}

}
