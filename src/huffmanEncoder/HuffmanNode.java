package huffmanEncoder;

public class HuffmanNode implements Comparable {
	
	public String letter;
	public Double frequency;
	public HuffmanNode left, right;
	
	//huffman node constructors
	public HuffmanNode(String letter, Double frequency) {
		this.letter = letter;
		this.frequency = frequency;
		this.left = null;
		this.right = null;
	}
	
	public HuffmanNode(HuffmanNode left, HuffmanNode right) {
		this.left = left;
		this.right = right;
		this.letter = left.letter + right.letter;
		this.frequency = left.frequency + right.frequency;
	}
	
	//compareto method for nodes based on frequencies
	public int compareTo(Object o) {
		HuffmanNode huff = (HuffmanNode) o;
		
		return this.frequency.compareTo(huff.frequency);
	}
	
	//node to string method
	public String toString() {
		return "<"+letter+", "+frequency+">";
	}
	
}

