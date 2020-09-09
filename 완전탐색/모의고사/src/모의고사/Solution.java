package 모의고사;

import java.util.Arrays;
import java.util.LinkedList;

// Level 1 모의고사
public class Solution {

	public static void main(String[] args) {
		int[] answers = {1, 2, 3, 4, 5};
		solution(answers);
	}
	
	private static int[] solution(int[] answers) {
		int[] answer = {};
		
		int fail1[] = new int[10000];
		int fail2[] = new int[10000];
		int fail3[] = new int[10000];
		
		int ii = 0;
		int iii = 0;
		for (int i = 0; i < 10000; i++) {
			fail1[i] = i % 5 + 1;
			
			if(i % 2 == 0)
				fail2[i] = 2;
			else if (i % 8 == 1)
				fail2[i] = 1;
			else if (i % 8 == 3)
				fail2[i] = 3;
			else if (i % 8 == 5)
				fail2[i] = 4;
			else if (i % 8 == 7)
				fail2[i] = 5;
			
			if((i / 2) % 5 == 0)
				fail3[i] = 3;
			else if((i / 2) % 5 == 1)
				fail3[i] = 1;
			else if((i / 2) % 5 == 2)
				fail3[i] = 2;
			else if((i / 2) % 5 == 3)
				fail3[i] = 4;
			else if((i / 2) % 5 == 4)
				fail3[i] = 5;
		}
		
		int cnt1 = 0;
		int cnt2 = 0;
		int cnt3 = 0;
		
		for (int i = 0; i < answers.length; i++) {
			if (fail1[i] == answers[i]) 
				cnt1++;

			if (fail2[i] == answers[i]) 
				cnt2++;
			
			if (fail3[i] == answers[i]) 
				cnt3++;
		}
		
		LinkedList<Integer> llist = new LinkedList<Integer>();
		int max = Math.max(cnt1, Math.max(cnt2, cnt3));

		if (max == cnt1)
			llist.add(1);
		
		if (max == cnt2)
			llist.add(2);
		
		if (max == cnt3)
			llist.add(3);
		
		answer = new int[llist.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = llist.get(i);
		}
		
		System.out.println(Arrays.toString(answer));
		return answer;
	}

}
