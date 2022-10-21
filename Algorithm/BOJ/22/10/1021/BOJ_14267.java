package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static ArrayList<Integer>[] graph; 
	static int[] answer;
	static class node{
		int n, w;

		public node(int n, int w) {
			this.n = n;
			this.w = w;
		}
		
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new ArrayList[N];
		answer = new int[N];
		for (int i = 0; i < N; i++) {
			graph[i] = new ArrayList<>();
		}
		int idx = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int parent = Integer.parseInt(st.nextToken());
			if (parent == -1) {
				idx = i;
				continue;
			}
			graph[parent-1].add(i);
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int now = Integer.parseInt(st.nextToken()) - 1;
			int weight = Integer.parseInt(st.nextToken());
			answer[now] += weight;
			
		}
		bfs(idx);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(answer[i]).append(" ");
		}
		System.out.println(sb);
	}
	public static void bfs(int n) {
		ArrayDeque<node> q = new ArrayDeque<>();
		q.add(new node(n, 0));
		while (!q.isEmpty()) {
			node temp = q.poll();
			for (int next : graph[temp.n]) {
				int nw = temp.w + answer[next];
				answer[next] = nw;
				q.add(new node(next, nw));
			}
		}
	}
}
