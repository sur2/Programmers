import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

// Level 3 ��ũ ��Ʈ�ѷ�
public class Sol {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sol sol = new Sol();
		int[][] jobs = { { 0, 3 }, { 1, 9 }, { 2, 6 } };
		sol.solution(jobs);
	}

	// FIFO(First In First Out)���� SJF(Shortest Job First)�� �� �۾��� ��û �� ó�� �ð��� �� ª�ٴ�
	// ���� �����ִ� ����
	// SJF : �۾� ó�� �ð��� ���� ª�� ���μ������� �����ٸ�
	public int solution(int[][] jobs) {
		int answer = 0;

		// �۾� ���� �ð� ������ �Է¹��� �۾��迭�� ������������ ����
		Arrays.sort(jobs, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[0] - o2[0];
			}
		});

		// �۾��� �ҿ�ð��� ���� �Ϳ��� ū ������ ���������ϴ� �켱���� ť�� �ν��Ͻ�
		PriorityQueue<int[]> pqueue = new PriorityQueue<int[]>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[1] - o2[1];
			}
		});

		int len = jobs.length;
		int i = 0;
		int time = 0;
		int workTime = 0;
		while (i < len || !pqueue.isEmpty()) {
			// �۾� ������ �켱���� ť�� ����
			while(i < len && jobs[i][0] <= time) {
				pqueue.add(jobs[i]);
				i++;
			}
			// �۾� ������ ����ٸ� ���� �۾� �ð����� �̵�(���� �۾� �ð����� �� �ʰ� ���ο� �۾��� ���� ���)
			if (pqueue.isEmpty()) {
				time = jobs[i][0];
			}
			else {
				int[] work = pqueue.poll();
				workTime += time + work[1] - work[0];
				time += work[1];
			}
		}
		
		answer = workTime / len;
		return answer;
	}

}
