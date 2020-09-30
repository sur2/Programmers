import java.util.Arrays;
// Level 3 등굣길
public class Sol {

	public static void main(String[] args) {
		Sol sol = new Sol();
		// 가로
		int m = 4;
		// 세로
		int n = 3;
		int[][] puddles = {{2, 2}};
		sol.solution(m, n, puddles);
	}
	
	public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] map = new int[n + 1][m + 1];
        map[1][1] = 1;
        for (int i = 0; i < puddles.length; i++) {
			map[puddles[i][1]][puddles[i][0]] = -1;
		}
        /*
        for (int i = 0; i < m + 1; i++) {
			map[0][i] = -1;
		}
        for (int i = 0; i < n + 1; i++) {
			map[i][0] = -1;
		}
        */
        
        Search(map);
        /*
        for (int i = 0; i < map.length; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
        */
        answer = map[n][m];
        System.out.println(answer);
        
        return answer;
    }
	
	public void Search(int[][] map) {
		for (int i = 1; i < map.length; i++) {
			for (int j = 1; j < map[i].length; j++) {
				if (map[i][j] == -1) {
					map[i][j] = 0;
				} else {
					if (i == 1) {
						map[i][j] += map[i][j - 1];
					} else {
						map[i][j] = map[i][j - 1] + map[i - 1][j];
						map[i][j] %= 1000000007;
					}
				}
			}
		}
	}

}
