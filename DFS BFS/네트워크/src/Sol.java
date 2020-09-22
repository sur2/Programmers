import java.util.Arrays;

// Level 3 네트워크
public class Sol {

	public static void main(String[] args) {

		Sol sol = new Sol();
		int n = 3;
		int[][] computers = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };
		sol.solution(n, computers);
	}

	public int solution(int n, int[][] computers) {
		int answer = 0;
		boolean[] visit = new boolean[n];
		// 방문한 적 없는 컴퓨터는 네트워크를 만들 수 있음
		for (int i = 0; i < n; i++) {
			if (!visit[i]) {
				dfs(computers, visit, i, n);
				answer++;
			}
		}
		return answer;
	}
	
	// dfs 
	public void dfs(int[][] computers, boolean[] visit, int start, int n) {
		visit[start] = true;
		for (int i = 0; i < n; i++) {
			if(!visit[i] && computers[start][i] == 1) {
				dfs(computers, visit, i, n);
			}
		}
	}

}
