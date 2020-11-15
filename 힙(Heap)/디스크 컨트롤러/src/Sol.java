import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

// Level 3 디스크 컨트롤러
public class Sol {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sol sol = new Sol();
		int[][] jobs = { { 0, 3 }, { 1, 9 }, { 2, 6 } };
		sol.solution(jobs);
	}

	// FIFO(First In First Out)보다 SJF(Shortest Job First)가 각 작업의 요청 시 처리 시간이 더 짧다는
	// 것을 보여주는 문제
	// SJF : 작업 처리 시간이 가장 짧은 프로세스부터 스케줄링
	public int solution(int[][] jobs) {
		int answer = 0;

		// 작업 시작 시간 순으로 입력받은 작업배열을 오름차순으로 정렬
		Arrays.sort(jobs, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[0] - o2[0];
			}
		});

		// 작업의 소요시간이 작은 것에서 큰 것으로 오름차순하는 우선순위 큐를 인스턴스
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
			// 작업 공간인 우선순위 큐로 삽입
			while(i < len && jobs[i][0] <= time) {
				pqueue.add(jobs[i]);
				i++;
			}
			// 작업 공간이 비었다면 다음 작업 시간으로 이동(이전 작업 시간보다 더 늦게 새로운 작업이 들어올 경우)
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
