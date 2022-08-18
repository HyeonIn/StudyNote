package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int R, C;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	static char[][] map;
	static boolean[][] check;
	static boolean[] alphacheck = new boolean[26];
	static int max;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		
		R = Integer.parseInt(temp[0]);
		C = Integer.parseInt(temp[1]);
		
		map = new char[R][C];
		check = new boolean[R][C];
		
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		check[0][0] = true;
		max = Integer.MIN_VALUE;
		alphacheck[map[0][0] - 'A'] = true;
		dfs(0,0,1);
		System.out.println(max);
	}
	public static void dfs(int x, int y, int count) {
		if (max < count) {
			max = count;
		}
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (nx >= 0 && nx < C && ny >= 0 && ny < R) {
				if (!check[ny][nx] && !alphacheck[map[ny][nx] - 'A']) {
					check[ny][nx] = true;
					alphacheck[map[ny][nx] - 'A'] = true;
					dfs(nx, ny, count+1);
					check[ny][nx] = false;
					alphacheck[map[ny][nx] - 'A'] = false;
				}
			}
		}
	}
}