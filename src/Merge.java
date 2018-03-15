
public class Merge {

	public static void main(String[] args) {
		
		int[] list1 = {1 , 4, 8, 12, 19};
		
		int[] list2 = {2 , 3, 5, 7, 13};
		
		int[] ans = merge(list1, list2);
		
		for (int i = 0; i < ans.length; i++)
			System.out.print(ans[i] + " " );
		
	}
	
	static int[] merge ( int[] list1, int[] list2) {

		int[] merged = new int[list1.length + list2.length];

		int a = 0;
		int b = 0;
		int c = 0;

		while (a < list1.length && b < list2.length ) { 
		if (list1[a] < list2[b]) {
			   		merged[c] = list1[a];
		              		a++;
				}
		      		else {
		              		merged[c] = list2[b];
		              		b++;
				}
		       		c++;
		}

		if ( a == list1.length ) {
		       		while ( b < list2.length) {
					merged[c] = list2[b];
					b++;
					c++;
		       		}
		}

		else if ( b == list2.length ) {
		      		while ( a < list1.length) {
					merged[c] = list1[a];
					a++;
					c++;
		      		}
		}

			return merged;
		}

	
}
