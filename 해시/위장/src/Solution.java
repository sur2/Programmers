import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Solution {
	private static String[][] clothes = { 
			{ "yellow_hat", "headgear" }, 
			{ "blue_sunglasses", "eyewear" },
			{ "green_turban", "headgear" } };

	public static void main(String[] args) {
		int answer = 0;
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		// Map<의상의 종류, 의상의 개수> KEY(종류) 마다 VALUE(개수) 1개를 담고 존재하는 KEY(종류)가 있다면 VALUE(개수)를 더한다.
		for (int i = 0; i < clothes.length; i++) {
			if(map.containsKey(clothes[i][1])) {
				int temp = map.get(clothes[i][1]);
				map.put(clothes[i][1], ++temp);
			}
			else {
				map.put(clothes[i][1], 1);
			}
		}
		
		// Map의 KEY, VALUE를 출력하기 위해 Map.Entry Interface를 Set에 담아 출력
		Set<Map.Entry<String, Integer>> entriesSet = map.entrySet();
		for (Map.Entry<String, Integer> element : entriesSet) {
			System.out.println("KEY : " + element.getKey() + ",  VALUE : " + element.getValue());
		} 
		/* Lambda식의 경우 아래와 같음
		map.forEach((key, value) -> {
			System.out.println("KEY : " + key + ",  VALUE : " + value);
		});
		*/
		
		answer = 1;
		for (int clothesCase : map.values()) {
			answer *= (clothesCase + 1);
		} 
		answer--;
		
		System.out.println(answer);
		
	}
}
