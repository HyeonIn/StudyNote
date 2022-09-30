//1189 컴백홈
// 깊이 우선 탐색으로 모든 경로에 대해 탐색을 하면서 길이가 K가 되는 경우에 카운팅했다

package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int R, C, K;
	static char[][] arr;
	static boolean[][] check;
	static int answer = 0;
	static int[] di = {-1, 1, 0, 0};
	static int[] dj = {0, 0, -1, 1};
	static class coord{
		int x, y;
		public coord(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		
		R = Integer.parseInt(temp[0]);
		C = Integer.parseInt(temp[1]);
		K = Integer.parseInt(temp[2]);
		arr = new char[R][C];
		check = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		
		check[R-1][0] = true;
		dfs(R-1,0,1);
		System.out.println(answer);
	}
	public static void dfs(int i, int j, int count) {
		if (i == 0 && j == C-1) {
			if (count == K) {
				answer++;
			}
			return;
		}
		for (int k = 0; k < 4; k++) {
			
			int ni = i+di[k];
			int nj = j+dj[k];
			if (ni < 0 || ni >= R || nj < 0 || nj >= C || check[ni][nj] == true || arr[ni][nj] == 'T') {
				continue;
			}
			check[ni][nj] = true;
			dfs(ni, nj, count+1);
			check[ni][nj] = false;
		}
	}
}
