import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class Element implements Comparable<Element>{
	String number;
	
	Element (String number) {
		this.number = number;
	}
	
	@Override
	public int compareTo(Element o) {
		int oIndex = 0, nIndex = 0;
		while(oIndex < o.number.length() && number.length() > nIndex) {
			if (o.number.charAt(oIndex) > number.charAt(nIndex)) {
				return 1;
			} else if(o.number.charAt(oIndex) < number.charAt(nIndex)) {
				return -1;
			}
			else {
				oIndex = (oIndex < o.number.length() - 1) ? oIndex + 1 : oIndex;
				nIndex = (nIndex < number.length() - 1) ? nIndex + 1 : nIndex;
				continue;
			}
		}
		return 0;
	}
	
	@Override
	public String toString() {
		
		return number;
	}
}

public class Solution {
	
	
	private static int[] numbers = {3, 30, 34, 5, 9};
	public static void main(String[] args) {
		String answer = "";
		
		List<Element> list = new LinkedList<>();
		
		for (int i = 0; i < numbers.length; i++) {
			Element e = new Element(numbers[i] + "");
			list.add(e);
		}
		
		Collections.sort(list);
		System.out.println(list);
		
		for (int i = 0; i < list.size(); i++) {
			answer += list.get(i).number;
		}
		
		System.out.println(answer);
	}

}

