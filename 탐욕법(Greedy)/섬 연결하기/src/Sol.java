import java.util.ArrayList;
import java.util.Collections;

// 섬 연결하기
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
		
		// 루트 노드를 담을 배열
		int[] rootArray = new int[n];
		
		// 처음에는 노드 자신을 루트로 초기화
		for (int i = 0; i < n; i++) {
			rootArray[i] = i;
		}
		
		// 간선과 두 노드를 담을 리스트
		ArrayList<Edge> edgeList = new ArrayList<Edge>();
		
		// 리스트에 간선과 두 노드를 담음
		for (int[] is : costs) {
			int nodeA = is[0];
			int nodeB = is[1];
			int distance = is[2];
			
			edgeList.add(new Edge(distance, nodeA, nodeB));
		}
		
		// 거리(비용)을 기준으로 오름차순 정렬
		Collections.sort(edgeList);
		
		int listSize = edgeList.size();
		
		// 두 노드가 사이클 형성하지 않는다면 간선의 비용을 더한다.
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
	
	// 부모 노드를 찾는 함수
	public int findParents(int[] arr, int n) {
		if(arr[n] == n) {
			return n;
		}
		return arr[n] = findParents(arr, arr[n]);
	}
	
	// 두 노드를 합치는 함수
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


// 두 노드와 간선을 저장하는 클래스
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
