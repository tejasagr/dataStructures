package weightedBFS;


public class BinaryTree {

	private static class TreeNode implements Comparable
	{
		public Object element;
		public TreeNode left;
		public TreeNode right;
		double distance;
		
		public TreeNode (Object o)
		{
			this (o, null, null);
		}
		
		public TreeNode (Object o, TreeNode l, TreeNode r)
		{
			element = o;
			left = l;
			right = r;
		}
		
		public String toString()
		{
			return "" + element;
		}

		public int compareTo(Object o) {
			return 0;
		}
	}
	
	private TreeNode root;
	
	public BinaryTree( TreeNode root )
	{
		this.root = root;
	}
	
	public TreeNode breadthFirstSearch( Object o )
	{
		TreeNode b;
		QueueLi q = new QueueLi();
		q.enqueue (root);
		
		while(!q.isEmpty())
		{
			b = (TreeNode)q.dequeue();
			
			if (b.element.equals (o))
				return b;
			
			if (b.left != null)
				q.enqueue (b.left);
			if (b.right != null)
				q.enqueue (b.right);
		}
		
		return null;
	}
}