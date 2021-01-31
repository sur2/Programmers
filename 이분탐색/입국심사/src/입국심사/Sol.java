package �Ա��ɻ�;

import java.util.Arrays;

// Level 3 �Ա��ɻ�
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
        // long Ÿ�Կ� ���缭 ������ ���� �����Ѵ�.
        max = (long)times[times.length - 1] * (long)n;
        
        answer = max;
        
        // �Ա��ɻ��� �ִ�, �ּ� �ð����� ������ ���� �ٿ����� ���̴�.
        while(min <= max) {
        	// ó�� �Է� ������ �ִ� ���ð��� 60���̴ϱ� ������ 30������ �����.
        	mid = (min + max) / 2;
        	long guest = 0;
        	for (int i = 0; i < times.length; i++) {
				 guest += (mid / times[i]);
			}
        	// 30�� ���� n���� ��� ó���� �� �ִ��� ������ Ȯ���Ѵ�.
        	// 30���� �ƴ϶� 20���̿��ٸ� ��� ó���� �� ���� ������ �ּ� �ð��� 21������ �����Ѵ�.
        	if(guest < n) {
        		min = mid + 1;
        	}
        	// 30�� ���� ó���� �� �ֱ� ������ �ִ� �ð��� �� �ٿ�����.
        	else{
        		// ���� ó���ð����� �� ª�� �ð��� ������ �� ������ �����Ѵ�.
        		if(mid <= answer) {
        			answer = mid;
        		}
        		// �ִ�ð��� 29������ �ΰ� �ִ� �ּ� ������ �ٽ� �ٿ�������.
        		max = mid - 1;
        	}
        	
        }
        
        return answer;
    }

}
