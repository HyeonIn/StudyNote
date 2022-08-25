package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Main {
	static int V, E;
	static int[] distance; 
	static LinkedList<Node>[] adjList;
	static class Node implements Comparable<Node>{
		int num;
		int weight;
		
		public Node(int num, int weight) {
			this.num = num;
			this.weight = weight;
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
		String[] temp = br.readLine().split(" ");
		
		V = Integer.parseInt(temp[0]);
		E = Integer.parseInt(temp[1]);
		
		int start = Integer.parseInt(br.readLine());
		
		adjList = new LinkedList[V+1];
		
		for (int i = 1; i < V+1; i++) {
			adjList[i] = new LinkedList<>();
		}
		for (int i = 0; i < E; i++) {
			temp = br.readLine().split(" ");
			int from = Integer.parseInt(temp[0]);
			int to = Integer.parseInt(temp[1]);
			int weight = Integer.parseInt(temp[2]);
			
			adjList[from].add(new Node(to, weight));
		}
		
		
		distance = new int[V+1];
		for (int i = 1; i < V+1; i++) {
			distance[i] = Integer.MAX_VALUE;
		}
		
		
		dijkstra(start);
		
		for (int i = 1; i < V+1; i++) {
			System.out.println(distance[i] == Integer.MAX_VALUE ? "INF" : distance[i]);
		}
	}
	public static void dijkstra(int start) {
		distance[start] = 0;
		
		PriorityQueue<Node> pq  = new PriorityQueue<>();
		pq.add(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			Node temp = pq.poll();
			
			if (distance[temp.num] < temp.weight) {
				continue;
			}
			for (Node nextNode : adjList[temp.num]) {
				int next_weight = nextNode.weight + temp.weight;
				if (next_weight < distance[nextNode.num]) {
					distance[nextNode.num] = next_weight;
					pq.add(new Node(nextNode.num, next_weight));
				}
			}
		}
	}
}