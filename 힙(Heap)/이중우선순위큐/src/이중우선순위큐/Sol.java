package ���߿켱����ť;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

// Level 3 ���߿켱����ť
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
			// ������������ ���ĵǰ� �߰�
			if (inout.equals("I")) {
				AddNum(list, num);
			}
			else if(inout.equals("D")) {
				if (list.isEmpty()) {
					continue;
				}
				// �ִ밪 ����
				if (num == 1) {
					list.remove(list.size() - 1);
				}
				// �ּҰ� ����
				else if(num == -1) {
					list.remove(0);
				}
			}
		}
        
        //System.out.println(list);
        
        answer = new int[2];
        // [�ִ밪, �ּҰ�]���� ��ȯ, ���Ұ� �ϳ��̸� 0�� �߰��Ͽ� [�ִ밪, �ּҰ�]���� ��ȯ
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
		// list�� ����������� �׳� �߰�
		if (list.isEmpty()) {
			list.add(num);
		}
		// list�� ���Ұ� �ϳ��� ���� ���� �������� �� �Ǵ� �ڿ� �߰�
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
		// ���Ұ� 2�� �̻��̸� ������������ ���ĵǰ� �߰�
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
