package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
	static int N, M, V;
	static boolean[][] graph;
	static boolean[] check;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		
		N = Integer.parseInt(temp[0]);
		M = Integer.parseInt(temp[1]);
		V = Integer.parseInt(temp[2]);
		
		graph = new boolean[N+1][N+1];
		
		for (int i = 0; i < M; i++) {
			temp = br.readLine().split(" ");
			graph[Integer.parseInt(temp[0])][Integer.parseInt(temp[1])] = true;
			graph[Integer.parseInt(temp[1])][Integer.parseInt(temp[0])] = true;
		}
		
		check = new boolean[N+1];
		check[V] = true;
		dfs(V);
		sb.append('\n');
		
		check = new boolean[N+1];
		check[V] = true;
		bfs(V);
		System.out.println(sb);
	}
	public static void dfs(int v) {
		sb.append(v).append(" ");
		for (int i = 0; i < N+1; i++) {
			if (graph[v][i]) {
				int now = i;
				if (!check[now]) {
					check[now] = true;
					dfs(now);
				}
			}
		}
	}
	public static void bfs(int v) {
		ArrayDeque<Integer> q = new ArrayDeque<>();
		sb.append(v).append(' ');
		q.add(v);
		while (!q.isEmpty()) {
			int now = q.poll();
			for (int i = 0; i < N+1; i++) {
				if (graph[now][i]) {
					int next = i;
					if (!check[next]) {
						sb.append(next).append(' ');
						check[next] = true;
						q.add(next);
					}
				}
			}
		}
	}
}