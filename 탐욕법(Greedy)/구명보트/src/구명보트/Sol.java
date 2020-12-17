package ����Ʈ;

import java.util.Arrays;

// Level 2 ����Ʈ
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
		// ���� ū �� �ϳ��� ������� ���� ���� ���غ��鼭 limit ���� ũ�� ���� ���� ���ļ� ��Ʈ�� �¿� ������.
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
