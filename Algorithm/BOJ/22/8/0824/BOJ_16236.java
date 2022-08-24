package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;

public class Main {
	static int N;
	static int[] di = {-1, 0, 1, 0};
	static int[] dj = {0, -1, 0, 1};
	static int[][] map;
	static boolean[][] check;
	static shark s;
	
	static class coord implements Comparable<coord>{
		int i, j, w;
		public coord(int i, int j, int w) {
			this.i = i;
			this.j = j;
			this.w = w;
		}
		@Override
		public int compareTo(coord o) {
			// TODO Auto-generated method stub
			if (i > o.i) {
				return 1;
			}
			else if (i < o.i) {
				return -1;
			}
			else {
				if (j > o.j) {
					return 1;
				}
				else if (j < o.j) {
					return -1;
				}
				else {
					return 0;
				}
			}
		}
	}
	static class fish implements Comparable<fish>{
		coord c;
		int dist;
		public fish(coord c, int dist) {
			this.c = c;
			this.dist = dist;
		}
		@Override
		public int compareTo(fish o) {
			if (dist > o.dist) {
				return 1;
			}
			else if (dist < o.dist) {
				return -1;
			}
			else {
				return c.compareTo(o.c); 
			}
		}
		
	}
	static class shark{
		int i, j, level = 2, now = 0;
		public shark(int i, int j) {
			this.i = i;
			this.j = j;
		}
		public void eat() {
			now++;
			if (now == level) {
				level++;
				now = 0;
			}
		}
		
	}

	public static void main(String[] argv) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];

		String[] temp;
		for (int i = 0; i < N; i++) {
			temp = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(temp[j]);
				if (map[i][j] == 9) {
					s = new shark(i,j); //상어 좌표값을 객체에 넣었으니
					map[i][j] = 0; //상어가 있던 자리는 0 으로!
				}
			}
		}
		int time = 0;
		while(true) {
			check = new boolean[N][N];
			int tempTime = find();
			if (tempTime != 0) {
				time+=tempTime;
			}
			else {
				break;
			}
			
		}
		System.out.println(time);
	}
	public static int find() {
		ArrayDeque<coord> q = new ArrayDeque<>();
		PriorityQueue<fish> fishes = new PriorityQueue<>();
		q.add(new coord(s.i, s.j, 0));
		while (!q.isEmpty()) {
			coord temp = q.poll();
			for (int k = 0; k < 4; k++) {
				int ni = temp.i+di[k];
				int nj = temp.j+dj[k];
				if (ni >= 0 && ni < N && nj >= 0 && nj < N && !check[ni][nj]) {
					if (map[ni][nj] == 0) {
						check[ni][nj] = true;
						q.add(new coord(ni, nj, temp.w+1));
						}
					else {						
						if (map[ni][nj] < s.level) {
							check[ni][nj] = true;
							fishes.add(new fish(new coord(ni, nj, temp.w+1), temp.w+1));
						}
						else if (map[ni][nj] == s.level) {
							check[ni][nj] = true;
							q.add(new coord(ni, nj, temp.w+1));
						}
					}
				}
			}
		}
		if (fishes.size() != 0) {
			fish result = fishes.peek();
			s.i = result.c.i; //이동
			s.j = result.c.j; //이동
			s.eat(); // 이동과 동시에 먹기
			map[s.i][s.j] = 0; // 먹었으니까 빈칸으로 변경
			
			return result.dist; //이동한 거리만큼 시간이 걸림
		}
		else {
			return 0;
		}
	}
}