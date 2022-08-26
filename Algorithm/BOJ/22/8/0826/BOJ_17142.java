package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class Main {
	static int N, M, C = 0;
	static int[][] map;
	static int[][] check;
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	
	static ArrayList<coord> virus;
	static boolean[] select;
	static int answer = -1;
	static int min = Integer.MAX_VALUE;
	static ArrayDeque<coord> q = new ArrayDeque<>();
	
	static class coord{
		int i, j;
		
		public coord(int i, int j) {
			this.i = i;
			this.j = j;
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return i + "," + j;
		}
	}
	
	public static void main(String[] argv) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		
		N = Integer.parseInt(temp[0]);
		M = Integer.parseInt(temp[1]);
		map = new int[N][N];
		virus = new ArrayList<>();
		
		int idx = 0;
		for (int i = 0; i < N; i++) {
			temp = br.readLine().split(" ");			
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(temp[j]);
				if (map[i][j] == 2) {
					C++;
					virus.add(new coord(i,j));
				}
			}
		}
		select = new boolean[C];
		comb(0,0);
		System.out.println(answer);
	}
	public static void comb(int idx, int cnt) {
		if (cnt == M) {
			check = new int[N][N];
			for (int i = 0; i < C; i++) {
				if (select[i]) {
					check[virus.get(i).i][virus.get(i).j] = -1;
					q.add(virus.get(i));
				}
			}
			
			bfs();
			int temp = checkZero();
			if (temp != -1) {
				if (answer == -1) {
					answer = temp;
				}
				else {
					answer = Math.min(answer, temp);
				}
			}
		}
		if (idx == C) {
			return;
		}
		select[idx] = true;
		comb(idx+1, cnt+1);
		select[idx] = false;
		comb(idx+1, cnt);
	}
	public static void bfs() {
		int time = 0;
		while (!q.isEmpty()) {
			int repeat = q.size();
			time++;
			for (int r = 0; r < repeat; r++) {
				coord temp = q.poll();
				for (int k = 0; k < 4; k++) {
					int ni = temp.i + di[k];
					int nj = temp.j + dj[k];
					if (ni >= 0 && ni < N && nj >=0 && nj < N && map[ni][nj] != 1) {
						if (check[ni][nj] == 0) {
							check[ni][nj] = time;
							q.add(new coord(ni, nj));                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         
						}
					}
				}
			}
		}
	}
	public static int checkZero() {
		int max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 0) {
					if (check[i][j] == 0) {
						return -1;
					}
					else {
						max = Math.max(check[i][j], max);
					}
				}
			}
		}
		return max;
	}
}