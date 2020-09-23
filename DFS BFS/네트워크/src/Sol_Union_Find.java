import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Sol_Union_Find {
	
	private int[] root = null;

	public static void main(String[] args) {
		Sol_Union_Find suf = new Sol_Union_Find();
		int n = 4;
		int[][] computers = { { 1, 0, 0, 1 }, { 0, 1, 1, 0 }, { 0, 1, 1, 0 }, { 1, 1, 0, 1 } };
		suf.solution(n, computers);
	}

	public int solution(int n, int[][] computers) {
		int answer = 0;
		
		root = new int[n];
		for (int i = 0; i < n; i++) {
			root[i] = i;
		}
		System.out.println(Arrays.toString(root));
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(i != j && computers[i][j] == 1) {
					Union(i, j);
				}
			}
		}
		
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < n; i++) {
			set.add(Find(i));
		}
		
		answer = set.size();
		System.out.println(set);
		System.out.println(answer);
		
		return answer;
	}
	
	private void Union(int x, int y) {
		// 각 노드 x, y의 root 노드를 찾자!
		x = Find(x);
		y = Find(y);
		
		// 찾아다면 x를 기준으로 y 노드를 추가하자!
		// y의 root 노드는 x이다!
		root[y] = x;
	}
	
	// n의 root 노드를 찾자!
	private int Find(int n) {
		
		if(root[n] == n) {
			return n;
		}
		else {
			return Find(root[n]);
		}
	}

}
