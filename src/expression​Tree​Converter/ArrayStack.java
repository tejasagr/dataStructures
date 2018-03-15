/**
 * Implementation of Stack interface in Array based way.
 * 
 * Adapted from 'Data Structures and Algorithms' by Tejas Agrawal
 * 
 */

package expression​Tree​Converter;

public class ArrayStack<E> implements Stack<E> {

	public static final int CAPACITY=1000;			//default array capacity
	private E[] data;								//generic array used for storage
	private int t = -1;								//'t' is index of stack's top element
	
	@SuppressWarnings("unchecked")
	public ArrayStack(int capacity) {				//constructor with capacity parameter
		data = (E[]) new Object[capacity];			//safe cast
	}
	
	public ArrayStack() {							//constructor w/o capacity parameter
		this(CAPACITY);								//default is capacity is used
	}
	
	public int size() {								//returns size
		return t + 1;								//size is one greater than top index
	}

	public boolean isEmpty() {						//checks if stack is empty (t/f)
		return t == -1;								//if t=-1, size = 0
	}

	public void push(E e) throws IllegalStateException {
		if (size() == data.length)					//stack is full
			throw new IllegalStateException("Stack is full");
		data[++t] = e;								//increment t, then store e in array
	}

	public E top() {								//take a look at top of stack
		if (isEmpty())
			return null;							//if empty, return null
		
		return data[t];
	}

	public E pop() {								//remove top of stack and return value

		if (isEmpty())								//return null if special case: empty
			return null;
		
		E answer = data[t];
		data[t] = null;								//remove top token, help Garb. collector
		t--;										//reduce 't' to reflect removal
		
		return answer;								//return removed value
	}

}
