package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class Main {
	static ArrayList<coord> result;
	static boolean[] used;
	
	static int N, M;
	static int[][] map;
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static ArrayList<coord> virus;
	
	static int answer = Integer.MIN_VALUE;
	static class coord {
		int i, j;

		public coord(int i, int j) {
			this.i = i;
			this.j = j;
		}
		
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		
		N = Integer.parseInt(temp[0]);
		M = Integer.parseInt(temp[1]);
		
		result = new ArrayList<>();
		virus = new ArrayList<>();
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			temp = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(temp[j]);
				if (map[i][j] == 0) {
					result.add(new coord(i,j));
				}
				else if (map[i][j] == 2) {
					virus.add(new coord(i, j));
				}
			}
		}
		used = new boolean[result.size()];
		
		comb(0, 0);
		
		System.out.println(answer);
	}
	public static void comb(int idx, int cnt) {
		if (cnt == 3) {
			int[][] copyMap = copy();
			for (int i = 0; i < result.size(); i++) {
				if (used[i]) {
					coord temp = result.get(i);
					copyMap[temp.i][temp.j] = 1;
				}
			}
			fluid(copyMap);
			answer = Integer.max(answer, checkArea(copyMap));
			return;
		}
		if (idx == result.size()) {
			return;
		}
		used[idx] = true;
		comb(idx+1, cnt+1);
		used[idx] = false;
		comb(idx+1, cnt);
	}
	public static int checkArea(int[][] map) {
		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					count++;
				}
			}
		}
		return count;
	}
	
	public static int[][] copy(){
		int[][] copyMap = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				copyMap[i][j] = map[i][j];
			}
		}
		return copyMap;
	}
	public static void fluid(int[][] map) {
		ArrayDeque<coord> q = new ArrayDeque<>();
		for (int i = 0; i < virus.size(); i++) {
			q.add(virus.get(i));
		}
		while (!q.isEmpty()) {
			coord temp = q.poll();
			for (int k = 0; k < 4; k++) {
				int ni = temp.i + di[k];
				int nj = temp.j + dj[k];
				if (ni < 0 || ni >= N || nj < 0 || nj >= M) {
					continue;
				}
				if (map[ni][nj] != 0) {
					continue;
				}
				map[ni][nj] = 2;
				q.add(new coord(ni, nj));
			}
		}
	}
}