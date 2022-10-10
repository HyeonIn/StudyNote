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