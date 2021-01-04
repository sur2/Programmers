package 순위;

import java.util.Arrays;

// Level 3 순위
public class Sol{

	public static void main(String[] args) {
		Sol s = new Sol();
		int n = 5;
		int[][] results = { { 4, 3 }, { 4, 2 }, { 3, 2 }, { 1, 2 }, { 2, 5 } };
		int result = s.solution(n, results);
		System.out.println(result);
	}

	public int solution(int n, int[][] results) {
		int answer = 0;
		
		int[][] graph = new int[n + 1][n + 1];
		
		for (int i = 0; i < results.length; i++) {
			int winner = results[i][0];
			int loser = results[i][1];
			graph[winner][loser] = 1;
			graph[loser][winner] = -1;
		}
		
		for (int k = 1; k < n + 1; k++) {
			for (int s = 1; s < n + 1; s++) {
				for (int e = 1; e < n + 1; e++) {
					if(graph[s][k] == 1 && graph[k][e] == 1) {
						graph[s][e] = 1;
					}
					if(graph[s][k] == -1 && graph[k][e] == -1) {
						graph[s][e] = -1;
					}
				}
			}
		}
		int cnt = 0;
		for (int i = 1; i < graph.length; i++) {
			int check = 0;
			for (int j = 1; j < graph[i].length; j++) {
				if(i != j && graph[i][j] != 0) {
					check++;
				}
				System.out.printf("%2d ", graph[i][j]);				
			}
			if(check == n - 1) {
				cnt++;
			}
			System.out.println();				
		}
		answer = cnt;
		return answer;
	}

}
