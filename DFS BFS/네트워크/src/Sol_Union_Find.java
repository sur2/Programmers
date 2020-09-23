import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Sol_Union_Find {
	
	private int[] root = null;
	private int[] depth = null;

	public static void main(String[] args) {
		Sol_Union_Find suf = new Sol_Union_Find();
		int n = 4;
		int[][] computers = { { 1, 0, 0, 1 }, { 0, 1, 1, 0 }, { 0, 1, 1, 0 }, { 1, 1, 0, 1 } };
		suf.solution(n, computers);
	}

	public int solution(int n, int[][] computers) {
		int answer = 0;
		
		root = new int[n];
		depth = new int[n];
		
		for (int i = 0; i < n; i++) {
			root[i] = i;
			depth[i] = 1;
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
			//set.add(root[i]);
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
		
		// 두 노드의 root 노드가 같으면 같은 트리로 보고 합치지 않음!
		if (x == y) {
			return;
		}
		
		// Union 최적화
		// 항상 더 높은(깊은) 트리 밑으로 낮은 트리를 넣어서 합친다!
		if (depth[x] > depth[y]) {
			// 찾아다면 x를 기준으로 y 노드를 추가하자!
			// y의 root 노드는 x이다!
			root[y] = x;
			depth[x] += depth[y];
		}
		else {
			root[x] = y;
			depth[y] += depth[x];
		}
	}
	
	// n의 root 노드를 찾자!
	private int Find(int n) {
		
		if(root[n] == n) {
			return n;
		}
		else {
			// 경로 압축
			// Find 함수가 호출 되면서 만나는 부모 노드를 root 노드로 갱신한다.
			return root[n] = Find(root[n]);
		}
	}

}
