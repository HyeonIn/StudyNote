package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
	static int[][] map;
	static int n, m, k;
	static int r, c, s;
	
	static int[] dx = {0,1,0,-1};
	static int[] dy = {-1,0,1,0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		
		n = Integer.parseInt(temp[0]);
		m = Integer.parseInt(temp[1]);
		k = Integer.parseInt(temp[2]);
		
		map = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			temp = br.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(temp[j]);
			}
		}
		
		for (int i = 0; i < k; i++) {
			temp = br.readLine().split(" ");
			r = Integer.parseInt(temp[0]);
			c = Integer.parseInt(temp[1]);
			s = Integer.parseInt(temp[2]);
			int startX = c-s;
			int startY = r-s;
			int endX = c+s;
			int endY = r+s;
			
			for (int j = 0; j < s; j++) {
				int idx = 0;
				int x = startX-1+j;
				int y = startY-1+j;
				System.out.println(x + " "+y);
				int val = map[y][x];
				
				while (idx < 4) {
					int nx = x + dx[idx];
					int ny = y + dy[idx];
					
					if (nx >= startX-1-j && ny >= startY-1+j && nx < endX-j && ny < endY-j) {
						map[y][x] = map[ny][nx];
						x = nx;
						y = ny;
					}
					else {
						idx++;
					}
				}
				map[startX-1+j][startY+j] = val;
			}
			
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
}