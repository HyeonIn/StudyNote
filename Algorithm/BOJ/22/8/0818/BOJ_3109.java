package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[] dy = {-1,0,1};
	static int R, C;
	static int count;
	static char[][] map;
	static boolean[][] check;
	static boolean isDone;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		
		R = Integer.parseInt(temp[0]);
		C = Integer.parseInt(temp[1]);
		
		map = new char[R][C];
		check = new boolean[R][C];
		count = 0;
		
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		for (int i = 0; i < R; i++) {
			isDone = false;
			dfs(i, 0);
		}
		System.out.println(count);
	}
	public static void dfs(int r, int c) {
		if (c == C-1) {
			count++;
			isDone = true;
			return;
		}
		for (int i = 0; i < 3; i++) {
			int nx = c+1;
			int ny = r+dy[i];
			if (nx < C && ny >= 0 && ny < R) {
				if (!check[ny][nx] && map[ny][nx] == '.') {
					check[ny][nx] = true;
					dfs(ny, nx);
					if (isDone) {
						break;
					}	
				}
		
			}
			
		}
	}
}