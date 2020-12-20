import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Level 3 가장 먼 노드
public class Sol {

	public static void main(String[] args) {
		Sol s = new Sol();
		int n = 6;
		int[][] edge = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
		int result = s.solution(n, edge);
		System.out.println(result);
	}
	
	private static List<List<Integer>> node_list = new LinkedList<List<Integer>>();

	// BFS: 1번 노드 부터 n번 노드까지 도달하는 거리 측정
	public int solution(int n, int[][] edge) {
		int answer = 0;	
		
		for (int i = 0; i < n + 1; i++) {
			node_list.add(new LinkedList<Integer>());
		}
		
		for (int i = 0; i < edge.length; i++) {
			node_list.get(edge[i][0]).add(edge[i][1]);
			node_list.get(edge[i][1]).add(edge[i][0]);
		}
		
		Queue<Integer> queue = new LinkedList<Integer>();
		Integer visit[] = new Integer[n + 1];
		Arrays.fill(visit, 0);
		visit[0] = -1;
		queue.offer(1);
		visit[1] = 1;
		
		while(!queue.isEmpty()) {
			int peek_node = queue.poll();
			for (int i = 0; i < node_list.get(peek_node).size(); i++) {
				int next = node_list.get(peek_node).get(i);
				if (visit[next] == 0) {
					queue.offer(next);
					visit[next] = visit[peek_node] + 1;
				}
			}
		}
		
		Arrays.sort(visit, (o1, o2) -> o2 - o1);
		int max = visit[0];
		for (int i = 0; i < visit.length; i++) {
			if(max == visit[i]) {
				answer++;
			}
			else {
				break;
			}
		}

		return answer;
	}
	
}
