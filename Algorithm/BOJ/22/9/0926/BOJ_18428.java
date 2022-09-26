// 18428 감시 피하기
// 지겹도록 많이 풀었던 완전 탐색
// 장애물 3개를 배치하는 모든 경우에 대해서 선생님이 학생을 찾을 수 있는 지 계산하면 되는 문제
// 맵의 크기가 최대 6 * 6 이라 완전 탐색을 이용할 수 있음

package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main{
	static int N;
	static char[][] map;
	static ArrayList<coord> floors;
	static boolean check[];
	static boolean answer = false;
	
	static ArrayList<coord> teacher;
	static int[] di = {-1, 1, 0, 0};
	static int[] dj = {0, 0, -1, 1};
	
	static class coord{
		int i, j;
		
		public coord(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		for (int i = 0; i < N; i++) {
			String[] temp = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = temp[j].charAt(0);
			}
		}
		floors = new ArrayList<>();
		teacher = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 'X') {
					floors.add(new coord(i,j));
				}
				else if (map[i][j] == 'T') {
					teacher.add(new coord(i, j));
				}
			}
		}
		check = new boolean[floors.size()];
		comb(0,0);
		System.out.println(answer ? "YES" : "NO");
		
	}
	public static void comb(int idx, int cnt) {
		if (cnt == 3) {
			char[][] copy = deepcopy();
			for (int i = 0; i < floors.size(); i++) {
				if (check[i]) {
					coord temp = floors.get(i);
					copy[temp.i][temp.j] = 'O';
				}
			}
			if (!find(copy)) {
				answer = true;
			}
			return;
			
		}
		if (idx == floors.size()) {
			return;
		}
		check[idx] = true;
		comb(idx+1, cnt+1);
		check[idx] = false;
		comb(idx+1, cnt);
	}
	public static char[][] deepcopy(){
		char[][] copy = new char[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				copy[i][j] = map[i][j];
			}
		}
		return copy;
	}
	public static boolean find(char[][] findMap) {
		for (int i = 0; i < teacher.size(); i++) {
			coord temp = teacher.get(i);
			for (int k = 0; k < 4; k++) {
				int mul = 1;
				while (true) {
					int ni = temp.i +di[k]*mul;
					int nj = temp.j +dj[k]*mul++;
					if (ni < 0 || ni >= N || nj < 0 || nj >= N || findMap[ni][nj] == 'O') {
						break;
					}
					if (findMap[ni][nj] == 'S') {
						return true;
					}
				}
			}
		}
		return false;
	}
}