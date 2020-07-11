import java.util.Arrays;
import java.util.Stack;

public class Solution {
	
	private static int[] heights = { 3, 9, 9, 3, 5, 7, 2 };
	public static void main(String[] args) {
		int len = heights.length;
		int ans[] = new int[len];
		Stack<int[]> stack = new Stack<int[]>();
		for (int i = 0; i < len; i++) {
			// 0: n번째 	1: 높이
			int temp[] = new int[2];
			temp[0] = i + 1;
			temp[1] = heights[i];
			while(!stack.isEmpty()) {
				int[] top = stack.peek();
				if(top[1] > temp[1]) {
					ans[i] = top[0];
					break;
				}
				stack.pop();
			}
			stack.push(temp);
		}
		
		System.out.println(Arrays.toString(ans));
	}
}
