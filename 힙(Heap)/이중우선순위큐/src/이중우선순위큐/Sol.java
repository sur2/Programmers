package 이중우선순위큐;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

// Level 3 이중우선순위큐
public class Sol {

	public static void main(String[] args) {

		Sol sol = new Sol();
		//String[] operations = {"I 7","I 5","I -5","D -1"};
		//String[] operations = {"I 10000", "D -1", "I 4", "I 3", "I 2", "I 1"};
		String[] operations = {"I 7", "I 5", "I -5", "D -1"};
		
		sol.solution(operations);
	}
	
	public int[] solution(String[] operations) {
        int[] answer = {};
        
        List<Integer> list = new LinkedList<Integer>();
        
        for (String oper : operations) {
			StringTokenizer st = new StringTokenizer(oper);
			String inout = st.nextToken();
			int num = Integer.parseInt(st.nextToken());
			// 오름차순으로 정렬되게 추가
			if (inout.equals("I")) {
				AddNum(list, num);
			}
			else if(inout.equals("D")) {
				if (list.isEmpty()) {
					continue;
				}
				// 최대값 삭제
				if (num == 1) {
					list.remove(list.size() - 1);
				}
				// 최소값 삭제
				else if(num == -1) {
					list.remove(0);
				}
			}
		}
        
        //System.out.println(list);
        
        answer = new int[2];
        // [최대값, 최소값]으로 반환, 원소가 하나이면 0을 추가하여 [최대값, 최소값]으로 반환
        if (list.size() == 1) {
			if (list.get(0) > 0) {
				answer[0] = list.get(0);
			}
			else {
				answer[1] = list.get(0);
			}
		}
        else if(list.size() > 1) {
        	answer[1] = list.get(0);
        	answer[0] = list.get(list.size() - 1);
        }
        
        System.out.println(Arrays.toString(answer));
        return answer;
    }
	
	
	public void AddNum(List<Integer> list, int num) {
		int max = 0, min = 0;
		// list가 비어져있으면 그냥 추가
		if (list.isEmpty()) {
			list.add(num);
		}
		// list에 원소가 하나면 단일 원소 기준으로 앞 또는 뒤에 추가
		else if (list.size() < 2) {
			max = list.get(0);
			min = max;
			
			if (max < num) {
				list.add(num);
			}
			else {
				list.add(0, num);
			}
		}
		// 원소가 2개 이상이면 오름차순으로 정렬되게 추가
		else if(list.size() > 1) {
			max = list.get(list.size() - 1);
			min = list.get(0);
			
			if (max < num) {
				list.add(num);
			}
			else if(min > num) {
				list.add(0, num);
			}
			else {
				list.add(num);
				list.sort(null);
			}
		}	
	}
}
