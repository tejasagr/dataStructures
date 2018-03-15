package linkedListProblems;

public class FastMaxStack<E extends Comparable<E>> implements MaxStack<E> {

	private Node<E> top;
	private Node<E> maxTop;				//top of the stack with maxes
	
	
	@Override
	public boolean isEmpty() {
		return top == null;
	}

	@Override
	public void push(E element) {
		top = new Node<E>(element, top);
		
		if (maxTop == null) {			//if stack is empty, new element is max at the level
			maxTop = new Node<E>(element, null);
			return;
		}
		
		E newMax = getMax( element , maxTop.getElement() );	//gets new max at this level
		maxTop = new Node<E>(newMax, maxTop);				//stores newMax at the head of maxTop
	}

	@Override
	public E pop() {
		
		if (isEmpty())
			return null;
		
		E element = top.getElement();
		top = top.getNext();
		maxTop = maxTop.getNext();
				
		return element;
	}

	@Override
	public E getMaxSoFar() {
		if(isEmpty())
			return null;
		
		return maxTop.getElement();
	}

	//nolan added helper function
	private E getMax(E element1, E element2) {
		if(element1 == null)
			return element2;
		
		if(element2 == null)
			return element1;
		
		if(element1.compareTo(element2)>0)
			return element1;
		
		return element2;
	}
}