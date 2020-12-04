
// Level 2 큰 수 만들기
public class Sol {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sol s = new Sol();
		String number = "4177252841";
		int k = 4;
		String result = s.solution(number, k);
		System.out.println(result);
	}

	public String solution(String number, int k) {
		StringBuilder answer = new StringBuilder();
		int chance = number.length() - k;
		int idx = 0;
		for (int c = 0; c < chance; c++) {
			char max = 0;
			int maxi = -1;
			for (int i = idx; i <= k + c; i++) {
				char num = number.charAt(i);
				// 9보다 큰 수는 나올 수 없기 때문에 최대값으로 보고 반복문 종료
				if (num == '9') {
					max = num;
					maxi = i;
					break;
				}
				if (num > max) {
					max = num;
					maxi = i;
				}
			}
			idx = maxi + 1;
			answer.append(max);
		}
		
		return answer.toString();
	}

}
