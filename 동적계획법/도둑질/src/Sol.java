import java.util.Arrays;

// Level 4 µµµÏÁú
public class Sol {

	public static void main(String[] args) {
		Sol sol = new Sol();
		int[] money = {1, 2, 3, 1};
		sol.solution(money);
	}
	
	public int solution(int[] money) {
        int answer = 0;
        
        int len = money.length;
        int case1[] = new int[len];
        int case2[] = new int[len];
        
        case1[0] = money[0];
        case1[1] = money[0];
        case2[1] = money[1];
        
        for (int i = 2; i < money.length - 1; i++) {
        	case1[i] = Math.max(case1[i - 2] + money[i], case1[i - 1]);
		}
        for (int i = 2; i < money.length; i++) {
        	case2[i] = Math.max(case2[i - 2] + money[i], case2[i - 1]);
		}
        /*
        System.out.println(Arrays.toString(case1));
        System.out.println(Arrays.toString(case2));
        */
        int last = len - 1;
        answer = case1[last - 1] > case2[last] ? case1[last - 1] : case2[last];
        //System.out.println(answer);
        return answer;
    }

}
