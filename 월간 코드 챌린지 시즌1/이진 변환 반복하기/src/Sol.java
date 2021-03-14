import java.util.Arrays;

// 이진 변환 반복하기
public class Sol {

	public static void main(String[] args) {
		Sol solution = new Sol();
		String s = "01110";
		int[] result = null;
		result = solution.solution(s);
		System.out.println(Arrays.toString(result));
	}
	
	public int[] solution(String s) {
        int[] answer = {};
        answer = new int[2];
        String binary = s;
        while(binary.length() > 1) {
        	binary = deleteZero(answer, binary);
        	answer[0]++;
        }
        return answer;
    }
	
	public String deleteZero(int[] arr, String binary) {
		int len = binary.length();
		int delCnt = 0;
		for (int i = 0; i < len; i++) {
			if(binary.charAt(i) == '0') {
				delCnt++;
			}
		}
		len -= delCnt;
		arr[1] += delCnt;
		return Integer.toBinaryString(len);
	}
}
