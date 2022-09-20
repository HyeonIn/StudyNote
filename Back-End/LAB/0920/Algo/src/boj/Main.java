package boj;

// 1504 특정한 최단경로
// 다익스트라를 구간 별로 더해서 최솟값을 찾는다
// 1 -> 4 번으로 갈때 2, 3을 거쳐야 한다면
// 1 2 3 4, 1 3 2 4 둘다 계산해보고 작은 쪽을 선택

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
	static class coord{
		int i, j, dir;
		//dir : 가로 : 0, 대각선 : 1, 세로 2
		public coord(int i, int j, int dir) {
			super();
			this.i = i;
			this.j = j;
			this.dir = dir;
		}
	}
	static int N;
	static int count = 0;
	static int[][] d = {{0, 1}, {0,2}, {1,2}};
	static int[] di = {0, 1, 1};
	static int[] dj = {1, 1, 0};
	
	static int[][] map; 
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		String[] temp;
		for (int i = 0; i < N; i++) {
			temp = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(temp[j]);
			}
		}
		bfs();
		System.out.println(count);
	}
	public static void bfs() {
		ArrayDeque<coord> q = new ArrayDeque<>();
		q.add(new coord(0,1,0));
		
		while (!q.isEmpty()) {
			coord cur = q.poll();
			for (int k = d[cur.dir][0]; k <= d[cur.dir][1]; k++) {
				int ni = di[k]+cur.i;
				int nj = dj[k]+cur.j;
				if (ni < N && nj < N) {
					if (ni == N-1 && nj == N-1) {
						count++;
					}
					if (map[ni][nj] == 0) {
						q.add(new coord(ni, nj, k));
					}
				}
			}
		}
		
	}
}
