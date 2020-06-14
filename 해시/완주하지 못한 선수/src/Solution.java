import java.util.Arrays;

public class Solution {

	private static String[] participant = {"leo", "kiki", "eden"};
	private static String[] completion = {"eden", "kiki"};
	public static void main(String[] args) {

		String answer = "";
		Arrays.sort(participant);
		Arrays.sort(completion);
		
		for (int i = 0; i < completion.length; i++) {
			if (!participant[i].equals(completion[i])) {
				answer = participant[i];
				break;
			}
			if(i == completion.length - 1) {
				answer = participant[completion.length];
			}
		}
		
		System.out.println(answer);
	}
}
