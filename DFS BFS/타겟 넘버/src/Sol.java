// Level 2 타켓 넘버
public class Sol {
	public int cnt = 0;
	public static void main(String[] args) {

		Sol sol = new Sol();
		int[] numbers = {1, 1, 1, 1, 1};
		sol.solution(numbers, 3);
	}

	public int solution(int[] numbers, int target) {
		int answer = 0;
		DFS(numbers, target, 0, 0);
		System.out.println(cnt);
		answer = cnt;
		return answer;
	}
	
	private void DFS(int[] numbers, int target, int value, int start) {
		int len = numbers.length;
		int val = value;
		for (int i = start; i < len; i++) {
			value += numbers[i];
			DFS(numbers, target, value, i + 1);
			value -= numbers[i];
			value -= numbers[i];
		}
		
		if(value == target) {
			cnt++;
		}
			
	}
}
