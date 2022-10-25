package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M, count, answer;
	static int[][] map;
	static boolean[][] check;
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	
	static int[][] weight;
	static int[] result;
	static boolean[] select;
	
	static class coord{
		int i, j, w;

		public coord(int i, int j, int w) {
			this.i = i;
			this.j = j;
			this.w = w;
		}
		
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력 받기 위한 버퍼리더
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken()); 
		N = Integer.parseInt(st.nextToken());
		count = 0;
		map = new int[N][M];
		coord s, e = new coord(0,0,0);
		ArrayList<coord> clist = new ArrayList<>();
		clist.add(new coord(0,0,1));
		for (int i = 0; i < N; i++) {
			char[] c = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				if (c[j] == 'S') {
					map[i][j] = 0;
					s = new coord(i, j, 0);
					clist.set(0, s);
				}
				else if (c[j] == 'E') {
					map[i][j] = 8;
					e = new coord(i, j, 0);
				}
				else if (c[j] == '#') {
					map[i][j] = -1;
				}
				else if (c[j] == '.') {
					map[i][j] = 9;
				}
				else {
					clist.add(new coord(i,j,0));
					map[i][j] = ++count;
				}
			}
		}
		clist.add(e);
		weight = new int[count+1][count+2];
		
		for (int i = 0; i < count+1; i++) {
			weight[i][i] = 0;
			bfs(clist.get(i), i);
		}
		
		if (count != 0) {
			answer = Integer.MAX_VALUE;
			select = new boolean[count+1];
			result = new int[count];
			perm(0);
			System.out.println(answer);
		}
		else {
			System.out.println(weight[0][1]);
		}
		
	}
	public static void bfs(coord c, int n) {
		ArrayDeque<coord> q = new ArrayDeque<>();
		check = new boolean[N][M];
		check[c.i][c.j] = true;
		q.add(c);
		while (!q.isEmpty()) {
			coord temp = q.poll();
			for (int i = 0; i < 4; i++) {
				int ni = temp.i + di[i];
				int nj = temp.j + dj[i];
				if (ni < 0 || nj < 0 || ni >= N || nj >= M || map[ni][nj] == -1 || check[ni][nj]) {
					continue;
				}
				if (map[ni][nj] != 9) {
					if (map[ni][nj] == 8) {
						weight[n][count+1] = temp.w+1;
					}
					else {
						weight[n][map[ni][nj]] = temp.w+1;
					}
				}
				check[ni][nj] = true;
				q.add(new coord(ni,nj,temp.w+1));
			}
		}
	}
	public static void perm(int idx) {
		if (idx == count) {
			int temp = 0;
			temp += weight[0][result[0]];
			for (int i = 0; i < count-1; i++) {
				temp += weight[result[i]][result[i+1]];
			}
			temp += weight[result[count-1]][count+1];
			answer = Integer.min(answer, temp);
			return;
		}
		for (int i = 1; i <= count; i++) {
			if (!select[i]) {
				result[idx] = i;
				select[i] = true;
				perm(idx+1);
				select[i] = false;
			}
		}
	}
}
