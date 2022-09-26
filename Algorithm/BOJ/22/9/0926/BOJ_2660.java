// 2660 회장뽑기
// 그래프에서 특정 정점에서 총 최소 몇 번의 간선을 통과해야 전부 탐색되는지를 구하면서 풀었다
// BFS로 간선 한번 넘어갈 때마다 카운팅해주는 방식으로 구현했음
package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class Main{
	static int N;
	static ArrayList<Integer>[] graph;
	static int[] answer;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		graph = new ArrayList[N+1];
		answer = new int[N+1];
		for (int i = 0; i < N+1; i++) {
			graph[i] = new ArrayList<>();
			answer[i] = Integer.MAX_VALUE;
		}
		while(true) {
			String temp[] = br.readLine().split(" ");
			int a = Integer.parseInt(temp[0]);
			int b = Integer.parseInt(temp[1]);
			if (a == -1) {
				break;
			}
			graph[a].add(b);
			graph[b].add(a);
		}
		
		for (int i = 1; i < N+1; i++) {
			bfs(i);
		}
		ArrayList<Integer> result = new ArrayList<>();
		for (int i = 1; i < N+1; i++) {
			if (answer[i] == min) {
				result.add(i);
			}
		}
		
		System.out.println(min + " " + result.size());
		for (int i = 0; i < result.size(); i++) {
			System.out.print(result.get(i)+" ");
		}
		
	}
	public static void bfs(int n) {
		ArrayDeque<Integer> q = new ArrayDeque<>();
		q.add(n);
		boolean[] check = new boolean[N+1];
		check[n] = true;
		int rank = -1;
		while (!q.isEmpty()) {
			rank++;
			int repeat = q.size();
			for (int r = 0; r < repeat; r++) {
				int temp = q.poll();
				for (int i = 0; i < graph[temp].size(); i++) {
					int next = graph[temp].get(i);
					if (!check[next]) {
						check[next] = true;
						q.add(next);
					}
				}
			}		
		}
		answer[n] = rank;
		min = Math.min(rank, min);
	}
}