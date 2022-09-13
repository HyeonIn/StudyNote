package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main{
	static class coord implements Comparable<coord>{
		int i, j, w;
		public coord(int i, int j, int w) {
			this.i = i;
			this.j = j;
			this.w = w;
		}
		@Override
		public int compareTo(coord o) {
			// TODO Auto-generated method stub
			if (this.w > o.w) {
				return 1;
			}
			else if (this.w < o.w) {
				return -1;
			}
			else {
				return 0;
			}
		}
		
	}
	static int N;
	static int[][] map;
	static int[][] check;
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		check = new int[N][N];
		String[] temp;
		for (int i = 0; i < N; i++) {
			temp = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(temp[j]);
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				check[i][j]= Integer.MAX_VALUE;
			}
		}
		bfs();
		System.out.println(check[N-1][N-1]);
		
	}
	public static void bfs() {
		PriorityQueue<coord> q = new PriorityQueue<>();
		check[0][0] = 0;
		q.offer(new coord(0, 0, 0));
		while (!q.isEmpty()) {
			coord temp = q.poll();
			if (check[temp.i][temp.j] < temp.w) {
				continue;
			}
			for (int k = 0; k < 4; k++) {
				int ni = di[k] + temp.i;
				int nj = dj[k] + temp.j;
				if (ni >= 0 && ni < N && nj >= 0 && nj < N) {
					int cost = Math.max(Math.abs(map[ni][nj] - map[temp.i][temp.j]), temp.w);
					if (cost < check[ni][nj]) {
						check[ni][nj] = cost;
						q.offer(new coord(ni, nj, cost));
					}
				}
			}
		}
	}
}