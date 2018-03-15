package quizPractice;

import javax.swing.JOptionPane;

// BinaryHeap class
//
// CONSTRUCTION: with optional capacity (that defaults to 100)
//
// ******************PUBLIC OPERATIONS*********************
// void insert( x )	   --> Insert x
// Comparable deleteMin( )--> Return and remove smallest item
// Comparable findMin( )  --> Return smallest item
// boolean isEmpty( )	 --> Return true if empty; else false
// boolean isFull( )	  --> Return true if full; else false
// void makeEmpty( )	  --> Remove all items
// ******************ERRORS********************************
// Throws Overflow if capacity exceeded

/**
 * Implements a binary heap.
 * Note that all "matching" is based on the compareTo method.
 * @author Mark Allen Weiss
 */
public class BinaryHeap
{
	/**
	 * Construct the binary heap.
	 */
	public BinaryHeap( )
	{
		this( DEFAULT_CAPACITY );
	}

	/**
	 * Construct the binary heap.
	 * @param capacity the capacity of the binary heap.
	 */
	public BinaryHeap( int capacity )
	{
		currentSize = 0;
		array = new Comparable[ capacity + 1 ];
	}

	/**
	 * Construct the binary heap.
	 * @param an array to be heapified.  Note it is assumed this array does
	 * not have data stored in the zeroth element
	 */
	@SuppressWarnings("rawtypes")
	public BinaryHeap( Comparable [] array )
	{
		int i = 1;
		while (i <= array.length -1 && array[i] != null)
			i++;
		currentSize = i-1;
		this.array = array;
		buildHeap();
	}

	/**
	 * Insert into the priority queue, maintaining heap order.
	 * Duplicates are allowed.
	 * @param x the item to insert.
	 * @exception Overflow if container is full.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void insert( Comparable x ) throws UnderflowException
	{
		if( isFull( ) )
			throw new UnderflowException( );

			// Percolate up
		int hole = ++currentSize;
		for( ; hole > 1 && x.compareTo( array[ hole / 2 ] ) < 0; hole /= 2 )
			array[ hole ] = array[ hole / 2 ];
		array[ hole ] = x;
	}

	/**
	 * Find the smallest item in the priority queue.
	 * @return the smallest item, or null, if empty.
	 */
	@SuppressWarnings("rawtypes")
	public Comparable findMin( )
	{
		if( isEmpty( ) )
			return null;
		return array[ 1 ];
	}

	/**
	 * Remove the smallest item from the priority queue.
	 * @return the smallest item, or null, if empty.
	 */
	@SuppressWarnings("rawtypes")
	public Comparable deleteMin( )
	{
		if( isEmpty( ) )
			return null;

		Comparable minItem = findMin( );
		array[ 1 ] = array[ currentSize-- ];
		percolateDown( 1 );

		return minItem;
	}

	/**
	 * Establish heap order property from an arbitrary
	 * arrangement of items. Runs in linear time.
	 */
	private void buildHeap( )
	{
		for( int i = currentSize / 2; i > 0; i-- )
			percolateDown( i );
	}

	/**
	 * Test if the priority queue is logically empty.
	 * @return true if empty, false otherwise.
	 */
	public boolean isEmpty( )
	{
		return currentSize == 0;
	}

	/**
	 * Test if the priority queue is logically full.
	 * @return true if full, false otherwise.
	 */
	public boolean isFull( )
	{
		return currentSize == array.length - 1;
	}

	/**
	 * Make the priority queue logically empty.
	 */
	public void makeEmpty( )
	{
		currentSize = 0;
	}

	private static final int DEFAULT_CAPACITY = 100;

	private int currentSize;	  // Number of elements in heap
	@SuppressWarnings("rawtypes")
	private Comparable [ ] array; // The heap array

