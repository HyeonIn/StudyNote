package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	static int N, M, answer;
	static ArrayList<Integer>[] adjList;
	static boolean[] check;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		N = Integer.parseInt(temp[0]);
		M = Integer.parseInt(temp[1]);
		
		adjList = new ArrayList[N];
		
		
		for (int i = 0; i < N; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			temp = br.readLine().split(" ");
			int from = Integer.parseInt(temp[0]);
			int to = Integer.parseInt(temp[1]);
			
			adjList[from].add(to);
			adjList[to].add(from);
		}
		answer = 0;
		check = new boolean[N];
		for (int i = 0; i < N; i++) {
			
			dfs(i, 0);
			if (answer != 0) {
				break;
			}
		}
		
		
		System.out.println(answer);
	}
	public static void dfs(int start, int cnt) {
		if (cnt >= 5) {
			answer = 1;
			return;
		}
		for (int a : adjList[start]) {
			if (!check[a]) {
				check[a] = true;
				dfs(a,cnt+1);
				if (answer == 0) {
					check[a] = false;
				}
			}
		}
	}
}