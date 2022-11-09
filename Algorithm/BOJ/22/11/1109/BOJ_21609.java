package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M, max, max_rain, score;
	static int map[][];
	static coord maxIdx;
	static boolean check[][][];
	static int[] di = {0,1,0,-1};
	static int[] dj = {1,0,-1,0};
	static int[] di2 = {-1, 0,1,0};
	static int[] dj2 = {0, 1,0,-1};
	static class coord{
		int i, j;

		public coord(int i, int j) {
			this.i = i;
			this.j = j;
		}
		
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		score = 0;
		while (true) {
			if(!find()) break;
			delete();
			gravity();
			rotate();
			gravity();
		}
		System.out.println(score);
	}
	public static void p() {
		for (int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
	}
	public static boolean find() {
		
		check = new boolean[N][N][M+1];
		max = Integer.MIN_VALUE;
		max_rain = Integer.MIN_VALUE;
		maxIdx = new coord(-1,-1);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == M+1 || map[i][j] == -1 || map[i][j] == 0 || check[i][j][map[i][j]]) {
					continue;
				}
				
				check[i][j][map[i][j]] = true;
				bfs(i, j, map[i][j]);
			}
		}
		if (max < 2) {
			return false;
		}
		else {
			return true;
		}
	}
	public static void bfs(int i, int j, int b) {
		ArrayDeque<coord> q = new ArrayDeque<>();
		q.add(new coord(i,j));
		int count=1, rainCount= 0;
		while (!q.isEmpty()) {
			coord temp = q.poll();
			for (int k = 0; k < 4; k++) {
				int ni = temp.i + di[k];
				int nj = temp.j + dj[k];
				if (ni < 0 || nj < 0 || ni >= N || nj >= N || check[ni][nj][b] || map[ni][nj] == -1) {
					continue;
				}
				if (map[ni][nj] == b || map[ni][nj] == 0 ) {
					check[ni][nj][b] = true;
					q.add(new coord(ni, nj));
					count++;
					if (map[ni][nj] == 0) {
						rainCount++;
					}
				}
			}
		}
		if (max < count) {
			max = count;
			max_rain = rainCount;
			maxIdx = new coord(i, j);
		}
		else if (max == count) {
			if (max_rain < rainCount) {
				max_rain = rainCount;
				maxIdx = new coord(i, j);
			}
			else if (max_rain == rainCount) {
				maxIdx = new coord(i, j);
			}
		}
	}
	public static void delete() {
		ArrayDeque<coord> q = new ArrayDeque<>();
		q.add(maxIdx);
		int b = map[maxIdx.i][maxIdx.j];
		map[maxIdx.i][maxIdx.j] = M+1;
		while (!q.isEmpty()) {
			coord temp = q.poll();
			for (int k = 0; k < 4; k++) {
				int ni = temp.i + di[k];
				int nj = temp.j + dj[k];
				if (ni < 0 || nj < 0 || ni >= N || nj >= N) {
					continue;
				}
				if (map[ni][nj] == b || map[ni][nj] == 0 ) {
					q.add(new coord(ni, nj));
					map[ni][nj] = M+1;
				}
			}
		}
		score += Math.pow(max, 2);
	}
	public static void gravity() {
		for (int i = N-2; i >= 0; i--) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] >= 0 && map[i][j] <= M) {
					int ni = i + 1;
					while (ni < N) {
						if (map[ni][j] >= -1 && map[ni][j] <= M) {
							break;
						}
						ni += 1;
					}
					if (ni-1 != i) {
						map[ni-1][j] = map[i][j];
						map[i][j] = M+1;
					}
				}
			}
		}
	}
	public static void rotate() {
		int[][] map2 = new int[N][N];
		ArrayDeque<Integer> q = new ArrayDeque<>();
		for (int r = 0; r < N/2; r++) {
			int i = r;
			int j = r;
			int k = 0;
			q.add(map[i][j]);
			while(true) {
				if (k == 4) {
					break;
				}
				int ni = i + di[k];
				int nj = j + dj[k];
				if (ni < r || nj< r || ni>= N-r || nj >= N-r) {
					k++;
					continue;
				}
				q.add(map[ni][nj]);
				i = ni;
				j = nj;
			}
			
			i = N-r-1;
			j = r;
			k = 0;
			map2[i][j] = q.poll();
			while(true) {
				if (k == 4) {
					break;
				}
				int ni = i + di2[k];
				int nj = j + dj2[k];
				if (ni < r || nj< r || ni>= N-r || nj >= N-r) {
					k++;
					continue;
				}
				map2[ni][nj] = q.poll();
				i = ni;
				j = nj;
			}
		}
		if (N % 2 == 1) {
			map2[N/2][N/2] = map[N/2][N/2]; 
		}
		map = map2;
	}
}