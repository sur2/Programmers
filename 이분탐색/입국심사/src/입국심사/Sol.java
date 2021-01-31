package 입국심사;

import java.util.Arrays;

// Level 3 입국심사
public class Sol {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sol s = new Sol();
		int n = 6;
		int[] times = {7, 10};
		long ans = s.solution(n, times);
		
		System.out.println("answer: " + ans);

	}
	
	public long solution(int n, int[] times) {
        long answer = 0;
        
        long max = 0, min = 0, mid = 0;
        Arrays.sort(times);
        // long 타입에 맞춰서 연산할 것을 주의한다.
        max = (long)times[times.length - 1] * (long)n;
        
        answer = max;
        
        // 입국심사의 최대, 최소 시간으로 범위를 점차 줄여나갈 것이다.
        while(min <= max) {
        	// 처음 입력 예시의 최대 허용시간은 60분이니까 절반인 30분으로 만든다.
        	mid = (min + max) / 2;
        	long guest = 0;
        	for (int i = 0; i < times.length; i++) {
				 guest += (mid / times[i]);
			}
        	// 30분 동안 n명을 모두 처리할 수 있는지 없는지 확인한다.
        	// 30분이 아니라 20분이였다면 모두 처리할 수 없기 때문에 최소 시간을 21분으로 설정한다.
        	if(guest < n) {
        		min = mid + 1;
        	}
        	// 30분 동안 처리할 수 있기 때문에 최대 시간을 더 줄여본다.
        	else{
        		// 현재 처리시간보다 더 짧은 시간이 있으면 그 것으로 갱신한다.
        		if(mid <= answer) {
        			answer = mid;
        		}
        		// 최대시간을 29분으로 두고 최대 최소 구간을 다시 줄여나간다.
        		max = mid - 1;
        	}
        	
        }
        
        return answer;
    }

}
