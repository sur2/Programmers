package 구명보트;

import java.util.Arrays;

// Level 2 구명보트
public class Sol {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sol s = new Sol();
		int[] people = {70, 50, 80, 50};
		int limit = 100;
		int result = s.solution(people, limit);
		System.out.println(result);
	}
	
	public int solution(int[] people, int limit) {
		int answer = 0;
		Arrays.sort(people);
		int L = 0, R = people.length - 1;
		// 가장 큰 값 하나와 순서대로 작은 값을 더해보면서 limit 보다 크기 직전 까지 합쳐서 보트를 태워 보낸다.
		while(L < R) {
			if(people[L] + people[R] > limit) {
				R--;
			}
			else {
				L++;
				R--;
			}
			answer++;	
		}
		if(L == R)
			answer++;
		
		return answer;
		
	}

}
