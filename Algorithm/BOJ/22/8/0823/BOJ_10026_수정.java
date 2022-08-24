package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
	static int N;
	static boolean[][] check;
	static int[] di = {-1, 1, 0, 0};
	static int[] dj = {0, 0, -1, 1};
	static int count1;
	static int count2;
	
	static class coord{
		int i, j;
		public coord(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}

	public static void main(String[] argv) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		char[][] map = new char[N][N];
		check = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!check[i][j]) {
					count1++;
					check[i][j] = true;
					bfs(i, j, map[i][j], map);
				}
			}
		}

		//적록 색약 맵 생성
		char[][] copyMap = new char[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 'R' || map[i][j] == 'G') {
					copyMap[i][j] = 'R';
				}
				else {
					copyMap[i][j] = 'B';
				}
			}
		}
		
		check = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!check[i][j]) {
					count2++;
					check[i][j] = true;
					bfs(i, j, copyMap[i][j], copyMap);
				}
			}
		}
		System.out.println(count1 + " " + count2);
	}
	public static void bfs(int i, int j, char color, char[][] map) {
		ArrayDeque<coord> q = new ArrayDeque<>();
		q.add(new coord(i,j));
		while (!q.isEmpty()) {
			coord temp = q.poll();
			for (int k = 0; k < 4; k++) {
				int ni = temp.i+di[k];
				int nj = temp.j+dj[k];
				if (ni >= 0 && ni < N && nj >= 0 && nj < N && map[ni][nj] == color && !check[ni][nj]) {
					check[ni][nj]= true;
					q.add(new coord(ni, nj));
				}
			}
		}
	}
}