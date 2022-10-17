import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

// 5427 불
// 예전에 풀었던 탈출 문제와 비슷한 유형의 문제
// 불이 번질 지점을 먼저 예상해서 상근이가 탈출할 수 있는 경로를 찾아가는 문제
// BFS를 활용하여 불을 번지게 하고 상근이가 이동한다.

public class Main {
	static int N, M, time;
	static char[][] map;
	static class coord{
		int i, j;

		public coord(int i, int j) {
			this.i = i;
			this.j = j;
		}
		
	}
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static boolean answer;
	static ArrayDeque<coord> s;
	static ArrayDeque<coord> f;
	static boolean[][] check;
    public static void main(String[] args) throws IOException {    
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int T = Integer.parseInt(br.readLine());    	
    	StringTokenizer st;
    	for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			map = new char[N][M];
			check = new boolean[N][M];
			s = new ArrayDeque<>();
			f = new ArrayDeque<>();
			for (int i = 0; i < N; i++) {
				map[i] = br.readLine().toCharArray();
				for (int j = 0; j < M; j++) {
					if (map[i][j] == '@') {
						map[i][j] = '.';
						s.add(new coord(i,j));
						check[i][j] = true;
					}
					else if(map[i][j] == '*') {
						f.add(new coord(i,j));
					}
				}
 			}
			answer = false;
			int time = 1;
			while (true) {
				fire();
				move();
				if (answer) {
					System.out.println(time);
					break;
				}
				if (s.isEmpty()) {
					System.out.println("IMPOSSIBLE");
					break;
				}
				time++;
			}
			
			
		}
    }
	public static void fire() {
		int repeat = f.size();
		for (int i = 0; i < repeat; i++) {
			coord temp = f.poll();
			for (int j = 0; j < 4; j++) {
				int ni = temp.i + di[j];
				int nj = temp.j + dj[j];
				
				if (ni < 0 || nj < 0 || ni >= N || nj >=M) {
					continue;
				}
				if (map[ni][nj] == '.') {
					map[ni][nj] = '*';
					f.add(new coord(ni, nj));			
				}
			}
		}
	}
	public static void move() {
		int repeat = s.size();
			
		for (int i = 0; i < repeat; i++) {
			coord temp = s.poll();
			if (temp.i == 0 || temp.j == 0 || temp.i == N-1 || temp.j == M-1) {
				answer = true;
			}
			for (int j = 0; j < 4; j++) {
				int ni = temp.i + di[j];
				int nj = temp.j + dj[j];
				
				if (ni < 0 || nj < 0 || ni >= N || nj >=M) {
					continue;
				}
				if (check[ni][nj]) {
					continue;
				}
				if (map[ni][nj] == '.') {
					
					check[ni][nj] = true;
					s.add(new coord(ni, nj));			
				}
			}
		}
	}
}