import java.util.Arrays;

public class Solution {

	private static String[] phone_book = { "12", "123", "1235", "567", "88" };
	//private static String[] phone_book = { "123","456","789"};

	public static void main(String[] args) {

		boolean answer = true;
		Arrays.sort(phone_book);
		System.out.println(Arrays.toString(phone_book));
		boolean check = false;
		for (int i = 0; i < phone_book.length - 1; i++) {
			if (phone_book[i].length() < phone_book[i + 1].length()) {
				System.out.println(phone_book[i + 1].substring(0, phone_book[i].length()));
				if(phone_book[i + 1].substring(0, phone_book[i].length()).equals(phone_book[i])) {
					answer = false;
					check = true;
					break;
				}
			}
		}
		
		System.out.println(answer);
	}
}
