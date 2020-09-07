import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

	public static void main(String[] args) {
		int[] progresses = {95, 90, 99, 99, 80, 99};
		int[] speeds = {1, 1, 1, 1, 1, 1};
		solution(progresses, speeds);
	}
	
	public static int[] solution(int[] progresses, int[] speeds) {
		int[] answer = {};
		Queue<Integer> queue = new LinkedList<Integer>();
		List<Integer> list = new LinkedList<Integer>();
		
		for (int i = 0; i < progresses.length; i++) {
			int day = ((100 - progresses[i]) % speeds[i] == 0) 
					? (100 - progresses[i]) / speeds[i] 
					: (100 - progresses[i]) / speeds[i] + 1; 
			queue.add(day);		
		}
		
		System.out.println(queue);
		
		int maxDay = queue.poll();
		int cnt = 1;
		while (!queue.isEmpty()) {
			if (maxDay < queue.peek()) {
				list.add(cnt);
				maxDay = queue.poll();
				cnt = 1;
			}
			else {
				queue.poll();
				cnt++;
			}
		}
		list.add(cnt);
		System.out.println(list);
		int size = list.size();
		answer = new int[size];
		for (int i = 0; i < size; i++) {
			answer[i] = list.get(i);
		}
		
		return answer;
	}

}
	