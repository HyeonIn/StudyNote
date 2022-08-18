package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
	static int[][] map;
	static int n, m, count = 0, area, answer = Integer.MIN_VALUE;
	static boolean[][] check;
	static class coord{
		int i,j;
		public coord(int i, int j) {
			this.i = i;
			this.j = j;
		}
		
	}
	
	static int[] di = {0,1,0,-1};
	static int[] dj = {-1,0,1,0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		
		n = Integer.parseInt(temp[0]);
		m = Integer.parseInt(temp[1]);
		
		map = new int[n][m];
		check = new boolean[n][m];
		
		
		for (int i = 0; i < n; i++) {
			temp = br.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				map[i][j]= Integer.parseInt(temp[j]);
			}
		}
		 
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 1 && !check[i][j]) {
					area = 1;
					check[i][j] = true;
					count++;
					bfs(i, j);
					answer = Math.max(answer, area);
				}
			}
		}
		System.out.println(count);
		System.out.println(count==0 ? 0 : answer);
	}
	public static void bfs(int i, int j) {
		ArrayDeque<coord> q = new ArrayDeque<>();
		
		q.add(new coord(i, j));
		
		while (!q.isEmpty()) {
			coord temp = q.poll();
			for (int k = 0; k < 4; k++) {
				int nexti = temp.i + di[k];
				int nextj = temp.j + dj[k];
				
				if (nexti >= 0 && nexti < n && nextj >= 0 && nextj < m && map[nexti][nextj] == 1 && !check[nexti][nextj]) {
					area++;
					check[nexti][nextj] = true;
					q.add(new coord(nexti, nextj));
				}
			}
		}
	}
}