package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static char[][] map;
    static boolean[][] check;
    static char[] wood = {'-', '|'};
	static int[] di = {0,1};
	static int[] dj = {1,0};
	static class coord{
		int i, j;

		public coord(int i, int j) {
			this.i = i;
			this.j = j;
		}
		
	}
    public static void main(String[] args) throws IOException {    
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	
    	map = new char[N][M];
    	check = new boolean[N][M];
    	for (int i = 0; i < N; i++) {
    		map[i] = br.readLine().toCharArray();
    	}
    	int count= 0;
    	for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (check[i][j]) {
					continue;
				}
				else {
					count++;
					bfs(i,j);
				}
			}
		}
    	System.out.println(count);
    }
	public static void bfs(int i, int j) {
		ArrayDeque<coord> q = new ArrayDeque<>();
		q.add(new coord(i, j));
		check[i][j] = true;
		
		while (!q.isEmpty()) {
			coord temp = q.poll();
			for (int k = 0; k < 2; k++) {
				int ni = temp.i+di[k];
				int nj = temp.j+dj[k];
				if (ni < 0 || nj < 0 || ni >= N || nj >= M) {
					continue;
				}
				if (check[ni][nj]) {
					continue;
				}
				if (map[i][j] == wood[k] && map[ni][nj] == wood[k]) {
					check[ni][nj] = true;
					q.add(new coord(ni, nj));
				}
			}
		}
		
	}
}