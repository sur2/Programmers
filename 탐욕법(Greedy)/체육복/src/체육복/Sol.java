package Ã¼À°º¹;

import java.util.LinkedList;
import java.util.List;

// Level 1 Ã¼À°º¹
public class Sol {

	public static void main(String[] args) {

		Sol s = new Sol();
		int n = 3;
		int[] lost = { 3 };
		int[] reserve = { 1 };
		int result = s.solution(n, lost, reserve);
		System.out.println(result);
	}
	
	public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        boolean has[] = new boolean[n + 1];
        
        for (int i = 0; i < reserve.length; i++) {
			has[reserve[i]] = true;
		}
        
        List<Integer> LostList = new LinkedList<Integer>();
        
        for (int i = 0; i < lost.length; i++) {
			if(has[lost[i]]) {
				has[lost[i]] = false;
			}
			else {
				LostList.add(lost[i]);				
			}
		}
        
        for (int i = 0; i < LostList.size(); i++) {
			if(LostList.get(i) + 1 <= n && LostList.get(i) - 1 >= 0) {
				if(has[LostList.get(i) + 1]) {
					has[LostList.get(i) + 1] = false;
					LostList.remove(i);
					i--;
				}
				else if(has[LostList.get(i) - 1]) {
					has[LostList.get(i) - 1] = false;
					LostList.remove(i);
					i--;
				}
			}
		}

        answer = n - LostList.size();
        return answer;
    }

}
