package �Ҽ�ã��;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

//Level 2 �Ҽ� ã��
public class Solution {

	public static void main(String[] args) {
		String numbers = "011";
		solution(numbers);
	}
	
	private static int solution(String numbers) {
		int answer = 0;
		int len = numbers.length();
		Set<Integer> set = new HashSet<Integer>();
		boolean[] visit = new boolean[numbers.length()];
		String num = "";
		// �ߺ��Ǵ� ���ڸ� �����ϱ� ���� set�� ����
		NumberSet(numbers, set, visit, num);
		// ���ڵ��� ��ȸ�ϱ� ���� list
		LinkedList<Integer> list = new LinkedList<Integer>(set);
		list.sort((Integer a1,  Integer a2) -> (a2 - a1));
		int maxNum = list.get(0);
		// �����佺�׳׽��� ü�� �̿��Ͽ� �Ҽ� ���̺��� boolean ���� �迭�� �ۼ�
		// ���� N�� ������ �Ҽ��� ���ϱ� ���� N�� ���ڵ� �߿� ���� ū ���� ���Ѵ�.
		boolean[] prime = SieveofEratosthenes(maxNum);
		
		for (int i = 0; i < list.size(); i++) {
			if (prime[ list.get(i) ]) {
				answer++;
			}
		}
		System.out.println(answer);
		return answer;
	}
	
	// '�����佺�׳׽��� ü' ���� �Ҽ� �Ǻ���
	private static boolean[] SieveofEratosthenes(int max) {
		int N = max + 1;
		boolean[] primeArr = new boolean[N];
		Arrays.fill(primeArr, true);
		// 0�� 1�� �Ҽ��� �ƴ�
		primeArr[0] = false;
		primeArr[1] = false;
		int[] array = new int[N];
		// ���� N������ �Ҽ��� ���ϱ� ���ؼ��� N�� 2���� N������ ������ ���� ������ ���� ���������� Ȯ���Ѵ�.
		// �������� ���ϱ� ���� N������ ���� �����ϸ� ������ ���꺸�� ������ ������ �� �ִ�. �� ����� �����Ѵ�.
		for (int i = 2; i * i < N; i++) {
			if(primeArr[i]) {
				// i�� �Ҽ���� �� ����� ���� �Ҽ��� �� �� ����.
				// ���������� ������ ��� i�� ������ �������� i�� �þ�� i�� ����� �Ҽ��� �ƴϴ�.
				for (int j = i * i; j < N; j += i) {
					primeArr[j] = false;
				}
			}
		}
		return primeArr;
	}
	// ������ Ȱ���Ͽ� ��� ���� set�� ���Ѵ�.
	private static void NumberSet(String numbers, Set<Integer> set, boolean[] visit, String num) {
		int max = 0;
		int len = numbers.length();
		String temp = num;
		// 1. ������ �ڸ� �� ��� �ϳ� �� �̴´�.
		// 1-1. ���ڸ� �̾���̰� ���
		// 1-2. ���� ���ڷ� ������� �ʰ� ���
		for (int i = 0; i < len; i++) {
			if (visit[i] == false) {
				visit[i] = true;
				// ���� ���ڸ� ��������� ǥ���ϰ�, ���ڸ� �̾���δ�.
				temp += numbers.charAt(i);
				set.add(Integer.parseInt(temp));
				NumberSet(numbers, set, visit, temp);
				// ���� ���ڸ� ������� �������� ǥ���ϰ�, ���ڸ� ������ �ʰ� �����Ѵ�.
				visit[i] = false;
				temp = num;
			}
		}
	}
}
