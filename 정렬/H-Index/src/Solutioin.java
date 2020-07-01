import java.util.Arrays;
import java.util.Collections;

public class Solutioin {

	private static int[] citations = { 20, 19, 18, 17, 2 };

	public static void main(String[] args) {
		int answer = 0;
		int len = citations.length;
		Integer[] temp = new Integer[len];
		int j = 0;
		for (int n : citations) {
			temp[j++] = n;
		}
		Arrays.sort(temp, Collections.reverseOrder());
		System.out.println(Arrays.toString(temp));
		for (int i = 0; i < len; i++) {
			if (i >= temp[i]) {
				answer = i;
				break;
			}
			if(i == len - 1) {
				answer = len;
			}
		}

		System.out.println(answer);
	}

}
