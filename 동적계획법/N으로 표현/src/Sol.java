import java.util.HashSet;
import java.util.Set;

public class Sol {

	public static void main(String[] args) {

		Sol sol = new Sol();
		sol.solution(5, 12);

	}
	
	public int solution(int N, int number) {
        int answer = 0;
        
        // Set[8] �迭 ���� �� �ʱ�ȭ
        Set<Integer> set[] =  new HashSet[8];
        int n = 0;
        for (int i = 0; i < 8; i++) {
			set[i] = new HashSet<Integer>();
			// �� Set�� N�� 1���� 8������ �̾���� ���� �߰�
			n += (int) (Math.pow(10, i) * N);
			set[i].add(n);
		}
        
        for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				for (int ii = 0; ii < set[i].size(); ii++) {
					for (int jj = 0; jj < set[j].size(); jj++) {
						
					}
				}
			}
		}

        
        
        
        return answer;
    }

}
