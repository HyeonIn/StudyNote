package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;


public class Main {
	static class coord{
		int x, y, w;
		
		public coord(int x, int y, int w) {
			this.x = x;
			this.y = y;
			this.w = w;
		}
	}
	static int[][] check;
	static char[][] map;
	static int n;
	static int m;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0,1, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		
		n = Integer.parseInt(temp[0]);
		m = Integer.parseInt(temp[1]);
		
		check = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				check[i][j] = Integer.MAX_VALUE;
			}
		}
		map = new char[n][m];
		
		
		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		bfs();
		
		System.out.println(check[n-1][m-1]);
	}
	public static void bfs() {
		Queue<coord> q = new ArrayDeque<>();
		
		q.add(new coord(0,0,1));
		
		while (!q.isEmpty()) {
			coord temp = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = temp.x+dx[i];
				int ny = temp.y+dy[i];
				int nw = temp.w+1;
				if (nx >= 0 && ny >=0 && nx < m && ny < n) {
					if (map[ny][nx] == '1') {
						if (check[ny][nx] > nw) {
							check[ny][nx] = nw;
							q.add(new coord(nx,ny,nw));
						}
					}
				}
			}
		}
	}
}

