import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Solution {

	private static int[] numbers = {0, 00, 000, 0000, 0, 0, 0};

	public static void main(String[] args) {
		String answer = "";
		int len = numbers.length;
		List<int[]> list = new LinkedList<>();

		for (int i = 0; i < len; i++) {
			int[] temp = new int[2];
			temp[0] = Number1000(numbers[i]);
			temp[1] = numbers[i];
			list.add(temp);
		}

		list.sort(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o2[0] - o1[0];
			}
		});

		for (int[] is : list) {
			answer += is[1] + "";
		}
		
		while(answer.charAt(0) == '0' && answer.length() > 1) {
			answer = answer.substring(1, answer.length());
		}
		System.out.println(answer);
	}

	private static int Number1000(Integer number) {
		String temp = number + "";
		if (number < 10) {
			temp += number;
			temp += number;
			temp += number;
		} else if (number < 100) {
			temp += number;
		} else if (number < 1000) {
			temp += (temp.charAt(0) + "");
		}

		return Integer.parseInt(temp);
	}

}
