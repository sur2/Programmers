import java.util.HashSet;
import java.util.Set;

public class Sol {

	public static void main(String[] args) {

		Sol sol = new Sol();
		sol.solution(5, 12);

	}
	
	public int solution(int N, int number) {
        int answer = 0;
        answer = -1;
        // Set[8] �迭 ���� �� �ʱ�ȭ
        Set<Integer> set[] =  new HashSet[8];
        int n = 0;
        for (int i = 0; i < 8; i++) {
			set[i] = new HashSet<Integer>();
			// �� Set�� N�� 1���� 8������ �̾���� ���� �߰�
			n += (int) (Math.pow(10, i) * N);
			set[i].add(n);
		}
        
        // �ּڰ� 8��ŭ ���� ���� ���� ���갡���� ����� �� Set�� ����
        for (int i = 1; i < 8; i++) { 
			for (int j = 0; j < i; j++) {
				for (Integer k : set[j]) {
					for (Integer l : set[i - 1 - j]) {
						if (k + l < 32001)
							set[i].add(k + l);
						if (k - l > 0)
							set[i].add(k - l);
						if (k * l < 32001)
							set[i].add(k * l);
						if (l != 0) 
							set[i].add(k / l);
					}
				}
			}
		}
        
        for (int i = 0; i < 8; i++) {
        	if(set[i].contains(number)) {
        		answer = i + 1;
        		break;
        	}
		}
        System.out.println(answer);
        return answer;
    }

}
