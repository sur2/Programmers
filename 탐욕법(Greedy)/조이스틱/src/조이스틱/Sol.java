package 조이스틱;

import java.util.Arrays;

public class Sol {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sol s = new Sol();
		int result = s.solution("JAN");
		System.out.println(result);
	}
	
	public int solution(String name) {
        int answer = 0;
        int UpAndDown = 0;
        int move = name.length() - 1;
        // 위, 아래 최소 움직임
        for (int i = 0; i < name.length(); i++) {
			int up = name.charAt(i) - 'A';
			int down = 'Z' - name.charAt(i) + 1;
        	UpAndDown += Math.min(up, down);
		}
        
        for (int i = 0; i < name.length(); i++) {
        	int next = i + 1; 
			while(next < name.length() && name.charAt(next) == 'A')
				next++;
			// i 오른쪽 만큼 왼쪽으로 돌아감
			// next 만큼의 index로 왼쪽으로 역행 
			int reverse = i * 2 + name.length() - next;
			move = Math.min(move, reverse);
		}
        
        answer += UpAndDown + move;
        
        return answer;
    }
}
