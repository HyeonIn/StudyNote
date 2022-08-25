package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Main {
	static int N, M;
	
	static class Node implements Comparable<Node>{
		int weight, num;
		
		public Node(int weight, int num) {
			this.weight = weight;
			this.num = num;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			if (weight > o.weight) {
				return 1;
			}
			else if (weight < o.weight) {
				return -1;
			}
			return 0;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		LinkedList<Node>[] adjList = new LinkedList[N+1];
		
		for (int i = 1; i < N+1; i++) {
			adjList[i] = new LinkedList<>();
		}
		
		String[] temp;
		for (int i = 0; i < M; i++) {
			temp = br.readLine().split(" ");
			int from = Integer.parseInt(temp[0]);
			int to = Integer.parseInt(temp[1]);
			int weight = Integer.parseInt(temp[2]);
			
			adjList[from].add(new Node(weight, to));
			adjList[to].add(new Node(weight, from));
					 
		}
		
		boolean[] visited = new boolean[N+1];
		int result = 0;
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(0, 1));
		
		int vertexCnt = 0;
		while (!pq.isEmpty()) {
			Node minNode = pq.poll();
			
			if (visited[minNode.num]) {
				continue;
			}
			
			result += minNode.weight;
			visited[minNode.num] = true;
			vertexCnt++;
			if (vertexCnt == N) {
				break;
			}
			
			for (Node node : adjList[minNode.num]) {
				if (!visited[node.num]) {
					pq.add(node);
				}
			}
		}
		System.out.println(result);
	}
}