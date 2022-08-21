package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static class food{
		int taste;
		int cal;
		
		public food(int taste, int cal) {
			this.taste = taste;
			this.cal = cal;
		}
	}
	static boolean[] select; 
	static food[] foods;
	static int n;
	static int L;
	static int answer;
	static int tempCal;
	static int tempTaste;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			String[] temp = br.readLine().split(" ");
			
			n = Integer.parseInt(temp[0]);
			L = Integer.parseInt(temp[1]);
			
			
			foods = new food[n];
			select = new boolean[n];
			answer = 0;
			tempCal = 0;
			tempTaste = 0;
			
			for (int i = 0; i < n; i++) {
				temp = br.readLine().split(" ");
				foods[i] = new food(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]));
			}
			
			powerset(0);
			
			System.out.printf("#%d %d\n" , t, answer);
		}
		
	}
	public static void powerset(int idx) {
		if (idx == n) {
			answer = Math.max(answer, tempTaste);
			return;
		}
		if (tempCal + foods[idx].cal <= L) {
			
			select[idx] = true;
			tempCal += foods[idx].cal;
			tempTaste += foods[idx].taste;
			powerset(idx+1);
			
			select[idx] = false;
			tempCal -= foods[idx].cal;
			tempTaste -= foods[idx].taste;
			
			powerset(idx+1);
		}
		else {
			powerset(idx+1);
		}
	}
}