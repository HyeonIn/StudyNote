package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
	static int R, C, M;
	
	static shark[][] map;
	
	static int answer;
	
	static int[] di = {0, -1, 1, 0, 0};
	static int[] dj = {0, 0, 0, 1, -1};
	
	static class shark{
		int i, j, s, d, z;
		public shark(int i, int j, int s, int d, int z) {
			this.i = i;
			this.j = j;
			this.s = s;
			this.d = d;
			this.z = z;
		}
		public shark(int s, int d, int z) {
			this.s = s;
			this.d = d;
			this.z = z;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		
		R = Integer.parseInt(input[0]);
		C = Integer.parseInt(input[1]);
		M = Integer.parseInt(input[2]);
		
		map = new shark[R+1][C+1];
		
		for (int m = 0; m < M; m++) {
			input = br.readLine().split(" ");
			int i = Integer.parseInt(input[0]);
			int j = Integer.parseInt(input[1]);
			int s = Integer.parseInt(input[2]);
			int d = Integer.parseInt(input[3]);
			int z = Integer.parseInt(input[4]);
			
			map[i][j] = new shark(s,d,z);
		}
		answer = 0;
		for (int j = 1; j <= C; j++) {
			
			hunt(j);
			move();
			
		}
		System.out.println(answer);
		
	}
	public static void hunt(int j) {
		for (int i = 1; i <= R; i++) {
			if (map[i][j] != null) {
				answer += map[i][j].z;
				map[i][j] = null;
				break;
			}
		}
	}
	public static void move() {
		ArrayDeque<shark> q = new ArrayDeque<>();
		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				if (map[i][j] != null) {
					q.add(new shark(i, j, map[i][j].s, map[i][j].d, map[i][j].z));
				}
			}
		}
		shark[][] nextMap = new shark[R+1][C+1];
		while (!q.isEmpty()) {
			shark temp = q.poll();
			int ni = temp.i, nj = temp.j, nd = temp.d;
			if (temp.d == 1) {
				if (temp.s > temp.i-1) {
					int ss = temp.s-(temp.i-1);
					if ((ss/(R-1))%2 == 0) {
						ni = 1+ss%(R-1);
						nd = nd+1;
					}
					else {
						ni = R-(ss%(R-1));
					}
				}else if (temp.s == temp.i-1) {
					ni = 1;
					nd = nd+1;
				}else {
					ni = temp.i-temp.s;
				}
			}
			else if (temp.d == 2) {
				if (temp.s > R-temp.i) {
					int ss = temp.s-(R-temp.i);
					if ((ss/(R-1))%2 == 0) {
						ni = R-(ss%(R-1));
						nd = nd-1;
					}
					else {
						ni = 1+ss%(R-1);
					}
				}else if (temp.s == R-temp.i) {
					ni = R;
					nd = temp.d-1;
				}else {
					ni = temp.s+temp.i;
				}
			}
			else if (temp.d == 3) {
				if (temp.s > C-temp.j) {
					int ss = temp.s-(C-temp.j);
					if ((ss/(C-1))%2 == 0) {
						nj = C-(ss%(C-1));
						nd = nd+1;
					}
					else {
						nj = 1+ss%(C-1);
					}
				}else if (temp.s == C-temp.j) {
					nj = C;
					nd = temp.d+1;
				}else {
					nj = temp.s+temp.j;
				}
			}
			else {
				if (temp.s > temp.j-1) {
					int ss = temp.s-(temp.j-1);
					if ((ss/(C-1))%2 == 0) {
						nj = 1+ss%(C-1);
						nd = nd-1;
					}
					else {
						nj = C-(ss%(C-1));
					}
				}else if (temp.s == temp.j-1) {
					nj = 1;
					nd = nd-1;
				}else {
					nj = temp.j-temp.s;
				}
			}
			if (nextMap[ni][nj] != null) {
				if (temp.z > nextMap[ni][nj].z) {
					nextMap[ni][nj] = new shark(temp.s, nd, temp.z);
				}
			}else {
				nextMap[ni][nj] = new shark(temp.s, nd, temp.z);
			}
		}
		map = nextMap;
	}
}