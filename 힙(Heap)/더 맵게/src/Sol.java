import java.util.Arrays;
import java.util.Iterator;
import java.util.PriorityQueue;

// Level 2 �� �ʰ�
public class Sol {

	public static void main(String[] args) {
		Sol sol = new Sol();
		int[] scoville = {1, 2, 3};
		int K = 11;
		sol.Solution(scoville, K);
	}
	
	// ���� ������ ���ں� ���� = ���� ���� ���� ������ ���ں� ���� + (�� ��°�� ���� ���� ������ ���ں� ���� * 2)
	public int Solution(int[] scoville, int K) {
		int answer = 0;
		
		Arrays.sort(scoville);
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
		for (int i = 0; i < scoville.length; i++) {
			priorityQueue.add(scoville[i]);
		}

		while(priorityQueue.size() > 1) {
			if (ScovilleJudgement(priorityQueue, K)) {
				break;
			}
			
			int scovilleMix = priorityQueue.poll() + priorityQueue.poll() * 2;
			
			priorityQueue.add(scovilleMix);
			
			System.out.println(priorityQueue.toString());
			answer++;
		}
		
		if (!ScovilleJudgement(priorityQueue, K)) {
			answer = -1;
		}
		
		System.out.println(answer);
		return answer;
	}
	
	public boolean ScovilleJudgement(PriorityQueue<Integer> pQueue, int K) {
		Iterator<Integer> iter = pQueue.iterator();
		while(iter.hasNext()) {
			int ne = iter.next();
			if(ne < K) {
				return false;
			}
		}
		return true;
	}

}
