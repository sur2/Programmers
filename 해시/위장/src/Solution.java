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
		// Map<�ǻ��� ����, �ǻ��� ����> KEY(����) ���� VALUE(����) 1���� ��� �����ϴ� KEY(����)�� �ִٸ� VALUE(����)�� ���Ѵ�.
		for (int i = 0; i < clothes.length; i++) {
			if(map.containsKey(clothes[i][1])) {
				int temp = map.get(clothes[i][1]);
				map.put(clothes[i][1], ++temp);
			}
			else {
				map.put(clothes[i][1], 1);
			}
		}
		
		// Map�� KEY, VALUE�� ����ϱ� ���� Map.Entry Interface�� Set�� ��� ���
		Set<Map.Entry<String, Integer>> entriesSet = map.entrySet();
		for (Map.Entry<String, Integer> element : entriesSet) {
			System.out.println("KEY : " + element.getKey() + ",  VALUE : " + element.getValue());
		} 
		/* Lambda���� ��� �Ʒ��� ����
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
