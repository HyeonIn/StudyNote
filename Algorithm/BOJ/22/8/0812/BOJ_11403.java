package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class Main {
	static ArrayList<ArrayList<Integer>> graph;
	static int n;
	static int[][] answer;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		graph = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<>());
		}
		answer = new int[n][n];
		String[] temp;
		for (int i = 0; i < n; i++) {
			temp = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				if (temp[j].equals("1") ) {					
					graph.get(i).add(j);
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				bfs(i,j);
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(answer[i][j] +" ");
			}
			System.out.println();
		}
		
	}
	public static void bfs(int i, int j) {
		ArrayDeque<Integer> q = new ArrayDeque<>();
		q.add(i);
		boolean []check = new boolean[n];
		check[i] = true;
		while (!q.isEmpty()) {
			int temp = q.poll();	
			for (int k = 0; k < graph.get(temp).size(); k++) {
				int child = graph.get(temp).get(k);
				if (child == j) {
					answer[i][j] = 1;
				}
				if (!check[child]) {
					check[child] = true;
					q.add(child);
				} 
			}
		}
	}
}