import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// Level 2 주식가격
public class Solution {

	private static int[] PRICES = {1, 2, 3, 2, 3};
	public static void main(String[] args) {
		
		Queue<Integer> queue = new LinkedList<Integer>();
		Stack<Integer> stack = new Stack<Integer>();
		
		for (Integer price : PRICES) {
			queue.add(price);
		}
		int len = PRICES.length;
		int[] answer = new int[len];
		while(!queue.isEmpty()) {
			int temp = queue.poll();
			int cnt = 0;
			for (int i : queue) {
				if(temp > i) {
					cnt++;
					break;
				}
				else {
					cnt++;
				}
			}
			stack.push(cnt);
		}
		
		for (int i = 0; i < len; i++) {
			answer[len - 1 - i] = stack.pop();
		}
		System.out.println(Arrays.toString(answer));
	}

}
