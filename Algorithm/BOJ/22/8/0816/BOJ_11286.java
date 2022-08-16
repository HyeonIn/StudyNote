package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;


public class Main {
	static class MyInteger implements Comparable<MyInteger>{
		private int x;
		
		public MyInteger(int x) {
			this.x = x;
		}
		@Override
		public int compareTo(MyInteger o) {
			if (Math.abs(this.x) > Math.abs(o.x)) {
				return 1;
			}
			else if (Math.abs(this.x) < Math.abs(o.x)) {
				return -1;
			}
			else {
				if (this.x > o.x) {
					return 1;
				}
				else if (this.x < o.x) {
					return -1;
				}
				else {
					return 0;
				}
			}
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return ""+x;
		}
	}
	static PriorityQueue<MyInteger> heap = new PriorityQueue<>();
	static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		
		for (int i = 0; i < n; i++) {
			int x = Integer.parseInt(br.readLine());
			if (x == 0) {
				System.out.println(heap.isEmpty() ? 0 : heap.poll());
			}
			else {
				heap.add(new MyInteger(x));
			}
		}
	}
}

