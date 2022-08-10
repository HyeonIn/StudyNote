package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
	static class coord{
		int x, y, a, w;
		coord(int x, int y, int w){
			this.x = x;
			this.y = y;
			this.w = w;
		}
	}
	static ArrayDeque<coord> q;
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
			max = Integer.MIN_VALUE;
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
						bfs(j, i, map[i][j]);
					}
				}
			}
			System.out.printf("#%d %d %d\n", t, r, max);
		}
		
	}
	public static void bfs(int x, int y, int a) {
		q = new ArrayDeque<>();
		q.add(new coord(x,y,1));
		int count = 1;
		while (!q.isEmpty()) {
			coord temp = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int nx = temp.x + dx[i];
				int ny = temp.y + dy[i];
				
				if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
					if (check[ny][nx] <= temp.w && map[ny][nx]-map[temp.y][temp.x] == 1) {
						count++;
						q.add(new coord(nx,ny,temp.w+1));
						check[ny][nx] = temp.w+1;
					}
				}
			}
		}
		if (count == max) {
			if (a < r) {
				r = a;
			}
		}
		else if (count > max) {
			max = count;
			r = a;
		}
	}
}