// Level 2 카펫
public class Sol {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sol sol = new Sol();
		sol.solution(24, 24);
	}
	
	public int[] solution(int brown, int yellow) {
        int[] answer = {};
        
        //  i)  2(w - 2) + 2(h - 2) + 4 = brown
        //  i)  2(w + h) = brown + 4
        //  i)  w + h = (brown + 4) / 2
        
        // ii)  w * h = brown + yellow

        // w, h를 구하는 이차 방정식 (해가 두 개인 이차 방정식)
        // (x - w)(w - h) = 0
        // x ^ 2 - (w + h) * x + (w * h) = 0
        
        // 근의 공식 x = {-b ± √(b ^ 2 - 4 * a * c)} / 2 * a
        // a = 1
        // b = - (w + h)
        // c = w * h
        
        int wph = (brown + 4) / 2;
        int wmh = brown + yellow;
        
        int a = 1, b = -1 * wph, c = wmh;
        
        int w = (int) (-1 * b + Math.sqrt(b * b - 4 * a * c)) / (2 * a);
        int h = (int) (-1 * b - Math.sqrt(b * b - 4 * a * c)) / (2 * a);
        
        // System.out.println(w + ", " + h);
        
        answer = new int[2];
        answer[0] = w;
        answer[1] = h;
        
        return answer;
    }
}
