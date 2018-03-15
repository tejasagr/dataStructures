package linkedListProblems;

public class LLHomeworkFunctions {

	static public void main(String [] args) {
	}
	
	/**
	 * @param <E>
	 * @param list1
	 * @param list2
	 * @return a list of nodes with elements that appear in both list1 and list2. null if there are none.
	 */
	static public <E> Node<E> getIntersection(Node<E> list1, Node<E> list2) {
		Node<E> ansHead = null, ansTail = null;		//head and tail of intersection list
		Node<E> walk1 = list1, walk2 = list2;
		
		while( walk1 != null ) {
			E val1 = walk1.getElement();
			
			while ( walk2 != null ) {
				E val2 = walk2.getElement();
				
				if (val1.equals(val2)) {
					Node<E> newInter = new Node<E>(val1,null);
					
					if (ansHead == null) {			//first intersection, special case
						ansHead = newInter;
						ansTail = newInter;
					}
					else {							//not first intersection
						ansTail.setNext(newInter);	//add new node to end of the list
						ansTail = ansTail.getNext();//change list tail appropriately
					}
					
				}
				walk2 = walk2.getNext();			//iterate through list2
			}
			walk1 = walk1.getNext();				//iterate through list1
			walk2 = list2;							//reset list2 for new value of list1
		}
		
		return ansHead;
	}
	
	/**
	 * @param <E>
	 * @param list1
	 * @return true if the list eventually terminates, and false if the list points back at one of it's
	 *  previous nodes.
	 */
	static public <E> boolean terminates(Node<E> list) {
		Node<E> walkList = list;
		
		if (walkList == null)					//if empty, the list terminates
			return true;
		
												//checked list is a list of nodes as elements
		Node<Node<E>> checkedH = new Node<Node<E>>(walkList, null);
		Node<Node<E>> checkedT = checkedH;
		walkList = walkList.getNext();			//walkList iterates through list parameter
		
		while (walkList != null) {
			Node<Node<E>> walkChkd = checkedH;	//walkChkd iterates through already checked nodes
			
			while (walkChkd != null) {
				if (walkList == walkChkd.getElement())//if list node is same as a checked node
					return false;				//list does not terminate
				walkChkd = walkChkd.getNext();
			}
												//add node that has been checked to checked list
			checkedT.setNext(new Node<Node<E>>(walkList,null));	
			checkedT = checkedT.getNext();		//adjust tail relevantly
			
			walkList = walkList.getNext();
		}
		
		return true;							//if walkA is null, list parameter has terminated
		
	}
}