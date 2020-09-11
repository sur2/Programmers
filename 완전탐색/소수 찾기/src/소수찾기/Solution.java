package 소수찾기;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

//Level 2 소수 찾기
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
		// 중복되는 숫자를 제외하기 위해 set에 저장
		NumberSet(numbers, set, visit, num);
		// 숫자들을 순회하기 위한 list
		LinkedList<Integer> list = new LinkedList<Integer>(set);
		list.sort((Integer a1,  Integer a2) -> (a2 - a1));
		int maxNum = list.get(0);
		// 에라토스테네스의 체를 이용하여 소수 테이블을 boolean 형의 배열로 작성
		// 정수 N의 까지의 소수를 구하기 위해 N을 숫자들 중에 가장 큰 수로 정한다.
		boolean[] prime = SieveofEratosthenes(maxNum);
		
		for (int i = 0; i < list.size(); i++) {
			if (prime[ list.get(i) ]) {
				answer++;
			}
		}
		System.out.println(answer);
		return answer;
	}
	
	// '에라토스테네스의 체' 응용 소수 판별기
	private static boolean[] SieveofEratosthenes(int max) {
		int N = max + 1;
		boolean[] primeArr = new boolean[N];
		Arrays.fill(primeArr, true);
		// 0과 1은 소수가 아님
		primeArr[0] = false;
		primeArr[1] = false;
		int[] array = new int[N];
		// 정수 N까지의 소수를 구하기 위해서는 N을 2부터 N제곱근 까지의 수를 나눠어 몫이 떨어지는지 확인한다.
		// 제곱급은 구하기 보다 N까지의 수를 제곱하면 제곱근 연산보다 빠르게 수행할 수 있다. 이 방법을 권장한다.
		for (int i = 2; i * i < N; i++) {
			if(primeArr[i]) {
				// i가 소수라면 그 배수는 전부 소수가 될 수 없다.
				// 마찬가지로 제곱근 대신 i의 제곱을 시작으로 i씩 늘어나는 i의 배수는 소수가 아니다.
				for (int j = i * i; j < N; j += i) {
					primeArr[j] = false;
				}
			}
		}
		return primeArr;
	}
	// 순열을 활용하여 모든 숫자 set을 구한다.
	private static void NumberSet(String numbers, Set<Integer> set, boolean[] visit, String num) {
		int max = 0;
		int len = numbers.length();
		String temp = num;
		// 1. 숫자의 자리 수 대로 하나 씩 뽑는다.
		// 1-1. 숫자를 이어붙이고 재귀
		// 1-2. 뽑은 숫자롤 사용하지 않고 재귀
		for (int i = 0; i < len; i++) {
			if (visit[i] == false) {
				visit[i] = true;
				// 뽑읍 숫자를 사용함으로 표시하고, 숫자를 이어붙인다.
				temp += numbers.charAt(i);
				set.add(Integer.parseInt(temp));
				NumberSet(numbers, set, visit, temp);
				// 뽑을 숫자를 사용하지 않음으로 표시하고, 숫자를 붙이지 않고 진행한다.
				visit[i] = false;
				temp = num;
			}
		}
	}
}
