package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int R, C, N;
	static int[][] map;
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,1,-1};
	
	static class bomb {
		int i, j, count;
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String temp[] = br.readLine().split(" ");
		R = Integer.parseInt(temp[0]);
		C = Integer.parseInt(temp[1]);
		N = Integer.parseInt(temp[2]);
		
		map = new int[R][C];
		
		for (int i = 0; i < R; i++) {
			String row = br.readLine();
			for (int j = 0; j < C; j++) {
				char now = row.charAt(j);
				if (now == '.') {
					map[i][j] = -1;
				}
				else {
					map[i][j] = 2; 
				}
			}
		}
		
		for (int i = 2; i <= N; i++) {
			countdown();
			if (i%2 == 0) {
				fillBomb();
			}
			else {
				boom();
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == -1) {
					sb.append('.');
				}
				else {
					sb.append('O');
				}
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
	public static void countdown() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] > 0) {
					map[i][j]--;
				}
			}
		}
	}
	public static void fillBomb() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {				
				if (map[i][j] == -1) {
					map[i][j] = 3;
				}
			}
		}
	}
	public static void boom() {
		int[][] copy = copy(map);
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 0) {
					copy[i][j] = -1;
					for (int k = 0; k < 4; k++) {
						int ni = i + di[k];
						int nj = j + dj[k];
						if (ni >= 0 && ni < R && nj >= 0 && nj < C) {
							copy[ni][nj] = -1;
						}
					}
				}
			}
		}
		map = copy;
	}
	public static int[][] copy(int[][] origin){
		int[][] copy = new int[R][C];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				copy[i][j] = origin[i][j];
			}
		}
		return copy;
	}
}