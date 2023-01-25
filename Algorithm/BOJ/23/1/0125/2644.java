package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main {
	static int N;
	static int start, end;
	static ArrayList<Integer>[] graph;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		N = Integer.parseInt(br.readLine());
		graph = new ArrayList[N+1];
		
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		int m = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			graph[x].add(y);
			graph[y].add(x);
		}
		System.out.println(bfs());
	}
	public static int bfs() {
		ArrayDeque<Integer> q = new ArrayDeque<>();
		q.add(start);
		boolean[] check = new boolean[N+1];
		check[start] = true;
		int count = 1;
		while (!q.isEmpty()) {
			int repeat = q.size();
			for (int r = 0; r < repeat; r++) {
				int now = q.poll();
				for (int next : graph[now]) {
					if (check[next]) {
						continue;
					}
					if (next == end) {
						return count;
					}
					q.add(next);
					check[next] = true;
				}
			}
			count++;
		}
		return -1;
	}
}
