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
		// �� ��� x, y�� root ��带 ã��!
		x = Find(x);
		y = Find(y);
		
		// ã�ƴٸ� x�� �������� y ��带 �߰�����!
		// y�� root ���� x�̴�!
		root[y] = x;
	}
	
	// n�� root ��带 ã��!
	private int Find(int n) {
		
		if(root[n] == n) {
			return n;
		}
		else {
			return Find(root[n]);
		}
	}

}
