import java.util.ArrayList;
import java.util.Collections;

// �� �����ϱ�
public class Sol {

	public static void main(String[] args) {
		Sol s = new Sol();
		int n = 4;
		int[][] costs = { { 0, 1, 1 }, { 0, 2, 2 }, { 1, 2, 5 }, { 1, 3, 1 }, { 2, 3, 8 } };
		int result = s.solution(n, costs);
		System.out.println("cost: " + result);
	}

	public int solution(int n, int[][] costs) {
		int answer = 0;
		
		// ��Ʈ ��带 ���� �迭
		int[] rootArray = new int[n];
		
		// ó������ ��� �ڽ��� ��Ʈ�� �ʱ�ȭ
		for (int i = 0; i < n; i++) {
			rootArray[i] = i;
		}
		
		// ������ �� ��带 ���� ����Ʈ
		ArrayList<Edge> edgeList = new ArrayList<Edge>();
		
		// ����Ʈ�� ������ �� ��带 ����
		for (int[] is : costs) {
			int nodeA = is[0];
			int nodeB = is[1];
			int distance = is[2];
			
			edgeList.add(new Edge(distance, nodeA, nodeB));
		}
		
		// �Ÿ�(���)�� �������� �������� ����
		Collections.sort(edgeList);
		
		int listSize = edgeList.size();
		
		// �� ��尡 ����Ŭ �������� �ʴ´ٸ� ������ ����� ���Ѵ�.
		for (Edge edge : edgeList) {
			int nodeA = edge.getNodeA();
			int nodeB = edge.getNodeB();
			
			int rootA = findParents(rootArray, nodeA);
			int rootB = findParents(rootArray, nodeB);
			
			if(rootA != rootB) {
				unionNode(rootArray, nodeA, nodeB);
				answer += edge.getDistance();
			}
		}
		
		return answer;
	}
	
	// �θ� ��带 ã�� �Լ�
	public int findParents(int[] arr, int n) {
		if(arr[n] == n) {
			return n;
		}
		return arr[n] = findParents(arr, arr[n]);
	}
	
	// �� ��带 ��ġ�� �Լ�
	public void unionNode(int[] arr, int a, int b) {
		int rootA = findParents(arr, a);
		int rootB = findParents(arr, b);
		
		if(rootA < rootB) {
			arr[rootB] = rootA;
		} else {
			arr[rootA] = rootB;
		}
	}
}


// �� ���� ������ �����ϴ� Ŭ����
class Edge implements Comparable<Edge> {

	private int distance;
	private int nodeA;
	private int nodeB;
	
	public Edge(int distance, int nodeA, int nodeB) {
		this.distance = distance;
		this.nodeA = nodeA;
		this.nodeB = nodeB;
	}
	
	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public int getNodeA() {
		return nodeA;
	}

	public void setNodeA(int nodeA) {
		this.nodeA = nodeA;
	}

	public int getNodeB() {
		return nodeB;
	}

	public void setNodeB(int nodeB) {
		this.nodeB = nodeB;
	}

	@Override
	public int compareTo(Edge o) {
		// TODO Auto-generated method stub
		return this.distance - o.distance;
	}
	
}
