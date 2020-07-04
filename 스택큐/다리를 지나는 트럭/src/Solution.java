import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution {
	
	private static int bridge_length = 100;
	private static int weight = 100;
	private static int[] truck_weights = { 10 };
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		Queue<Integer> bridge = new LinkedList<Integer>();
		int len = truck_weights.length;
		int time = 0;
		int index = 0;
		int maxWeight = weight;
		while(stack.size() < len) {
			if(bridge.size() == bridge_length) {
				if(bridge.peek() == null) {
					bridge.poll();
				}
				else {
					int poll = bridge.poll();
					stack.push(poll);
					maxWeight += poll;
				}
			}
			int temp = truck_weights[index];
			if (maxWeight - temp >= 0) {
				maxWeight -= temp;
				bridge.add(temp);
				index = len - 1 > index ? index + 1 : index;
			}
			else {
				bridge.add(null);
			}
			time++;
			System.out.println(time);
		}
		
	}

}
