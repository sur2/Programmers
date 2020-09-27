// Level 3 Á¤¼ö »ï°¢Çü
public class Sol {

	public static void main(String[] args) {

		Sol sol = new Sol();
		int[][] triangle = { { 7 }, { 3, 8 }, { 8, 1, 0 }, { 2, 7, 4, 4 }, { 4, 5, 2, 6, 5 } };
		sol.solution(triangle);
	}

	public int solution(int[][] triangle) {
		int answer = 0;
		int size = triangle.length;
		int[][] table = new int[size][size];

		answer = Calculator(triangle, table);

		return answer;
	}

	public int Calculator(int[][] triangle, int[][] table) {
		int result = 0;
		
		for (int i = 0; i < triangle.length; i++) {
			for (int j = 0; j < triangle[i].length; j++) {
				table[i][j] = triangle[i][j];
			}
		}

		for (int i = 1; i < triangle.length; i++) {
			for (int j = 0; j < triangle[i].length; j++) {
				int left = -1;
				if (j - 1 > -1) {
					left = table[i][j] + table[i - 1][j - 1];
				}
				int right = table[i][j] + table[i - 1][j];
				table[i][j] = Math.max(left, right);
			}
		}
		
		for (int i = 0; i < triangle.length; i++) {
			for (int j = 0; j < triangle[i].length; j++) {
				System.out.print(table[i][j] + " ");
			}
			System.out.println();
		}
		int lastRow = table.length - 1;
		for (int i = 0; i < table[lastRow].length; i++) {
			if (result < table[lastRow][i]) {
				result = table[lastRow][i];
			}
		}
		
		return result;
	}
}
