package linkedListProblems;

public class Driver {

	public static void main(String[] args) {
		
		Node<Integer> a = new Node<Integer>(1, null);
		
		Node<Integer> b = new Node<Integer>(2, null);
		a.setNext(b);
		Node<Integer> c = new Node<Integer>(3, null);
		b.setNext(c);
		Node<Integer> d = new Node<Integer>(4, null);
		c.setNext(d);
		Node<Integer> e = new Node<Integer>(5, null);
		d.setNext(e);
//		e.setNext(c);
		
		Node<Integer> A = new Node<Integer>(2, null);
		
		Node<Integer> B = new Node<Integer>(4, null);
		A.setNext(B);
		Node<Integer> C = new Node<Integer>(6, null);
		B.setNext(C);
		Node<Integer> D = new Node<Integer>(8, null);
		C.setNext(D);
		Node<Integer> E = new Node<Integer>(10, null);
		D.setNext(E);
		C.setNext(A);
		
		System.out.println(LLHomeworkFunctions.terminates(a));
		System.out.println(LLHomeworkFunctions.terminates(A));
		
/*		Node<Integer> F = new Node<Integer>(0, null);
		E.setNext(F);
		Node<Integer> G = new Node<Integer>(2, null);
		F.setNext(G);
*/
		
/*
		Node<Integer> ansHead = LLHomeworkFunctions.getIntersection(A,a);
		if (ansHead == null)
			System.out.println("null");
		
		for(Node<Integer> node = ansHead; node != null; node = node.getNext()) {
			System.out.println(node.getElement());
		}
*/
		
										//FastMaxStack tests
/*		MaxStack<Integer> s = new SlowMaxStack<Integer>();
		MaxStack<Integer> f = new FastMaxStack<Integer>();
		
		System.out.println("Slow: ");
		
		System.out.println(s.getMaxSoFar());
		
		s.push(1);
		s.push(5);
		s.push(3);
		s.push(21);
		s.pop();
		
		System.out.println(s.getMaxSoFar());
		
		s.push(7);
		s.push(-1);
		s.push(-99);
		s.pop();
		
		System.out.println(s.getMaxSoFar());
		
		System.out.println("Fast: ");
		
		System.out.println(f.getMaxSoFar());
		
		f.push(1);
		f.push(5);
		f.push(3);
		f.push(21);
		f.pop();
		
		System.out.println(f.getMaxSoFar());
		
		f.push(7);
		f.push(-1);
		f.push(-99);
		f.pop();
		
		System.out.println(f.getMaxSoFar());	*/
		
	}

}
