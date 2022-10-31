package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] map;
	static ArrayList<coord> cloud;
	
	static int[] di = {0,-1,-1,-1,0,1,1,1};
	static int[] dj = {-1,-1,0,1,1,1,0,-1};
	
	static int[] di2 = {-1,-1,1,1};
	static int[] dj2 = {-1,1,1,-1};
	static class coord{
		int i, j;

		public coord(int i, int j) {
			this.i = i;
			this.j = j;
		}

		@Override
		public String toString() {
			return "coord [i=" + i + ", j=" + j + "]";
		}
		
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력 받기 위한 버퍼리더
		
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
		cloud = new ArrayList<>();
		cloud.add(new coord(N-1, 0));
		cloud.add(new coord(N-1, 1));
		cloud.add(new coord(N-2, 0));
		cloud.add(new coord(N-2, 1));
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken())-1;
			int s = Integer.parseInt(st.nextToken());
			boolean[][] check = new boolean[N][N];
			for (coord c : cloud) {
				coord nc = find(c, dir, s);
				check[nc.i][nc.j] = true;
				map[nc.i][nc.j] += 1;
				c.i = nc.i;
				c.j = nc.j;
			}
			for (coord c : cloud) {
				int count = 0;
				for (int j = 0; j < 4; j++) {
					int ni = c.i + di2[j];
					int nj = c.j + dj2[j];
					if (ni < 0 || nj < 0 || ni >= N || nj >= N || map[ni][nj] == 0) {
						continue;
					}
					count++;
				}
				map[c.i][c.j] += count;
			}
			cloud = new ArrayList<>();
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					if (check[j][k]) {
						continue;
					}
					if (map[j][k] >= 2) {
						cloud.add(new coord(j,k));
						map[j][k] -= 2;
					}
				}
			}
		}
		System.out.println(checkMap());
	}
	public static int checkMap() {
		int sum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sum += map[i][j];
			}
		}
		return sum;
	}
	public static coord find(coord now, int dir, int s) {
		int ni = (now.i + di[dir]*s)%N;
		if (ni < 0) {
			ni = ni + N;
		}
		int nj = (now.j + dj[dir]*s)%N;
		if (nj < 0) {
			nj = nj + N;
		}
		return new coord(ni, nj);
	}
}