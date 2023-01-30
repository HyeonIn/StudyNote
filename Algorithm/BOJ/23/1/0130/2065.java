package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class person implements Comparable<person>{
		int time, dir, idx;
		public person(int time, int dir, int idx) {
			this.time = time;
			this.dir = dir;
			this.idx = idx;
		}
		@Override
		public int compareTo(person o) {
			if (this.time > o.time) {
				return 1;
			}
			else if (this.time < o.time) {
				return -1;
			}
			else {
				if (this.idx > o.idx) {
					return 1;
				}
				else {
					return -1;
				}
			}
		}
	}
	
	static int[] arrive;
	static int M, t, N, time, count, movePeople, ship, shipBefore;
	static PriorityQueue<person> passenger;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		
		PriorityQueue<person> left = new PriorityQueue<>();
		PriorityQueue<person> right = new PriorityQueue<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			person p = new person(Integer.parseInt(st.nextToken()), st.nextToken().equals("left") ? 0 : 1, i);
			if (p.dir == 0) {
				left.add(p);
			}
			else {
				right.add(p);
			}
		}
		
		arrive = new int[N];
		passenger = new PriorityQueue<>();
		time = 0; count = 0; movePeople = N; ship = 0; shipBefore = 0;
		
		while (movePeople > 0) {
			if (ship == 0) { //왼쪽 정박
				out();
				in(left);
				go(right, 0);
			}
			else if (ship == 1) { //오른쪽 정박
				out();
				in(right);
				go(left, 1);
			}
			else { //운행중
				count++; //운행 시간 증가
				if (count == t-1) {
					count = 0;
					ship = shipBefore == 1 ? 0 : 1;
				}
			}
			time++;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(arrive[i]).append("\n");
		}
		System.out.print(sb);
	}
	public static void out() {
		while (!passenger.isEmpty()) {
			person tmp = passenger.poll();
			arrive[tmp.idx] = time;
			movePeople--;
		}
	}
	public static void in(PriorityQueue<person> type) {
		if (!type.isEmpty()) {					
			while(type.peek().time <= time) {
				if (passenger.size() == M) {
					break;
				}
				passenger.add(type.poll());
				if (type.isEmpty()) {
					break;
				}
			}
		}
	}
	public static void go(PriorityQueue<person> type, int state) {
		if (!passenger.isEmpty()) {
			ship = 2;
			shipBefore = state;
		}
		else {
			if (!type.isEmpty() && type.peek().time <= time) {
				ship = 2;
				shipBefore = state;
			}
		}
	}
}
