// 1743 음식물 피하기
// BFS 정석 문제

package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	static int N,M, answer;
	static int[][] map;
	static boolean[][] check;
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	
	static class coord{
		int i, j;

		public coord(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		check = new boolean[N][M];
		answer = Integer.MIN_VALUE;
		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken()) -1;
			int j = Integer.parseInt(st.nextToken()) -1;
			map[i][j] = 1;
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) {
					if (!check[i][j]) {
						check[i][j] = true;
						bfs(i, j);
					}
				}
			}
		}
		System.out.println(answer);
	}
	public static void bfs(int i, int j) {
		ArrayDeque<coord> q = new ArrayDeque<>();
		q.add(new coord(i, j));
		int count = 1;
		while (!q.isEmpty()) {
			coord temp = q.poll();
			for (int k = 0; k < 4; k++) {
				int ni = temp.i +di[k];
				int nj = temp.j +dj[k];
				if (ni < 0 || nj < 0 || ni >= N || nj >= M || check[ni][nj] || map[ni][nj] == 0) {
					continue;
				}
				check[ni][nj] = true;
				count++;
				q.add(new coord(ni, nj));
			}
		}
		answer = Integer.max(count, answer);
	}
}
