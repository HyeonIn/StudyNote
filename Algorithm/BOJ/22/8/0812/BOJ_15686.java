package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	static int n;
	static int m;
	static class coord{
		int i, j;
		public coord(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
	static int[][] map;
	static ArrayList<coord> chicken;
	static ArrayList<coord> houses;
	static boolean[] select;
	
	static int answer = Integer.MAX_VALUE;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		
		n = Integer.parseInt(temp[0]);
		m = Integer.parseInt(temp[1]);
		
		chicken = new ArrayList<>();
		map = new int[n][n];
		houses = new ArrayList<>();
		
		
		for (int i = 0; i < n; i++) {
			temp = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				if (temp[j].equals("2")) {
					chicken.add(new coord(i,j));
				}
				else if (temp[j].equals("1")) {
					houses.add(new coord(i,j));
				}
				map[i][j] = Integer.parseInt(temp[j]);
			}
		}
		select = new boolean[chicken.size()];
		
		comb(0, 0);
		
		System.out.println(answer);
	}
	public static void comb(int idx, int cnt) {
		if(cnt == m) {
			int chickenload = 0;
			
			for (int i = 0; i < houses.size(); i++) {
				int min = Integer.MAX_VALUE;
				for (int j = 0; j < chicken.size(); j++) {
					if (select[j]) {
						min = Math.min(min, getDistance(houses.get(i), chicken.get(j)));
					}
				}
				chickenload += min;
			}
			answer = Math.min(chickenload, answer);
			return;
		}
		if (idx == chicken.size()) {
			return;
		}
		select[idx] = true;
		comb(idx+1, cnt+1);
		select[idx] = false;
		comb(idx+1, cnt);
	}
	public static int getDistance(coord c1, coord c2) {
		return Math.abs(c1.i - c2.i)+Math.abs(c1.j-c2.j);
	}
}