## MST

### MST(최소 신장 트리)

- 그래프에서 최소 비용 문제
  - 모든 정점을 연결하는 간선들의 가중치의 합이 최소가 되는 트리
  - 두 정점 사이의 최소 비용의 경로 찾기
- 신장 트리
  - N 개의 정점으로 이루어진 무향 그래프에서 N개의 정점과 N-1개의 간선으로 이루어진 트리
- 최소 신장트리
  - 무향 가중치 그래프에서 신장 트리를 구성하는 간선들의 가중치의 합이 최소가 되는 신장트리

#### KRUSKAL 알고리즘

- 간선 중심 알고리즘

- 핵심 알고리즘 : 유니온 파인드, 우선순위 큐

1. 모든 간선을 가중치에 따라 오름차순 정렬
  - 우선순위 큐 활용
2. 가중치가 가장 낮은 간선부터 선택하면서 트리를 증가 시킴
  - 사이클이 존재하면 다음으로 가중치가 낮은 간선 선택
  - 사이클을 검사하려면 새로 들어오는 간선이 같은 부분 집합의 원소들을 이어주는지 확인(유니온 파인드)
3. n-1 개의 간선이 선택될 때까지 2를 반복

##### 우선순위 큐를 활용한 KRUSKAL 코드 with Java
```java
package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Edge implements Comparable<Edge>{
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
	}
	static int[] parents;
	static int V, E;
	static PriorityQueue<Edge> edgeList;
	
	static void make() { //크기가 1인 서로소 집합 생성
		parents = new int[V+1];
		for (int i = 1; i <= V; i++) { //모든 노드가 자신을 부모로 하는 (대표자) 집합으로 만듦
			parents[i] = i;
		}
	}
	static int find(int a) { //a의 대표자 찾기
		if (parents[a] == a) {
			return a;
		}
		return parents[a] = find(parents[a]); //우리의 대표자를 나의 부모로 : path compression
	}
	
	static boolean union(int a, int b) { // 리턴값 : true ==> union 성공
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot == bRoot) {
			return false;
		}
		parents[bRoot] = aRoot;
		return true;
	}
    public static void main(String[] args) throws IOException {    
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	V = Integer.parseInt(st.nextToken());
    	E = Integer.parseInt(st.nextToken());
    	
    	make();
    	edgeList = new PriorityQueue<>();
    	
    	for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			edgeList.add(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
    	
    	int result = 0;
    	int count = 0;
    	while (!edgeList.isEmpty()) {
			Edge edge = edgeList.poll();
			if (union(edge.from, edge.to)) {
				result += edge.weight;
				if (++count == V-1) {
					break;
				}
			}			
		}
    	System.out.println(result);
    }
}
```
#### PRIM 알고리즘

- 정점 중심 알고리즘

- 핵심 알고리즘 : 인접리스트

- 하나의 정점에서 연결된 간선들 중에 하나씩 선택하면서 MST를 만들어 가는 방식

1. 임의 정점을 하나 선택해서 시작 
2. 선택한 정점과 인접하는 정점들 중의 최소 비용의 간선이 존재하는 정점을 선택 
3. 모든 정점이 선택될 때 까지 1,2 과정 반복 

- 서로소인 2개의 집합(2 disjoint-sets) 정보를 유지
  - 트리 정점들(tree vertices) - MST를 만들기 위해 선택된 정점들
  - 비트리 정점들(non-tree vertices) - 선택 되지 않은 정점들

##### Prim 코드 with Java

``` java
package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int V, E;
	
	static class Node{
		int vertex, weight;
		Node next;
		public Node(int vertex, int weight, Node next) {
			this.vertex = vertex;
			this.weight = weight;
			this.next = next;
		}
		
	}
    public static void main(String[] args) throws IOException {    
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	V = Integer.parseInt(st.nextToken());
    	E = Integer.parseInt(st.nextToken());
    	
    	Node[] adjList = new Node[V+1]; //각 정점별 인접리스트
    	
    	for (int i = 0; i < E; i++) { 
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			//무향 처리
			adjList[from] = new Node(to, weight, adjList[from]);
			adjList[to] = new Node(from, weight, adjList[to]);
		}
    	
    	//프림 알고리즘에 필요한 자료구조
    	int[] minEdge = new int[V+1]; // 각 정점이 신장트리에 포함된 정점과의 간선 비용 중 최소비용
    	boolean[] visited = new boolean[V+1]; //신장트리에 포함 여부
    	
    	Arrays.fill(minEdge, Integer.MAX_VALUE); //최소값 관리하기 위해 큰 값 세팅
    	
    	//1. 임의의 시작점 처리, 1번 정점을 신장트리의 구성의 시작점
    	minEdge[1] = 0;
    	int result = 0; // 최소 신장트리 비용 누적
    	
    	for (int c = 1; c < V+1; c++) { //V개의 정점 처리하면 끝
			// step 1. 신장트리의 구성에 포함되지 않은 정점 중 최소 비용 정점 선택
    		int min = Integer.MAX_VALUE;
    		int minVertex = -1;
    		for (int i = 1; i < V+1; i++) {
				if (!visited[i] && min > minEdge[i]) {
					min = minEdge[i];
					minVertex = i;
				}
			}
    		// step 2. 신장트리에 추가
    		visited[minVertex] = true;
    		result += min;
    		
    		// step 3. 신장트리에 새롭게 추가되는 정점과 신장트리에 포함되지 않은 정점들의 기존 최소비용과 비교해서 갱신
    		//         신장트리에 새롭게 추가되는 정점의 모든 인접 정점 들여다 보며 처리
    		for (Node temp = adjList[minVertex]; temp != null; temp = temp.next) {
				if (!visited[temp.vertex] && minEdge[temp.vertex] > temp.weight) {
					minEdge[temp.vertex] = temp.weight;
				}
			}
    	}   	
    	
    	System.out.println(result);
    	
    	
    }
}
```