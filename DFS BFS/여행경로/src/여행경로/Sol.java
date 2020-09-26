package 여행경로;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Sol {

	public static void main(String[] args) {

		Sol sol = new Sol();

		String[][] tickets = { { "ICN", "A"}, {"A", "C"}, {"A", "D"}, {"D", "B"}, {"B", "A" }};
		sol.solution(tickets);
		
		
	}

	public String[] solution(String[][] tickets) {
		String[] answer = {};
		
		List<String[]> list = new LinkedList<String[]>();
		
		for (int i = 0; i < tickets.length; i++) {
			list.add(tickets[i]);
		}
		
		list.sort(new Comparator<String[]>() {
			@Override
			public int compare(String[] o1, String[] o2) {
				if (o1[0].equals(o2[0])) {
					return o1[1].compareTo(o2[1]);
				}
				return o1[0].compareTo(o2[0]);
			}
		});
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(Arrays.toString(list.get(i)));
		}
		
		boolean[] visit = new boolean[tickets.length];
		
		List<String> ans = new LinkedList<String>();
		ans.add("ICN");
		DFS(list, "ICN", visit, ans, 0);
		
		answer = new String[ans.size()];
		
		for (int i = 0; i < ans.size(); i++) {
			answer[i] = ans.get(i);
		}
		
		System.out.println(Arrays.toString(answer));
		return answer;
	}
	
	public boolean DFS(List<String[]> list, String src, boolean[] visit, List<String> ans, int cnt) {
		for (int i = 0; i < visit.length; i++) {
			if (list.get(i)[0].equals(src) && !visit[i]) {
				visit[i] = true;
				ans.add(list.get(i)[1]);
				boolean search = DFS(list, list.get(i)[1], visit, ans, cnt + 1);
				if (search) {
					return true;
				}
				visit[i] = false;
			}
		}
		
		if(list.size() == cnt) {
			return true;
		}
		else {
			ans.remove(ans.size() - 1);
			return false;
		}
	}
}
