package huffmanEncoder;

public class HuffmanTree {
	
	HuffmanNode root;
	
	//tree constructor
	public HuffmanTree(HuffmanNode huff) {
		this.root = huff;
	}
	
	//prints out legend of huffman encoder
	public void printLegend() {
		printLegend(root, "");
	}
	
	private void printLegend(HuffmanNode t, String s) {
		if (t.letter.length() > 1) {		//not a leaf node
			printLegend(t.left, s + "0");
			printLegend(t.right,s + "1");
		}
		else {								//leaf node
			System.out.println(t.letter + "=" + s);
		}
	}
	
	//converts legend string to binary heap
	@SuppressWarnings("rawtypes")
	public static BinaryHeap legendToHeap(String legend) {
		legend = legend + " ";					//add space to end to simplify conversion
		
		HuffmanNode[] huffs = new HuffmanNode[legend.length()]; //using length of legend
																//as upperbound of nodes
		int index = 0;
		while(legend.length() != 0) {
			String letter = legend.substring(0, 1);	//saves letter
			legend = legend.substring(2);			//and removes it and space from string
			
			int i = legend.indexOf(" ");			//finds length of freq. number
			String freqStr = legend.substring(0,i);	//String form of freq. number
			double frequency = Double.parseDouble(freqStr); //frequency into double
			legend = legend.substring(i+1); 		//removes freq and space
			
			HuffmanNode huff = new HuffmanNode(letter, frequency);
			huffs[index++] = huff;
		}
		
		HuffmanNode[] huffsSizeAdj = new HuffmanNode[index];
		for (int a = 0; a < huffsSizeAdj.length; a++) {
			huffsSizeAdj[a] = huffs[a];
		}
		
		return new BinaryHeap<HuffmanNode>(huffsSizeAdj);
	}
	
	//converts binary heap into huffman tree
	public static HuffmanTree createFromHeap(BinaryHeap b) {
		
		while (b.getSize() > 1) {
			HuffmanNode left  = (HuffmanNode) b.deleteMin();
			HuffmanNode right = (HuffmanNode) b.deleteMin();
			
			HuffmanNode huff = new HuffmanNode(left, right);
			b.insert(huff);
		}
		return new HuffmanTree((HuffmanNode) b.deleteMin());
	}
	
	//converts hardcoded legend string into huffman tree and prints the legend
	public static void main(String[] args) {
		String legend = "A 20 E 24 G 3 H 4 I 17 L 6 N 5 O 10 S 8 V 1 W 2";
		
		BinaryHeap bheap = legendToHeap(legend);
		HuffmanTree htree = createFromHeap(bheap);
		
		htree.printLegend();
	}
	
}