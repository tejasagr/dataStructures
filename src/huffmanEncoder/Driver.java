package huffmanEncoder;

import java.io.FileNotFoundException;

public class Driver {

	public static void main (String[] args) throws FileNotFoundException {
		String filename = args[0];
		String contents = HuffmanConverter.readContents(filename);
		HuffmanConverter hc = new HuffmanConverter(contents);
		hc.recordFrequencies();
		hc.frequenciesToTree();
		hc.treeToCode();
		
/*		//String contents = HuffmanConverter.readContents(args[0]);
		//String contents = "Eric is a potato"
		
		//HuffmanConverter hc = new HuffmanConverter(contents);
		
		
		
		HuffmanConverter hc = new HuffmanConverter("potatoes are the best");
		hc.recordFrequencies();
		hc.frequenciesToTree();
		hc.treeToCode();
		printFrequencies(hc);
		
		System.out.println( hc.encodeMessage() );
		System.out.println( hc.decodeMessage(hc.encodeMessage()) );
		
//		System.out.println(hc.uniqueChars);
*/
		
	}
	
	public static void printFrequencies (HuffmanConverter h) {
		
		for (int i = 0; i < 256; i++) {
		
			
		char c = (char)i;
		String ch = Character.toString(c);
		
		if (h.count[i] > 0) {
			System.out.print(ch + " freq: " + h.count[i] + " ");
			System.out.print("code: " + h.code[i]);
			System.out.println();
		}
		
		}
	}
}