	/**
	 * Internal method to percolate down in the heap.
	 * @param hole the index at which the percolate begins.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void percolateDown( int hole )
	{
/* 1*/	int child;
/* 2*/	Comparable tmp = array[ hole ];

/* 3*/	for( ; hole * 2 <= currentSize; hole = child )
		{
/* 4*/		child = hole * 2;
/* 5*/		if( child != currentSize &&
/* 6*/				array[ child + 1 ].compareTo( array[ child ] ) < 0 )
/* 7*/			child++;
/* 8*/		if( array[ child ].compareTo( tmp ) < 0 )
/* 9*/			array[ hole ] = array[ child ];
			else
/*10*/			break;
		}
/*11*/	array[ hole ] = tmp;
	}

	public void increaseKey (int p, int delta)
	{
		if (p >= array.length)
			return;
		if (!(array[p] instanceof Integer))
			return;
		array[p] = new Integer((Integer)array[p] + delta);
		percolateDown(p);
	}

	public void decreaseKey (int p, int delta)
	{
		if (p >= array.length)
			return;
		if (!(array[p] instanceof Integer))
			return;
		array[p] = new Integer((Integer)array[p] - delta);
		percolateUp(p);
	}
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void percolateUp( int hole )
	{
		int parent;
		Comparable tmp = array[ hole ];

		for( ; hole / 2 >= 1; hole = parent )
		{
			parent = hole / 2;
			if( parent != 0 && array[ parent ].compareTo( tmp ) > 0 )
				array[ hole ] = array[ parent ];
			else
				break;
		}
		array[ hole ] = tmp;
	}

	public void printHeap ()
	{
		int newline = 2;
		int leadSpaces = 30;
		int inbetweenSpaces = (leadSpaces - 2) / 2;
		for (int sp = 1; sp <= leadSpaces; sp++)
			System.out.print (" ");
		for (int i = 1; i <= currentSize; i++)
		{
			if (i == newline)
			{ 
				System.out.println ();
				inbetweenSpaces = leadSpaces;
				leadSpaces = (leadSpaces - 2) / 2;
				for (int sp = 1; sp <= leadSpaces; sp++)
					System.out.print (" ");
				newline *= 2;
			}
			if ((Integer)array[i] < 10)
				System.out.print(array[i] + " ");
			else
				System.out.print(array[i] );
			for (int sp = 1; sp <= inbetweenSpaces; sp++)
				System.out.print (" ");

		}
		System.out.println ();
	}

	

		// Test program
	public static void main( String [ ] args )
	{
		@SuppressWarnings("unused")
		int i,j;
		int array [] = {0, 10, 12, 1, 14, 6, 5, 8, 15, 3, 9, 7, 4, 11, 13, 2};
		Integer myIntArray [] = new Integer [array.length];
		
		for (i = 1; i <= array.length -1; i++)
			myIntArray [i] = new Integer (array[i]); 
				
		BinaryHeap heapByHeapify = new BinaryHeap (myIntArray);
		System.out.println("After buildHeap operartion:");
		heapByHeapify.printHeap();

		i = JOptionPane.showConfirmDialog (null,"Continue?");
		
		//////////////////////////////////////////////////////////////
		BinaryHeap h = new BinaryHeap( array.length );
		try
		{
			for (i = 1; i <= array.length-1; i++)
			{
				h.insert (new Integer (array[i]));
				System.out.println("------------------------------------------------------------------");
				h.printHeap();
				j = JOptionPane.showConfirmDialog (null,"Continue?");
			}
		}
		catch( UnderflowException e )
		  { System.out.println( "Overflow "   ); }
		
		
		i = JOptionPane.showConfirmDialog (null, "Remove an item?",
			"continue",	JOptionPane.YES_NO_OPTION );
		while (i == 0)
		{
			System.out.println("------------------------------------------------------------------");
			h.deleteMin();
			h.printHeap();
			i = JOptionPane.showConfirmDialog (null, "Remove an item?", 
				"continue", JOptionPane.YES_NO_OPTION );
		}
		
		//////////////////////////////////////////////////////////////
		h = new BinaryHeap( array.length );
		try
		{
			for (i = 1; i <= array.length-1; i++)
				h.insert (new Integer (array[i]));
		}
		catch( UnderflowException e )
		  { System.out.println( "Overflow "   ); }
		System.out.println("------------------------------------------------------------------");
		System.out.println("Start from scratch");
		h.printHeap();
		
		String s = JOptionPane.showInputDialog 
			("Enter an element to change (q to quit)");
		while (s.charAt(0) != 'q')
		{
			int element = Integer.parseInt(s);
			s = JOptionPane.showInputDialog ("Enter the amount you want to chage it by");
			int delta = Integer.parseInt(s);
			if (delta < 0)
				h.decreaseKey (element, 0-delta);
			else 
				h.increaseKey (element, delta);

			System.out.println("------------------------------------------------------------------");
			h.printHeap();
			s = JOptionPane.showInputDialog 
				("Enter an element to change (q to quit)");
		}
		System.exit(0);
	}
}



