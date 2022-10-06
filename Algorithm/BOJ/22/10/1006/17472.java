package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M, K=1; //섬 개수 K
	static int[][] map; 
	static boolean[][] check; //라벨링을 위한 체크 배열
	static int[][] dist; // 섬에서 섬 가는 거리 기록하기
	
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	
	static class coord{
		int i, j;

		public coord(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
	static class node implements Comparable<node>{
		int n , w;
				
		public node(int n, int w) {
			this.n = n;
			this.w = w;
		}


		@Override
		public int compareTo(node o) {
			return this.w - o.w;
		}
		
		
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		check  = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		countIsland();
		dist = new int[K][K];
		for (int i = 1; i < K; i++) {
			for (int j = 1; j < K; j++) {
				dist[i][j] = Integer.MAX_VALUE;
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0) {
					for (int k = 0; k < 4; k++) {
						int ni = i + di[k];
						int nj = j + dj[k];
						if (ni < 0 || ni >= N || nj < 0 || nj >= M) {
							continue;
						}
						int count = 0;
						if (map[ni][nj] == 0) {
							while (ni >= 0 && ni < N && nj >= 0 && nj < M) {
								if (map[ni][nj] != 0) {
									if (count != 1) {
										dist[map[i][j]][map[ni][nj]] = Math.min(count, dist[map[i][j]][map[ni][nj]]);
										dist[map[ni][nj]][map[i][j]] = Math.min(count, dist[map[ni][nj]][map[i][j]]);										
									}
									break;
								}
								count++;
								ni += di[k];
								nj += dj[k];
							}
						}
					}
				}
			}
		}
	
		PriorityQueue<node> pq = new PriorityQueue<>();
		pq.add(new node(1, 0));
		boolean[] check = new boolean[K];
		int answer = 0;
		while (!pq.isEmpty()) {
			node temp = pq.poll();
			if (check[temp.n]) {
				continue;
			}
			check[temp.n] = true;
			answer += temp.w;
			for (int i = 1; i < K; i++) {
				if (!check[i] && dist[temp.n][i] != Integer.MAX_VALUE) {
					pq.add(new node(i, dist[temp.n][i]));
				}
			}
		}
		for (int i = 1; i < K; i++) {
			if (!check[i]) {
				answer = -1;
			}
		}
		System.out.println(answer);
			
	}

	public static void countIsland() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0 && !check[i][j]) {
					bfs(i, j);
				}
			}
		}
	}
	public static void bfs(int i, int j) {
		ArrayDeque<coord> q = new ArrayDeque<>();
		check[i][j] = true;
		map[i][j] = K;
		q.add(new coord(i, j));
		while (!q.isEmpty()) {
			coord temp = q.poll();
			for (int k = 0; k < 4; k++) {
				int ni = temp.i + di[k];
				int nj = temp.j + dj[k];
				if (ni < 0 || ni >= N || nj < 0 || nj >= M) {
					continue;
				}
				if (check[ni][nj] || map[ni][nj] == 0) {
					continue;
				}
				
				map[ni][nj] = K;
				check[ni][nj] = true;
				q.add(new coord(ni, nj));
				
			}
		}
		K++;
	}
}