package huffmanEncoder;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class HuffmanConverter {
	
	//# of chars in ASCII table, determines size of code and count arrays
	public static final int NUMBER_OF_CHARACTERS = 256;
	
	//contents of message
	private String contents;
	
	//tree created from message
	private HuffmanTree huffmanTree;
	
	//tracks how often each character occurs
	int[] count;
	
	//the huffman code for each character
	String[] code;
	
	// stores the # of unique chars in contents
	private int uniqueChars = 0;
	
	
	public HuffmanConverter (String input) {
		this.contents = input;
		this.count = new int[NUMBER_OF_CHARACTERS];
		this.code = new String[NUMBER_OF_CHARACTERS];
	}
	
	/** traverse contents String to fill up count array */
	public void recordFrequencies () {
		
		for (int i = 0; i < contents.length(); i++) {
			char c = contents.charAt(i);
			count[(int)c]++;
		}
		
		for (int i = 0; i < count.length; i++) {
			if (count[i] > 0)
				uniqueChars++;
		}
			
	}
	
	public void frequenciesToTree() {
		HuffmanNode[] huffs = new HuffmanNode[uniqueChars];
		
		int j = 0;
		for (int i = 0; i < count.length; i++) {
			if (count[i] > 0) {
				char c = (char)i;
				String ch = Character.toString(c);
				
				HuffmanNode h = new HuffmanNode(ch, (double) count[i]);
				huffs[j++] = h;
			}
		}
		
		BinaryHeap bh = new BinaryHeap<HuffmanNode>(huffs);
		bh.printHeap();
		huffmanTree = HuffmanTree.createFromHeap(bh);
	}
	
	
	public void treeToCode() {
		for (int i = 0; i < code.length; i++)
			code[i] = "";
		
		treeToCode (huffmanTree.root, "");
	}
	
	private void treeToCode(HuffmanNode t, String s) {
		if (t.letter.length() > 1) {		//not a leaf node
			treeToCode(t.left, s + "0");
			treeToCode(t.right,s + "1");
		}
		else {								//leaf node
			char c = t.letter.charAt(0);
			code[(int)c] = s;
		}
	}
	
	public String encodeMessage() {
		String encoded = "";
		
		for (int i = 0; i < contents.length(); i++) {
			char c = contents.charAt(i);
			encoded += code[(int)c];
		}
		return encoded;
	}
	
	@SuppressWarnings("resource")
	public static String readContents(String filename) throws FileNotFoundException {
		File f = new File(filename);
		return new Scanner(f).next();
	}

	public String decodeMessage(String encodedStr) {
		String decoded = "";
		int index = -1;
		int bit;
		
		
		while (index < encodedStr.length()-1) {	//this is for the entire string
			HuffmanNode n = huffmanTree.root;
			while(n.letter.length() > 1) {		//this is for one letter
				bit = Integer.parseInt( encodedStr.substring(++index, index+1) );
				if(bit == 0)
					n = n.left;
				else if(bit==1)
					n = n.right;
			}
			decoded += n.letter;
		}
		return decoded;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		String contents = readContents(args[0]);
		HuffmanConverter hc = new HuffmanConverter(contents);
		hc.recordFrequencies();
		
		System.out.println("--------------------");
		System.out.println("// Initial Heap //");
		hc.frequenciesToTree();
		
		System.out.println("--------------------");
		System.out.println("// Tree Legend //");
		hc.huffmanTree.printLegend();
		hc.treeToCode();
		
		System.out.println("--------------------");
		System.out.println("// Encoded Message //");
		String encoded = hc.encodeMessage();
		System.out.println(encoded);
		
		System.out.println("--------------------");
		System.out.println("You need " + contents.length() * 8 + " bits to encode this with ASCII.");
		
		System.out.println("--------------------");
		System.out.println("You need " + encoded.length() + " bits to encode this with Huffman encoding.");
		
		System.out.println("--------------------");
		System.out.println("// Decoded Message //");
		String decoded = hc.decodeMessage(encoded);
		System.out.println(decoded);
		
		System.out.println("--------------------");
	}
}
