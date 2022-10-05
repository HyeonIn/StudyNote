package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

//3187 양치기 꿍
//#으로 감싸진 영역안에서 늑대와 양의 수를 세고, 비교해서 결과에 더해준다
//bfs를 이용해서 #로 감싸진 영역안을 검사한다.
//check 배열을 활용하여 검사한 곳은 다시 검사하지 않도록 한다.
public class Main {
	static int R, C;
	static boolean[][] check;
	static char[][] map;
	
	static int[] di = {-1, 1, 0, 0};
	static int[] dj = {0, 0, 1, -1};
	static class coord{
		int i, j;

		public coord(int i, int j) {
			this.i = i;
			this.j = j;
		}
		
	}
	
	static int V = 0, K = 0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		//v : 늑대, k : 양
		
		String[] input = br.readLine().split(" ");
		
		R = Integer.parseInt(input[0]);
		C = Integer.parseInt(input[1]);
		
		check = new boolean[R][C];
		map = new char[R][C];
		
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] != '#' && !check[i][j]) {
					bfs(i, j);
				}
			}
		}
		
		System.out.println(K+" "+V);
		
	}
	public static void bfs(int i, int j) {
		ArrayDeque<coord> q = new ArrayDeque<>();
		
		
		
		q.add(new coord(i,j));
		check[i][j]= true;
		
		int tempV = 0;
		int tempK = 0;
		
		
		while (!q.isEmpty()) {
			coord temp = q.poll();
			if (map[temp.i][temp.j] == 'v') {
				tempV += 1;
			}
			else if (map[temp.i][temp.j] == 'k') {
				tempK += 1;
			}
			for (int k = 0; k < 4; k++) {
				int ni = temp.i + di[k];
				int nj = temp.j + dj[k];
				if (ni < 0 || ni >= R || nj < 0 || nj >= C) {
					continue;
				}
				if (check[ni][nj]) {
					continue;
				}
				if (map[ni][nj] == '#') {
					continue;
				}
				check[ni][nj] = true;
				q.add(new coord(ni, nj));
			}
		}
		if (tempK > tempV) {
			K += tempK;
		}
		else {
			V += tempV;
		}
	}
}