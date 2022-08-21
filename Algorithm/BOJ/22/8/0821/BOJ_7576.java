package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
	static int N, M;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	static int[][] map;
	static int[][] check;
	static int max;
	static ArrayDeque<tomato> q = new ArrayDeque<>();
	
	static class tomato{
		int i, j, w;
		
		public tomato(int i, int j, int w) {
			this.i = i;
			this.j = j;
			this.w = w;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		
		M = Integer.parseInt(temp[0]);
		N = Integer.parseInt(temp[1]);
		
		map = new int[N][M];
		check = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			temp = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(temp[j]);
				if (map[i][j] == 0) {
					check[i][j] = Integer.MAX_VALUE;			
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) {
					check[i][j] = 0;
					q.add(new tomato(i,j,0));	
				}
			}
		}
		bfs();
		if(checkZero()) {
			System.out.println(-1);
		}
		else {
			findMax();
			System.out.println(max);
		}
		
	}
	public static void bfs() {
		while (!q.isEmpty()) {
			tomato t = q.poll();
			for (int k = 0; k < 4; k++) {
				int ni = t.i + dy[k];
				int nj = t.j + dx[k];
				if (ni >= 0 && nj >= 0 && ni < N && nj < M && map[ni][nj] == 0) {
					if (check[ni][nj] > t.w+1) {
						check[ni][nj] = t.w+1;
						q.add(new tomato(ni,nj,t.w+1));
					}
				}
			}
		}
	}
	public static boolean checkZero() {
		boolean iszero = false;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (check[i][j] == Integer.MAX_VALUE) {
					iszero = true;
				}
			}
		}
		return iszero;
	}
	public static void findMax() {
		max = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				max = Math.max(check[i][j], max);
			}
		}
	}
}