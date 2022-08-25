package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
	static int N;
	static int map[][];
	static int check[][];
	static int[] di = {-1, 1, 0 ,0};
	static int[] dj = {0,0,1,-1};
	
	static class coord{
		int i, j;
		public coord(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = 1;
		String[] temp;
		while(true) {
			N = Integer.parseInt(br.readLine());
			if (N == 0) {
				break;
			}
			map = new int[N][N];
			check = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				temp = br.readLine().split(" ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(temp[j]);
					check[i][j] = Integer.MAX_VALUE;
				}
			}
			bfs();
			
			System.out.printf("Problem %d: %d\n", n++, check[N-1][N-1]);
		}
	}
	public static void bfs() {
		ArrayDeque<coord> q = new ArrayDeque<>();
		q.add(new coord(0,0));
		check[0][0] = map[0][0];
		while (!q.isEmpty()) {
			coord temp = q.poll();
			int tempW = check[temp.i][temp.j];
			for (int k = 0; k < 4; k++) {
				int ni = temp.i + di[k];
				int nj = temp.j + dj[k];
				if (ni >= 0 && ni < N && nj >= 0 && nj < N) {
					int nextW = tempW + map[ni][nj];
					if (check[ni][nj] > nextW) {
						check[ni][nj] = nextW;
						q.add(new coord(ni, nj));
					}
				}
			}
		}
	}
}