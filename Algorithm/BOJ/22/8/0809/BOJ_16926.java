package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	static int n, m, r;
	static int[][] map;
	static int[][] result;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static Queue<Integer> q = new ArrayDeque<>();
	static class coord{
		int x;
		int y;
		coord(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		
		n = Integer.parseInt(temp[0]);
		m = Integer.parseInt(temp[1]);
		r = Integer.parseInt(temp[2]);
		map = new int[n][m];
		result = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			temp = br.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(temp[j]);
			}
		}
		for (int i = 0; i < Math.min(n,m) / 2; i++) {
			coord[] point = {new coord(i,i), new coord(m-1-i, i), new coord(m-i-1, n-i-1), new coord(i, n-i-1)};
			int[] mn = {m-1-i*2, n-1-i*2};
			Rotate(point, mn, true);
			turn(r);
			Rotate(point, mn, false);
		}
		for (int j = 0; j < n; j++) {
			for (int k = 0; k < m; k++) {
				System.out.print(result[j][k] + " ");
			}
			System.out.println();
		}
	}
	public static void Rotate(coord[] point, int[] mn, boolean input) { 
		for (int i = 0; i < 4; i++) {
			int nowX = point[i].x;
			int nowY = point[i].y;
			for (int j = 0; j < mn[i%2]; j++) {
				int nextX = nowX + dx[i] * j;
				int nextY = nowY + dy[i] * j;
				if (input) {
					q.add(map[nextY][nextX]);
				}
				else {
					result[nextY][nextX] = q.poll();
				}
			}
		}
	}
	public static void turn(int r) {
		for (int i = 0; i < r%q.size(); i++) {
			q.add(q.poll());
		}
	}
}
