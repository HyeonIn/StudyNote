package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	static int M, N, H;
	static int[][][] map;
	static ArrayDeque<coord> q;
	static int[] di = {0,0,1,-1,0,0};
	static int[] dj = {1,-1,0,0,0,0};
	static int[] dh = {0,0,0,0,1,-1};
	
	static class coord{
		int i, j, h;

		public coord(int i, int j, int h) {
			this.i = i;
			this.j = j;
			this.h = h;
		}
	}
	
	public static void main(String[] args) throws IOException {    
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	M = Integer.parseInt(st.nextToken());
    	N = Integer.parseInt(st.nextToken());
    	H = Integer.parseInt(st.nextToken());
    	
    	map = new int[H][N][M];
    	q = new ArrayDeque<>();
    	
    	for (int h = 0; h < H; h++) {
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[h][i][j] = Integer.parseInt(st.nextToken());
					if (map[h][i][j] == 1) {
						q.add(new coord(i,j,h));
					}
				}
			}
		}
    	int answer = 0;
    	while (!q.isEmpty()) {
			int repeat = q.size();
			for (int i = 0; i < repeat; i++) {
				coord temp = q.poll();
				for (int j = 0; j < 6; j++) {
					int ni = temp.i + di[j];
					int nj = temp.j + dj[j];
					int nh = temp.h + dh[j];
					if (ni < 0 || nj < 0 || nh < 0 || ni >= N || nj >= M || nh >= H) {
						continue;
					}
					if (map[nh][ni][nj] == 0) {
						map[nh][ni][nj] = 1;
						q.add(new coord(ni, nj, nh));
					}
				}
			}
			answer++;
		}
    	answer--;
    	for (int h = 0; h < H; h++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[h][i][j] == 0) {
						answer = -1;
					}
				}
			}
		}
    	System.out.println(answer);
	}
	
}