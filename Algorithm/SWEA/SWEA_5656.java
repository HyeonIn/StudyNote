package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Solution {
	static int N, H, W;
	static int[][] map;
	static int[] result;
	static int answer;
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static class coord{
		int i, j, w;

		public coord(int i, int j, int w) {
			this.i = i;
			this.j = j;
			this.w = w;
		}
		
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			
			String[] temp = br.readLine().split(" ");
			N = Integer.parseInt(temp[0]);
			W = Integer.parseInt(temp[1]);
			H = Integer.parseInt(temp[2]);
			
			map = new int[H][W];
			result = new int[N];
			answer = Integer.MAX_VALUE;
			for (int i = 0; i < H; i++) {
				temp = br.readLine().split(" ");
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(temp[j]);
				}
			}
			perm(0);
			System.out.printf("#%d %d\n", t+1, answer);
		}
	}
	public static void destroy(int[][] map, int i, int j) {
		if (map[i][j] == 1) {
			map[i][j] = 0;
			return;
		}
		
		ArrayDeque<coord> q = new ArrayDeque<>();
		q.add(new coord(i, j, map[i][j]));
		map[i][j] = 0;
		
		while(!q.isEmpty()) {
			coord temp = q.poll();
			for (int m = 1; m < temp.w; m++) {
				for (int k = 0; k < 4; k++) {
					int ni = temp.i + di[k]*m;
					int nj = temp.j + dj[k]*m;
					if (ni < 0 || ni >= H || nj < 0 || nj >= W) {
						continue;
					}
					if (map[ni][nj] == 0) {
						continue;
					}
					q.add(new coord(ni, nj, map[ni][nj]));
					map[ni][nj] = 0;
				}
			}
		}
	}
	public static void perm(int idx) {
		if (idx == N) {
			int copyMap[][] = copy();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < H; j++) {
					if (copyMap[j][result[i]] != 0) {
						destroy(copyMap, j, result[i]);
						blockDown(copyMap);
						break;
					}
				}
			}
			answer = Math.min(answer, countBlock(copyMap));
			return;
		}
		for (int i = 0; i < W; i++) {
			result[idx] = i;
			perm(idx+1);
		}
	}
	public static int[][] copy() {
		int[][] copyMap = new int[H][W];
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				copyMap[i][j] = map[i][j];
			}
		}
		return copyMap;
	}
	public static void blockDown(int[][] map) {
		ArrayDeque<Integer> q = new ArrayDeque<>();
		for (int i = 0; i < W; i++) {
			for (int j = H-1; j >= 0; j--) {
				q.add(map[j][i]);
				map[j][i] = 0;
			}
			int idx = H-1;
			while (!q.isEmpty()) {
				int temp = q.poll();
				if (temp != 0) {
					map[idx--][i] = temp;
				}
			}
		}
	}
	public static int countBlock(int[][] map) {
		int count = 0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (map[i][j] != 0) {
					count++;
				}
			}
		}
		return count;
	}
}
