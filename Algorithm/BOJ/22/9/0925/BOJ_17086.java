// 17086 아기 상어 2
// 가장 가까운 상어의 거리를 저장할 check 배열을 만들고
// 맵을 돌면서 상어가 있는 칸이면 BFS로 가장 가까운 상어를 check 배열에 기록한다
// 가중치를 이용해서 가중치보다 check배열의 값이 크다면 현재의 가중치 + 1 을 check 배열에 기록한다
// 가중치보다 작다면 탐색할 필요가 없는 지점이므로 넘긴다(시간초과 방지)

package boj;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main{
	static int N, M;
	static int[][] map;
	static int[][] check;
	static int[] di = {-1,-1,-1,0, 0, 1,1,1};
	static int[] dj = {-1, 0, 1,1,-1,-1,0,1};
	static class coord{
		int i,j,w;

		public coord(int i, int j, int w) {
			this.i = i;
			this.j = j;
			this.w = w;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String temp[] = br.readLine().split(" ");
		
		N = Integer.parseInt(temp[0]);
		M = Integer.parseInt(temp[1]);
		map = new int[N][M];
		check = new int[N][M];
		for (int i = 0; i < N; i++) {
			temp = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				check[i][j] = Integer.MAX_VALUE;
				map[i][j] = Integer.parseInt(temp[j]);
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) {
					check[i][j] = 0;
					bfs(i,j);
				}
			}
		}
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				max = Integer.max(check[i][j], max);
			}
		}
		System.out.println(max);
	}
	public static void bfs(int i, int j) {
		ArrayDeque<coord> q = new ArrayDeque<>();
		q.add(new coord(i, j, 0));
		while (!q.isEmpty()) {
			coord temp = q.poll();
			for (int k = 0; k < 8; k++) {
				int ni = temp.i + di[k];
				int nj = temp.j + dj[k];
				
				if (ni >= 0 && nj >=0 && ni < N && nj <M) {
					if (map[ni][nj] == 0 && check[ni][nj] > temp.w+1) {
						check[ni][nj] = temp.w+1;
						q.add(new coord(ni, nj, temp.w+1));
					}
				}
			}
		}
		
	}
}