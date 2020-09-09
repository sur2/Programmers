import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	
	public static void main(String[] args) {
		
		int[] priorities = {2, 1, 3, 2};
		int location = 2;

		solution(priorities, location);
	}
	
	public static int solution(int[] priorities, int location) {
		int answer = 0;
		
		Queue<Integer> prioQueue = new LinkedList<Integer>();
		Queue<Integer> uniQueue = new LinkedList<Integer>();
		LinkedList<Integer> printOut = new LinkedList<Integer>();
		
		for (int i = 0; i < priorities.length; i++) {
			prioQueue.add(priorities[i]);
			uniQueue.add(i);
		}
		int cnt = 0;
		while(true) {
			if (isPop(prioQueue)) {
				cnt++;
				prioQueue.poll();
				if (uniQueue.poll() == location) {
					break;
				}
			} else {
				int temp = prioQueue.poll();
				prioQueue.add(temp);
				temp = uniQueue.poll();
				uniQueue.add(temp);
			}
			//System.out.println(prioQueue);
			//System.out.println(uniQueue);
		}
		
		answer = cnt;
		//System.out.println(cnt);
		
		return answer;
	}
	
	public static boolean isPop(Queue queue) {
		LinkedList<Integer> temp = new LinkedList<Integer>();
		temp = (LinkedList<Integer>) queue;
		int i = 1;
		for (i = 1; i < queue.size(); i++) {
			if (temp.get(0) < temp.get(i)) {
				return false;
			}
		}
		if(i > (queue.size() - 1)) {
			return true;
		} else {
			return false;
		}
	}
}
