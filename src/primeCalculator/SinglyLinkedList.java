/**
 * Data structure consisting of a collection of nodes in a linear sequence.
 * 
 * Adapted from 'Data Structures and Algorithms' by Tejas Agrawal
 * 
 */

package primeCalculator;


public class SinglyLinkedList<E> {
	
	//nested node class
	private static class Node<E> {
		private E element;					//element stored at this node
		private Node<E> next;				//next node in the list
		public Node(E e, Node<E> n) {
			element = e;
			next = n;
		}
		
		public E getElement() {
			return element;
		}
		
		public Node<E> getNext() {
			return next;
		}
		
		public void setNext(Node<E> n) {
			next = n;
		}
	}
	
	//instance variables of the SinglyLinkedList
	private Node<E> head = null;	//head node of the list (or null if empty)
	private Node<E> tail = null;	//last node of the list (or null if empty)
	private int size = 0;			//number of nodes in the list
	public SinglyLinkedList() {}	//constructs an initially empty list
	
	//access methods
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public E first() {				//returns, without removing, the first element
		if (isEmpty())
			return null;
		return head.getElement();
	}
	
	public E last() {				//returns, without removing, the last element
		if (isEmpty())
			return null;
		return tail.getElement();
	}
	
	//update methods
	public void addFirst(E e) {		//adds E to the front of the list
		head = new Node<>(e, head);	//create and link a new node
		if (size == 0)
			tail = head;			//if we're adding first element, make it tail as well
		size++;
	}
	
	public void addLast(E e) {		//adds element to the end of the list
		Node<E> newest = new Node<>(e, null);	//node will eventually be tail
		if (isEmpty())
			head = newest;			//special case: previously empty list
		else 
			tail.setNext(newest);	//new node after existing tail
		tail = newest;				//new node becomes the tail
		size++;
	}
	
	public E removeFirst() {		//removes and returns the first element
		if (isEmpty())				//nothing to remove
			return null;
		E ans = head.getElement();
		head = head.getNext();		//will become null if list had only one node
		size--;
		if (isEmpty())
			tail = null;			//special case as list is now empty
		return ans;
	}
}