package boj;

// 1504 특정한 최단경로
// 다익스트라를 구간 별로 더해서 최솟값을 찾는다
// 1 -> 4 번으로 갈때 2, 3을 거쳐야 한다면
// 1 2 3 4, 1 3 2 4 둘다 계산해보고 작은 쪽을 선택

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main {
	static class node{
		int n, w;
		public node(int n, int w) {
			this.n = n;
			this.w = w;
		}
	}
	static int N, E;
	static ArrayList<ArrayList<node>> graph; 
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		N = Integer.parseInt(temp[0]);
		E = Integer.parseInt(temp[1]);
		int[] arr = new int[N+1];
		graph = new ArrayList<ArrayList<node>>();
		for (int i = 0; i < N+1; i++) {
			graph.add(new ArrayList<node>());
		}
		
		for (int i = 0; i < E; i++) {
			temp = br.readLine().split(" ");
			int n, m, w;
			n = Integer.parseInt(temp[0]);
			m = Integer.parseInt(temp[1]);
			w = Integer.parseInt(temp[2]);
			graph.get(n).add(new node(m, w));
			graph.get(m).add(new node(n, w));
		}
		temp = br.readLine().split(" ");
		int first = Integer.parseInt(temp[0]);
		int second = Integer.parseInt(temp[1]);
		
		int a = dijkstra(1, first);
		int b = dijkstra(first, second);
		int c = dijkstra(second, N);
		
		
		
		int d = dijkstra(1, second);
		int e = dijkstra(second, first);
		int f = dijkstra(first, N);
		
		int answer1;
		int answer2;
		
		if (a == -1 || b == -1 || c == -1) {
			answer1 = -1;
		}
		else {
			answer1 = a+b+c;
		}
		if (d == -1 || e == -1 || f == -1) {
			answer2 = -1;
		}
		else {
			answer2 = d+e+f;
		}
		if (answer1 == -1 && answer2 == -1) {
			System.out.println(-1);
		}
		else if(answer1 == -1 && answer2 != -1) {
			System.out.println(answer2);
		}
		else if(answer1 != -1 && answer2 == -1) {
			System.out.println(answer1);
		}
		else {
			System.out.println(Math.min(answer1, answer2));
		}
	}
	static int dijkstra(int start, int end) {
		int[] dist = distInit();
		
		PriorityQueue<node> q = new PriorityQueue<node>((o1, o2) -> Integer.compare(o1.w,  o2.w));
		
		q.offer(new node(start, 0));
		
		dist[start] = 0;
		while (!q.isEmpty()) {
			node cur = q.poll();
			if (dist[cur.n] < cur.w) {
				continue;
			}
			for (int i = 0; i < graph.get(cur.n).size(); i++) {
				node next = graph.get(cur.n).get(i);
				
				if (dist[next.n] > cur.w + next.w) {
					dist[next.n] = cur.w+next.w;
					q.offer(new node(next.n, dist[next.n]));
				}
			}
		}
		
		return dist[end] == Integer.MAX_VALUE ? -1 : dist[end];
	}
	static int[] distInit() {
		int[] dist = new int[N+1];
		for (int i = 0; i < N+1; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		return dist;
	}

}
