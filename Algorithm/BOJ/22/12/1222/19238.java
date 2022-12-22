package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{
	static int N, M, L;
	static int[][] map;
	static coord[] person;
	static coord[] dest;
	static int[] di = {-1, 0, 0, 1};
	static int[] dj = {0, -1, 1, 0};
	static class coord implements Comparable<coord>{
		int i, j, w;
		public coord(int i, int j) {
			this.i = i;
			this.j = j;
		}		
		public coord(int i, int j, int w) {
			this.i = i;
			this.j = j;
			this.w = w;
		}
		@Override
		public int compareTo(coord o) {
			if (this.i > o.i) {
				return 1;
			}
			else if (this.i < o.i) {
				return -1;
			}
			else {
				if (this.j > o.j) {
					return 1;
				}
				else {
					return -1;
				}
			}
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "[" +this.i + "," + this.j+"]";
		}
		
	}
	static coord now;
	static int nowPerson;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		
		now = new coord(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1);
		dest = new coord[M+2];
		person = new coord[M+2];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int si = Integer.parseInt(st.nextToken())-1;
			int sj = Integer.parseInt(st.nextToken())-1;
			int ei = Integer.parseInt(st.nextToken())-1;
			int ej = Integer.parseInt(st.nextToken())-1;
			
			map[si][sj] = i+2;
			
			person[i+2] = new coord(si, sj);
			dest[i+2] = new coord(ei, ej);	
		}
		
		boolean canGo = true;
		for (int i = 0; i < M; i++) {
			nowPerson = -1;
			if (!goPerson()) {
				canGo = false;
				break;
			}
			if (!goDest()) {
				canGo = false;
				break;
			}
		}
		System.out.println(canGo ? L : -1);
	}
	public static boolean goPerson() {
		int dist = find();
		if (dist == -1) {
			return false;
		}
		L -= dist;
		if (L < 0) {
			return false;
		}
		return true;
	}
	public static boolean goDest() {
		int dist = findDestDist();
		if (dist == -1) {
			return false;
		}
		L -= dist;
		if (L < 0) {
			return false;
		}
		L += dist*2;
		now = new coord(dest[nowPerson].i, dest[nowPerson].j);
		map[person[nowPerson].i][person[nowPerson].j] = 0;
		return true;
	}
	public static int find() {
		if (map[now.i][now.j] != 0) {
			nowPerson = map[now.i][now.j];
			return 0;
		}
		
		boolean[][] check = new boolean[N][N];
		ArrayDeque<coord> q = new ArrayDeque<>();
		check[now.i][now.j] = true;
		q.add(new coord(now.i, now.j, 0));
		int nowW = 0;
		while (!q.isEmpty()) {
			nowW += 1;
			int repeat = q.size();
			PriorityQueue<coord> pq = new PriorityQueue<>();
			for (int i = 0; i < repeat; i++) {
				coord temp = q.poll();
				for (int k = 0; k < 4; k++) {
					int ni = temp.i + di[k];
					int nj = temp.j + dj[k];
					if (ni < 0 || nj < 0 || ni >= N || nj >= N || map[ni][nj] == 1 || check[ni][nj]) {
						continue;
					}
					if (map[ni][nj] != 0) {
						pq.add(new coord(ni, nj, map[ni][nj]));
					}
					check[ni][nj] = true;
					q.add(new coord(ni, nj, temp.w + 1));
				}				
			}
			if (pq.size() != 0) {
				coord nowP = pq.poll();
				nowPerson = nowP.w;
				return nowW;
			}
		}
		return -1;
	}
	public static int findDestDist() {
		
		boolean[][] check = new boolean[N][N];
		ArrayDeque<coord> q = new ArrayDeque<>();
		coord personStart = new coord(person[nowPerson].i,person[nowPerson].j, 0);
		check[personStart.i][personStart.j] = true;
		q.add(personStart);
		
		while (!q.isEmpty()) {
			coord temp = q.poll();
			for (int k = 0; k < 4; k++) {
				int ni = temp.i + di[k];
				int nj = temp.j + dj[k];
				if (ni < 0 || nj < 0 || ni >= N || nj >= N || map[ni][nj] == 1 || check[ni][nj]) {
					continue;
				}
				if (ni == dest[nowPerson].i && nj == dest[nowPerson].j) {
					return temp.w + 1;
				}
				check[ni][nj] = true;
				q.add(new coord(ni, nj, temp.w + 1));
			}
		}
		return -1;
	}
}