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
        // Set[8] 배열 선언 및 초기화
        Set<Integer> set[] =  new HashSet[8];
        int n = 0;
        for (int i = 0; i < 8; i++) {
			set[i] = new HashSet<Integer>();
			// 각 Set에 N을 1부터 8개까지 이어붙인 수를 추가
			n += (int) (Math.pow(10, i) * N);
			set[i].add(n);
		}
        
        // 최솟값 8만큼 사용된 숫자 별로 연산가능한 경우의 수 Set에 저장
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
