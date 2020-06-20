import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

// �뷡�� �帣, ���Ƚ��, ��:Index�� ���� Music Class
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

	// Music ��ü ���� �� �񱳵Ǵ� ��ü�� ���Ƚ���� ���� ��ü���� ���Ƚ������ ũ�ٸ� ����� ��ȯ�Ͽ� �켱 ���ĵȴ�.(��������)
	@Override
	public int compareTo(Music o) {
		return o.play - this.play;
	}
}

public class Solution {
	// �������� �־����� ����
	private static String[] genres = { "classic", "pop", "classic", "classic", "pop", "test", "test", "test" };
	private static int[] plays = { 500, 600, 150, 800, 2500, 800, 1000,  100};

	public static void main(String[] args) {
		int answer[] = {};

		// �帣�� ���Ƚ���� ��� HashMap KEY(�帣)�� �ߺ��� ������� �ʴ� ���� �̿�
		Map<String, Integer> musicMap = new HashMap<>();
		// ���� ������ ��� List ��ü ����
		List<Music> musicList = new LinkedList<Music>();

		for (int i = 0; i < genres.length; i++) {
			//  KEY(�帣)�� �ߺ��� ������� �ʾ� ���� KEY(�帣)���� ���Ƚ���� ���Ͽ� Map�� ��´�.
			musicMap.put(genres[i], musicMap.getOrDefault(genres[i], 0) + plays[i]);
			// List���� ��� ���� ������ ��´�.
			musicList.add(new Music(genres[i], plays[i], i));
		}
		
		// ��� ���� ��� List�� �����Ѵ�.
		musicList.sort(new Comparator<Music>() {
			@Override
			public int compare(Music o1, Music o2) {
				// ���� �� �� ���� �帣���� ���ٸ� ���Ƚ�� ������ ��������
				if (o1.genre.equals(o2.genre)) {
					return o1.compareTo(o2);
				}
				// �� ���� �帣���� �ٸ��ٸ� �帣�� ���� ���Ƚ�� ������ ���������Ѵ�.
				// �帣�� ���� ���Ƚ���� Map�� ���� ���� ���� �� �ִ�.
				else {
					return musicMap.get(o2.genre) - musicMap.get(o1.genre);
				}
			}
		});
		
		System.out.println(musicList.toString());
		// �帣�� �ִ� �� ���� ���Ƚ�� ������ ��� List�̴�.
		List<Music> choiceList = new LinkedList<Music>();
		String temp = "";
		int cnt = 0;
		for (int i = 0; i < musicList.size(); i++) {
			// ���� ���� ������ ����Ͽ� �帣�� �ٸ��ٸ� List�� �߰��Ѵ�.
			if (!temp.equals(musicList.get(i).genre)) {
				choiceList.add(musicList.get(i));
				temp = musicList.get(i).genre;
				cnt = 0;
			}
			// ���� ��� ���� �帣�� �� �� �̻� �־��ٸ� ���� �帣�� ã�� �ݺ����� �ѱ��.
			else if(cnt > 0)
			{
				continue;
			}
			// ���� ��� ���� �帣�� �뷡�� �� �� �̻� ���� �ʾҴٸ� List�� ��´�.
			else {
				choiceList.add(musicList.get(i));
				cnt++;
			}
			
		}
		// choiceList�� answer�迭�� ��� ������ �ϼ��Ѵ�.
		answer = new int[choiceList.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = choiceList.get(i).index;
		}
		System.out.println(choiceList.toString());
		System.out.println(Arrays.toString(answer));
	}

}
