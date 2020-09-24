
// Level 3 단어 변환
public class Sol {
	int count = Integer.MAX_VALUE;
	
	public static void main(String[] args) {

		Sol sol = new Sol();
		String begin = "hit";
		String target = "cog";
		String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
		sol.solution(begin, target, words);
	}
	
	public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        boolean[] visit = new boolean[words.length];
        dfs(begin, target, words, visit, 0);
        if (count == Integer.MAX_VALUE) {
			count = 0;
		}
        answer = count;
        System.out.println(answer);
        
        return answer;
    }
	
	// DFS
	public void dfs(String begin, String target, String[] words, boolean[] visit, int cnt) {
		if (target.equals(begin)) {
			count = cnt < count ? cnt : count;
			return;
		}
		for (int i = 0; i < visit.length; i++) {
			if (!visit[i] && compareString(begin, words[i])) {
				visit[i] = true;
				//System.out.println(words[i]);
				dfs(words[i], target, words, visit, cnt + 1);
				visit[i] = false;
			}
		}
	}
	
	// 한 자리만 다른지 비교
	public boolean compareString(String a, String b) {
		int cnt = 0;
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) != b.charAt(i)) {
				cnt++;
			}
			
			if (cnt > 1) {
				return false;
			}
		}
		
		if (cnt == 1) {
			return true;
		}
		else {
			return false;
		}
	}

}
