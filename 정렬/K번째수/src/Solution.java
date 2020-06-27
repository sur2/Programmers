import java.util.Arrays;

public class Solution {
	private static int[] array = { 1, 5, 2, 6, 3, 7, 4 };
	private static int[][] commands = { { 2, 5, 3 }, { 4, 4, 1 }, { 1, 7, 3 } };

	public static void main(String[] args) {
		int[] answer = {};
		
		int nCal = commands.length;
		answer = new int[nCal];
		
		for (int n = 0; n < nCal; n++) {
			
			int i = commands[n][0];
			int j = commands[n][1];
			int k = commands[n][2];
			
			int size = j - i + 1;
			int temp[] = new int[size];
			int tId = 0;
			for (int r = i; r <= j; r++) {
				temp[tId++] = array[r - 1];
			}
			Arrays.sort(temp);
			System.out.println(temp[k - 1]);
			answer[n] = temp[k - 1];
		}	
	}
}
