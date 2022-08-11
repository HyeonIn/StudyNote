package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static class coord{
		int x, y, a, w;
		coord(int x, int y, int w){
			this.x = x;
			this.y = y;
			this.w = w;
		}
	}
	static int[][] check;
	static int[][] map;
	static int n;
	static int r;
	static int max;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			check = new int[n][n];
			max = 1;
			r = Integer.MAX_VALUE;
			String[] temp;
			for (int i = 0; i < n; i++) {
				temp = br.readLine().split(" ");
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(temp[j]);
				}
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (check[i][j] < 1) {
						check[i][j] = 1;
						dfs(j, i, map[i][j], 1);
					}
				}
			}
			System.out.printf("#%d %d %d\n", t, r, max);
		}
		
	}
	public static void dfs(int x, int y, int a, int c) {
		if (max == c) {
			r = Math.min(r,a);
		}
		else if (max < c) {
			max = c;
			r = a;
		}
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
				if (check[ny][nx] <= check[y][x] && map[ny][nx]-map[y][x] == 1) {
					check[ny][nx] = check[y][x] + 1;
					dfs(nx, ny, a, c+1);
				}
			}
			
		}
	}
}