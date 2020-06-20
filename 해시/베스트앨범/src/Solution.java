import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

// 노래의 장르, 재생횟수, 곡:Index를 담을 Music Class
class Music implements Comparable<Music> {

	public String genre = "";
	public int play = 0;
	public int index = 0;

	public Music(String genre, int play, int index) {
		this.genre = genre;
		this.play = play;
		this.index = index;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "(" + genre + ", " + play + ", " + index + ") ";
	}

	// Music 객체 정렬 시 비교되는 객체의 재생횟수가 현재 객체보다 재생횟수보다 크다면 양수를 반환하여 우선 정렬된다.(내림차순)
	@Override
	public int compareTo(Music o) {
		return o.play - this.play;
	}
}

public class Solution {
	// 문제에서 주어지는 정보
	private static String[] genres = { "classic", "pop", "classic", "classic", "pop", "test", "test", "test" };
	private static int[] plays = { 500, 600, 150, 800, 2500, 800, 1000,  100};

	public static void main(String[] args) {
		int answer[] = {};

		// 장르별 재생횟수를 담는 HashMap KEY(장르)의 중복을 허용하지 않는 점을 이용
		Map<String, Integer> musicMap = new HashMap<>();
		// 곡의 정보를 담는 List 객체 생성
		List<Music> musicList = new LinkedList<Music>();

		for (int i = 0; i < genres.length; i++) {
			//  KEY(장르)의 중복을 허용하지 않아 같은 KEY(장르)에는 재생횟수만 더하여 Map에 담는다.
			musicMap.put(genres[i], musicMap.getOrDefault(genres[i], 0) + plays[i]);
			// List에는 모든 곡의 정보를 담는다.
			musicList.add(new Music(genres[i], plays[i], i));
		}
		
		// 모든 곡이 담긴 List를 정렬한다.
		musicList.sort(new Comparator<Music>() {
			@Override
			public int compare(Music o1, Music o2) {
				// 정렬 시 두 곡의 장르명이 같다면 재생횟수 순으로 내림차순
				if (o1.genre.equals(o2.genre)) {
					return o1.compareTo(o2);
				}
				// 두 곡의 장르명이 다르다면 장르별 통합 재생횟수 순으로 내림차순한다.
				// 장르별 통합 재생횟수는 Map을 통해 쉽게 비교할 수 있다.
				else {
					return musicMap.get(o2.genre) - musicMap.get(o1.genre);
				}
			}
		});
		
		System.out.println(musicList.toString());
		// 장르별 최대 두 곡을 재생횟수 순으로 담는 List이다.
		List<Music> choiceList = new LinkedList<Music>();
		String temp = "";
		int cnt = 0;
		for (int i = 0; i < musicList.size(); i++) {
			// 이전 곡의 정보를 기억하여 장르가 다르다면 List에 추가한다.
			if (!temp.equals(musicList.get(i).genre)) {
				choiceList.add(musicList.get(i));
				temp = musicList.get(i).genre;
				cnt = 0;
			}
			// 이전 곡과 같은 장르를 한 번 이상 넣었다면 다음 장르를 찾아 반복문을 넘긴다.
			else if(cnt > 0)
			{
				continue;
			}
			// 이전 곡과 같은 장르의 노래를 한 번 이상 넣지 않았다면 List에 담는다.
			else {
				choiceList.add(musicList.get(i));
				cnt++;
			}
			
		}
		// choiceList를 answer배열에 담아 정답을 완성한다.
		answer = new int[choiceList.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = choiceList.get(i).index;
		}
		System.out.println(choiceList.toString());
		System.out.println(Arrays.toString(answer));
	}

}
