import java.util.HashSet;
import java.util.Set;

public class Sol {

	public static void main(String[] args) {

		Sol sol = new Sol();
		sol.solution(5, 12);

	}
	
	public int solution(int N, int number) {
        int answer = 0;
        
        // Set[8] 배열 선언 및 초기화
        Set<Integer> set[] =  new HashSet[8];
        int n = 0;
        for (int i = 0; i < 8; i++) {
			set[i] = new HashSet<Integer>();
			// 각 Set에 N을 1부터 8개까지 이어붙인 수를 추가
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
