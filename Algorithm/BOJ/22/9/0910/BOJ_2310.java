package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main{
	static class room{
		LinkedList<Integer> r;
		char t;
		int cost;
		public room(char t, int cost) {
			this.t = t;
			this.cost = cost;
			r = new LinkedList<>();
		}
	}
	static room[] maze;
	static boolean[] check;
	static boolean answer;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			N = Integer.parseInt(br.readLine());
			
			if (N == 0) {
				break;
			}
			
			maze = new room[N+1];
			check = new boolean[N+1];
			answer = false;
			for (int i = 1; i < N+1; i++) {
				String[] temp = br.readLine().split(" ");
				room tempRoom = new room(temp[0].charAt(0), Integer.parseInt(temp[1]));
				for (int j = 2; j < temp.length-1; j++) {
					tempRoom.r.add(Integer.parseInt(temp[j]));
				}
				maze[i] = tempRoom;
			}
			checkGo(1, 0);
			
			System.out.println(answer? "Yes" : "No");
		}
	}
	public static void checkGo(int r, int money) {
		if (maze[r].t == 'T') {
			if (maze[r].cost <= money) {
				money -= maze[r].cost;
				check[r] = true;
				if (r == N) {
					answer = true;
				}
				for (int room : maze[r].r) {
					if (!check[room]) {
						checkGo(room, money);
					}
				}
				if (!answer) {
					check[r] = false;
				}
			}
		}
		else if (maze[r].t == 'L') {
			if (r == N) {
				answer = true;
			}
			if (maze[r].cost > money) {
				money = maze[r].cost;
			}
			check[r] = true;
			
			for (int room : maze[r].r) {
				if (!check[room]) {
					checkGo(room, money);
				}
			}
			if (!answer) {
				check[r] = false;
			}
		}
		else {
			if (r == N) {
				answer = true;
			}
			check[r] = true;
			for (int room : maze[r].r) {
				if (!check[room]) {
					checkGo(room, money);
				}
			}
			if (!answer) {
				check[r] = false;
			}
		}
	}
}