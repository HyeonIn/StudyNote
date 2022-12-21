package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
	static int T, N, M, K;
	static int[][] map;
	static boolean[][] check;
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static class coord{
		int i, j;
		public coord(int i, int j) {
			this.i = i;
			this.j = j;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			map = new int[N][M];
			check = new boolean[N][M];
			
			for (int k = 0; k < K; k++) {
				st = new StringTokenizer(br.readLine());
				int j = Integer.parseInt(st.nextToken());
				int i = Integer.parseInt(st.nextToken());
				map[i][j] = 1;
			}
			int count = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 1 && !check[i][j]) {
						check[i][j] = true;
						count++;
						bfs(i, j);
					}
				}
			}
			System.out.println(count);
		}
	}
	public static void bfs(int i, int j) {
		ArrayDeque<coord> q = new ArrayDeque<>();
		q.add(new coord(i, j));
		while (!q.isEmpty()) {
			coord now = q.poll();
			for (int k = 0; k < 4; k++) {
				int ni = now.i + di[k];
				int nj = now.j + dj[k];
				if (ni < 0 || ni >= N || nj < 0 || nj >= M || check[ni][nj] || map[ni][nj] == 0) {
					continue;
				}
				check[ni][nj] = true;
				q.add(new coord(ni, nj));
			}
		}
	}
}