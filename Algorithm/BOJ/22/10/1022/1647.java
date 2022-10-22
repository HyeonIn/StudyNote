package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
	static int V, E;
	static PriorityQueue<Edge> edgeList;
	static int[] parents;
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
    	int max = Integer.MIN_VALUE;
    	while (!edgeList.isEmpty()) {
			Edge temp = edgeList.poll();
			if (union(temp.from, temp.to)) {
				result += temp.weight;
				max = Math.max(max, temp.weight);
				if (++count == V-1) {
					break;
				}
			}
		}
    	
    	System.out.println(result - max);
	}
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
	
	
}
